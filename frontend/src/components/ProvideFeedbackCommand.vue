<template>
    <v-card outlined>
        <v-card-title>
            ProvideFeedback
        </v-card-title>

        <v-card-text>
            <String label="ProjectId" v-model="value.projectId" :editMode="editMode"/>
            <String label="Feedback" v-model="value.feedback" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="provideFeedback"
            >
                ProvideFeedback
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
        name: 'ProvideFeedbackCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.projectId = '';
            this.value.feedback = '';
        },
        watch: {
        },
        methods: {
            provideFeedback() {
                this.$emit('provideFeedback', this.value);
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

