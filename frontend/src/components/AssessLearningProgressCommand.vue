<template>
    <v-card outlined>
        <v-card-title>
            AssessLearningProgress
        </v-card-title>

        <v-card-text>
            <String label="EducationId" v-model="value.educationId" :editMode="editMode"/>
            <String label="Progress" v-model="value.progress" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="assessLearningProgress"
            >
                AssessLearningProgress
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
        name: 'AssessLearningProgressCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.educationId = '';
            this.value.progress = '';
        },
        watch: {
        },
        methods: {
            assessLearningProgress() {
                this.$emit('assessLearningProgress', this.value);
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

