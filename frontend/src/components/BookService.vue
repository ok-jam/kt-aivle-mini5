<template>
    <div>
        <Number
            label="BookServiceId"
            v-model="value.bookServiceId"
            :editMode="editMode"
        />
        <Number
            label="BookId"
            v-model="value.bookId"
            :editMode="editMode"
        />
        <Number
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Number
            label="Rating"
            v-model="value.rating"
            :editMode="editMode"
        />
        <String
            label="Review"
            v-model="value.review"
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
    name: 'BookService',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "bookServices",
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
