<template>
    <div>
        <String
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Number
            label="Balance"
            v-model="value.balance"
            :editMode="editMode"
        />
        <String
            label="History"
            v-model="value.history"
            :editMode="editMode"
        />
        <Date
            label="UpdateAt"
            v-model="value.updateAt"
            :editMode="editMode"
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
    name: '포인트',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "포인트",
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
