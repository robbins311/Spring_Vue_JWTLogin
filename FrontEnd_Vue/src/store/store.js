
import Vuex from 'vuex'
import modules from "./modules.js";
import Vue from "vue";
import createPersistedState from "vuex-persistedstate";


Vue.use(Vuex)




export const store = new Vuex.Store({
    state: modules.state,
    getters : modules.getters,
    mutations: modules.mutations,
    actions: modules.actions,

    plugins: [
        createPersistedState({
            paths: ['modules', 'accessToken', 'state', 'getters'],

        }),
    ],

});