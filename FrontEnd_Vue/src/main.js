import Vue from 'vue'
import { store } from './store/store.js';
import App from './App.vue';
import router from "./router";
import VueRouter from "vue-router";
import axios from "axios";
import 'es6-promise/auto'
import '@fortawesome/fontawesome-free/js/all.js'

Vue.config.productionTip = false
Vue.use(VueRouter)



/*  전역변수는 $ */
Vue.prototype.$foo = () => console.log('foo is called!')
Vue.prototype.$axios = axios
Vue.prototype.$store = store

new Vue({
  render: h => h(App),
  router,
  store: store,


}).$mount('#app')
