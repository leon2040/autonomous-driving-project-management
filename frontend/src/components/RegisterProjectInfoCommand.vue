<template>
    <v-card outlined>
        <v-card-title>
            RegisterProjectInfo
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
                    @click="registerProjectInfo"
            >
                RegisterProjectInfo
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
        name: 'RegisterProjectInfoCommand',
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
            registerProjectInfo() {
                this.$emit('registerProjectInfo', this.value);
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

