<template>
    <v-card outlined>
        <v-card-title>
            UpdateTaskAssignment
        </v-card-title>

        <v-card-text>
            <String label="ProjectId" v-model="value.projectId" :editMode="editMode"/>
            <String label="TaskId" v-model="value.taskId" :editMode="editMode"/>
            <String label="Developer" v-model="value.developer" :editMode="editMode"/>
            <String label="Task" v-model="value.task" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateTaskAssignment"
            >
                UpdateTaskAssignment
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
        name: 'UpdateTaskAssignmentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.projectId = '';
            this.value.taskId = '';
            this.value.developer = '';
            this.value.task = '';
        },
        watch: {
        },
        methods: {
            updateTaskAssignment() {
                this.$emit('updateTaskAssignment', this.value);
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

