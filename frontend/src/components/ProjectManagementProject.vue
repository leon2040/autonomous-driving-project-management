<template>
    <v-card style="width:450px; height:100%;" outlined>
        <template slot="progress">
            <v-progress-linear
                    color="primary-darker-1"
                    height="10"
                    indeterminate
            ></v-progress-linear>
        </template>

        <v-card-title v-if="value._links">
            프로젝트 # {{decode(value._links.self.href.split("/")[value._links.self.href.split("/").length - 1])}}
        </v-card-title >
        <v-card-title v-else>
            프로젝트
        </v-card-title >        

        <v-card-text>
            <String v-if="editMode" label="프로젝트 ID" v-model="value.projectId" :editMode="editMode" :inputUI="''"/>
            <String label="프로젝트명" v-model="value.projectName" :editMode="editMode" :inputUI="''"/>
            <String label="프로젝트 정보" v-model="value.projectInfo" :editMode="editMode" :inputUI="''"/>
            <String label="팀원" v-model="value.teamMembers" :editMode="editMode" :inputUI="''"/>
            <TaskAssignmentManager offline label="업무 할당" v-model="value.taskAssignments" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                color="primary"
                text
                @click="edit"
                v-if="!editMode"
            >
                수정
            </v-btn>
            <div v-else>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    프로젝트 정보 등록
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    프로젝트 정보 삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    업무 할당 생성
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    업무 할당 삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    프로젝트 진행 상황 모니터링
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    시스템 성능 점검
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="save"
                >
                    피드백 제공
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
                >
                    삭제
                </v-btn>
                <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode && !isNew"
                >
                    취소
                </v-btn>
            </div>
        </v-card-actions>
        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn  
                :disabled="!userRoles.includes('Administrator')"
                v-if="!editMode"
                color="primary"
                text
                @click="openUpdateProjectInfo"
            >
                UpdateProjectInfo
            </v-btn>
            <v-dialog v-model="updateProjectInfoDiagram" width="500">
                <UpdateProjectInfoCommand
                    @closeDialog="closeUpdateProjectInfo"
                    @updateProjectInfo="updateProjectInfo"
                ></UpdateProjectInfoCommand>
            </v-dialog>
            <v-btn  
                :disabled="!userRoles.includes('Administrator')"
                v-if="!editMode"
                color="primary"
                text
                @click="openUpdateTaskAssignment"
            >
                UpdateTaskAssignment
            </v-btn>
            <v-dialog v-model="updateTaskAssignmentDiagram" width="500">
                <UpdateTaskAssignmentCommand
                    @closeDialog="closeUpdateTaskAssignment"
                    @updateTaskAssignment="updateTaskAssignment"
                ></UpdateTaskAssignmentCommand>
            </v-dialog>
        </v-card-actions>

        <v-snackbar
            v-model="snackbar.status"
            :top="true"
            :timeout="snackbar.timeout"
            color="error"
        >
            {{ snackbar.text }}
            <v-btn dark text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
    </v-card>

</template>

<script>
    const axios = require('axios').default;


    export default {
        name: 'ProjectManagementProject',
        components:{
        },
        props: {
            value: [Object, String, Number, Boolean, Array],
            editMode: Boolean,
            isNew: Boolean,
            offline: Boolean,
        },
        data: () => ({
            snackbar: {
                status: false,
                timeout: 5000,
                text: '',
                userRole: ''
            },
            updateProjectInfoDiagram: false,
            updateTaskAssignmentDiagram: false,
        }),
	async created() {
            var me = this

            me.userRole = me.$OAuth.tokenParsed.realm_access.roles;
        },
        methods: {
            decode(value) {
                return decodeURIComponent(value);
            },
            selectFile(){
                if(this.editMode == false) {
                    return false;
                }
                var me = this
                var input = document.createElement("input");
                input.type = "file";
                input.accept = "image/*";
                input.id = "uploadInput";
                
                input.click();
                input.onchange = function (event) {
                    var file = event.target.files[0]
                    var reader = new FileReader();

                    reader.onload = function () {
                        var result = reader.result;
                        me.imageUrl = result;
                        me.value.photo = result;
                        
                    };
                    reader.readAsDataURL( file );
                };
            },
            edit() {
                this.editMode = true;
            },
            async save(){
                try {
                    var temp = null;

                    if(!this.offline) {
                        if(this.isNew) {
                            temp = await axios.post(axios.fixUrl('/projects'), this.value)
                        } else {
                            temp = await axios.put(axios.fixUrl(this.value._links.self.href), this.value)
                        }
                    }

                    if(this.value!=null) {
                        for(var k in temp.data) this.value[k]=temp.data[k];
                    } else {
                        this.value = temp.data;
                    }

                    this.editMode = false;
                    this.$emit('input', this.value);

                    if (this.isNew) {
                        this.$emit('add', this.value);
                    } else {
                        this.$emit('edit', this.value);
                    }

                    location.reload()

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
                
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.value._links.self.href))
                    }

                    this.editMode = false;
                    this.isDeleted = true;

                    this.$emit('input', this.value);
                    this.$emit('delete', this.value);

                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            change(){
                this.$emit('input', this.value);
            },
            async updateProjectInfo(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links[''].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeUpdateProjectInfo();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openUpdateProjectInfo() {
                this.updateProjectInfoDiagram = true;
            },
            closeUpdateProjectInfo() {
                this.updateProjectInfoDiagram = false;
            },
            async updateTaskAssignment(params) {
                try {
                    if(!this.offline) {
                        var temp = await axios.put(axios.fixUrl(this.value._links[''].href), params)
                        for(var k in temp.data) {
                            this.value[k]=temp.data[k];
                        }
                    }

                    this.editMode = false;
                    this.closeUpdateTaskAssignment();
                } catch(e) {
                    this.snackbar.status = true
                    if(e.response && e.response.data.message) {
                        this.snackbar.text = e.response.data.message
                    } else {
                        this.snackbar.text = e
                    }
                }
            },
            openUpdateTaskAssignment() {
                this.updateTaskAssignmentDiagram = true;
            },
            closeUpdateTaskAssignment() {
                this.updateTaskAssignmentDiagram = false;
            },
        },
    }
</script>

