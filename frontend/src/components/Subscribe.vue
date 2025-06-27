<template>
    <div>
        <Number
            label="SubscriptionId"
            v-model="value.subscriptionId"
            :editMode="editMode"
        />
        <String
            label="Status"
            v-model="value.status"
            :editMode="editMode"
        />
        <Date
            label="StartDate"
            v-model="value.startDate"
            :editMode="editMode"
        />
        <Date
            label="EndDate"
            v-model="value.endDate"
            :editMode="editMode"
        />
        <Number
            label="Price"
            v-model="value.price"
            :editMode="editMode"
        />
        <Number
            label="SubcriberId"
            v-model="value.subcriberId"
            :editMode="editMode"
        />
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <구독자Id
            offline
            label="구독자 ID"
            v-model="value.구독자Id"
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
    name: 'Subscribe',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscribes",
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
