
import Vuex from 'vuex'
import modules from "./modules";
import Vue from "vue";


Vue.use(Vuex)




export const store = new Vuex.Store({
    state: modules.state,
    getters : modules.getters,
    mutations: modules.mutations,
    actions: modules.actions,

});