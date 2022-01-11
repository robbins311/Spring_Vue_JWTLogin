<template>
  <div>
    <div>
      <img src="./../assets/remove-bg.png" alt="">
      <h1>Index Page</h1>
      <button class="logoutBtn" @click="logout" v-if="$store.getters.accessToken" >logout</button>
    </div>

    <router-link to="/">Home</router-link>
    |
    <router-link to="/member/signup" v-if="!$store.getters.accessToken">SignUp | </router-link>

    <router-link to="/member/login" v-if="!$store.getters.accessToken">Login | </router-link>

    <router-link to="/member/me">Me</router-link>
    |
    <router-link to="/member/check" @click.native="checkToken">Check</router-link>
   

  </div>

</template>

<script>
import {store} from "../store/store";
export default {
  name: "Index",
  data() {
    return {
      leaveBtn: false
    }
  },
  methods: {
    logout() {
          const token = store.getters.accessToken
          window.localStorage.removeItem("access_token");
          this.leaveBtn = true
          alert("로그아웃 되었습니다.")
          store.commit('delToken', token)
        },
    checkToken() {
      alert("클릭됐습니다.");
    },
  }
}
</script>

<style scoped>
  .logoutBtn {
    margin-bottom: 17px;
  }
</style>