<template>
    <div>
        <Number
            label="TaskId"
            v-model="value.taskId"
            :editMode="editMode"
        />
        <Number
            label="WritingId"
            v-model="value.writingId"
            :editMode="editMode"
        />
        <String
            label="TaskType"
            v-model="value.taskType"
            :editMode="editMode"
        />
        <String
            label="Status"
            v-model="value.status"
            :editMode="editMode"
        />
        <Date
            label="RequestedAt"
            v-model="value.requestedAt"
            :editMode="editMode"
        />
        <Date
            label="CompletedAt"
            v-model="value.completedAt"
            :editMode="editMode"
        />
        <String
            label="ResultImage"
            v-model="value.resultImage"
            :editMode="editMode"
        />
        <String
            label="Resultsummary"
            v-model="value.resultsummary"
            :editMode="editMode"
        />
        <File
            offline
            label="ResultPdf"
            v-model="value.resultPdf"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Ai',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "ais",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
