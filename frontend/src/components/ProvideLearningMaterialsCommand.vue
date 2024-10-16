<template>
    <v-card outlined>
        <v-card-title>
            ProvideLearningMaterials
        </v-card-title>

        <v-card-text>
            <String label="EducationId" v-model="value.educationId" :editMode="editMode"/>
            <String label="Material" v-model="value.material" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="provideLearningMaterials"
            >
                ProvideLearningMaterials
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
        name: 'ProvideLearningMaterialsCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.educationId = '';
            this.value.material = '';
        },
        watch: {
        },
        methods: {
            provideLearningMaterials() {
                this.$emit('provideLearningMaterials', this.value);
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

