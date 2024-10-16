<template>
    <v-card outlined>
        <v-card-title>
            DeleteTaskAssignment
        </v-card-title>

        <v-card-text>
            <String label="ProjectId" v-model="value.projectId" :editMode="editMode"/>
            <String label="TaskId" v-model="value.taskId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteTaskAssignment"
            >
                DeleteTaskAssignment
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
        name: 'DeleteTaskAssignmentCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.projectId = '';
            this.value.taskId = '';
        },
        watch: {
        },
        methods: {
            deleteTaskAssignment() {
                this.$emit('deleteTaskAssignment', this.value);
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

