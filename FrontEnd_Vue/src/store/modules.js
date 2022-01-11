
import Vuex from 'vuex'
import Vue from "vue";


Vue.use(Vuex)


const state = {
    host: 'http://localhost:8081',
    accessToken : '',
    id: '',
}

const getters = {
    'accessToken': state => state.accessToken
}

const mutations = {
    setToken: function (state, accessToken) {
        state.accessToken = accessToken;
    },
    delToken: function (state) {
        state.accessToken = null;
    }
}

const actions = {
    
}

export default {
    state,
    getters,
    mutations,
    actions
}