<template>
    <v-card outlined>
        <v-card-title>
            CreateNewGuide
        </v-card-title>

        <v-card-text>
            <String label="GuideId" v-model="value.guideId" :editMode="editMode"/>
            <String label="GuideTitle" v-model="value.guideTitle" :editMode="editMode"/>
            <String label="GuideContent" v-model="value.guideContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createNewGuide"
            >
                CreateNewGuide
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
        name: 'CreateNewGuideCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.guideId = '';
            this.value.guideTitle = '';
            this.value.guideContent = '';
        },
        watch: {
        },
        methods: {
            createNewGuide() {
                this.$emit('createNewGuide', this.value);
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

