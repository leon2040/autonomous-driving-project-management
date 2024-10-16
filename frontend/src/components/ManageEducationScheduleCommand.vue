<template>
    <v-card outlined>
        <v-card-title>
            ManageEducationSchedule
        </v-card-title>

        <v-card-text>
            <String label="EducationId" v-model="value.educationId" :editMode="editMode"/>
            <String label="Schedule" v-model="value.schedule" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="manageEducationSchedule"
            >
                ManageEducationSchedule
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
        name: 'ManageEducationScheduleCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.educationId = '';
            this.value.schedule = '';
        },
        watch: {
        },
        methods: {
            manageEducationSchedule() {
                this.$emit('manageEducationSchedule', this.value);
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

