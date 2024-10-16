<template>
    <v-card outlined>
        <v-card-title>
            UpdateProjectInfo
        </v-card-title>

        <v-card-text>
            <String label="ProjectId" v-model="value.projectId" :editMode="editMode"/>
            <String label="ProjectName" v-model="value.projectName" :editMode="editMode"/>
            <String label="ProjectInfo" v-model="value.projectInfo" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateProjectInfo"
            >
                UpdateProjectInfo
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateProjectInfoCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.projectId = '';
            this.value.projectName = '';
            this.value.projectInfo = '';
        },
        watch: {
        },
        methods: {
            updateProjectInfo() {
                this.$emit('updateProjectInfo', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

