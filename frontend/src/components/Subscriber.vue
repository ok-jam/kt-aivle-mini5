<template>
    <div>
        <Number
            label="SubscriberId"
            v-model="value.subscriberId"
            :editMode="editMode"
        />
        <String
            label="Name"
            v-model="value.name"
            :editMode="editMode"
        />
        <String
            label="Email"
            v-model="value.email"
            :editMode="editMode"
        />
        <String
            label="Password"
            v-model="value.password"
            :editMode="editMode"
        />
        <Boolean
            label="Kttelecom"
            v-model="value.kttelecom"
            :editMode="editMode"
        />
        <Date
            label="JoinedAt"
            v-model="value.joinedAt"
            :editMode="editMode"
        />
        <Boolean
            label="SubscriptionType"
            v-model="value.subscriptionType"
            :editMode="editMode"
        />
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <div variant="outlined" class="my-2">
            <Number
                label="Jjim"
                v-model="jjimInput"
                :editMode="editMode"
                @keydown.enter="addJjimList"
            />
            <v-card v-if="value.jjim.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>
                    Jjim List
                </v-card-sub-title>
                <li v-for="(name, index) in value.jjim" :key="index">
                    {{ name }}
                </li>
            </v-card>
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addJjimList">
                    Jjim 추가
                </v-btn>
            </v-row>
            
            <LongDetailGrid
                label="Jjim"
                offline
                v-model="value.jjim"
                :editMode="editMode"
                @change="change"
            />
        </div>
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <Number
            label="Reviews"
            v-model="value.reviews"
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
    name: 'Subscriber',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "subscribers",
        jjimInput: null,
        value: {
            jjim: [],
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
        addJjimList() {
            if (this.jjimInput !== null && this.jjimInput !== '') {
                this.value.jjim.push(this.jjimInput);
                this.jjimInput = null; // null로 초기화
            }
        },
    },
}
</script>
