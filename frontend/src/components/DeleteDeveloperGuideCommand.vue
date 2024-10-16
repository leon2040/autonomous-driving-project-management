<template>
    <v-card outlined>
        <v-card-title>
            DeleteDeveloperGuide
        </v-card-title>

        <v-card-text>
            <String label="GuideId" v-model="value.guideId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="deleteDeveloperGuide"
            >
                DeleteDeveloperGuide
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
        name: 'DeleteDeveloperGuideCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.guideId = '';
        },
        watch: {
        },
        methods: {
            deleteDeveloperGuide() {
                this.$emit('deleteDeveloperGuide', this.value);
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

