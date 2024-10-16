<template>
    <v-card outlined>
        <v-card-title>
            GiveFeedback
        </v-card-title>

        <v-card-text>
            <String label="EducationId" v-model="value.educationId" :editMode="editMode"/>
            <String label="Feedback" v-model="value.feedback" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="giveFeedback"
            >
                GiveFeedback
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
        name: 'GiveFeedbackCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.educationId = '';
            this.value.feedback = '';
        },
        watch: {
        },
        methods: {
            giveFeedback() {
                this.$emit('giveFeedback', this.value);
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

