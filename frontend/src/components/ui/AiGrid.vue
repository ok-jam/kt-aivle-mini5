<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>WritingId</th>
                        <th>TaskType</th>
                        <th>Status</th>
                        <th>RequestedAt</th>
                        <th>CompletedAt</th>
                        <th>ResultImage</th>
                        <th>Resultsummary</th>
                        <th>ResultPdf</th>
                        <th>AI(GPT)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="WritingId">{{ val.writingId }}</td>
                            <td class="whitespace-nowrap" label="TaskType">{{ val.taskType }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="RequestedAt">{{ val.requestedAt }}</td>
                            <td class="whitespace-nowrap" label="CompletedAt">{{ val.completedAt }}</td>
                            <td class="whitespace-nowrap" label="ResultImage">{{ val.resultImage }}</td>
                            <td class="whitespace-nowrap" label="Resultsummary">{{ val.resultsummary }}</td>
                            <td class="whitespace-nowrap" label="AI(GPT)">
                                <AiGptId :editMode="editMode" v-model="val.aiGptId"></AiGptId>
                            </td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Ai 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Ai :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Ai 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="TaskId" v-model="selectedRow.taskId" :editMode="true"/>
                            <Number label="WritingId" v-model="selectedRow.writingId" :editMode="true"/>
                            <String label="TaskType" v-model="selectedRow.taskType" :editMode="true"/>
                            <String label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <Date label="RequestedAt" v-model="selectedRow.requestedAt" :editMode="true"/>
                            <Date label="CompletedAt" v-model="selectedRow.completedAt" :editMode="true"/>
                            <String label="ResultImage" v-model="selectedRow.resultImage" :editMode="true"/>
                            <String label="Resultsummary" v-model="selectedRow.resultsummary" :editMode="true"/>
                            <File offline label="ResultPdf" v-model="selectedRow.resultPdf" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'aiGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'ais',
    }),
    watch: {
    },
    methods:{
    }
}

</script>