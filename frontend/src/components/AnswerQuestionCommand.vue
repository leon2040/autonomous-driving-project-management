<template>
    <v-card outlined>
        <v-card-title>
            AnswerQuestion
        </v-card-title>

        <v-card-text>
            <String label="QuestionId" v-model="value.questionId" :editMode="editMode"/>
            <String label="Question" v-model="value.question" :editMode="editMode"/>
            <String label="Answer" v-model="value.answer" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="answerQuestion"
            >
                AnswerQuestion
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
        name: 'AnswerQuestionCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.questionId = '';
            this.value.question = '';
            this.value.answer = '';
        },
        watch: {
        },
        methods: {
            answerQuestion() {
                this.$emit('answerQuestion', this.value);
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

