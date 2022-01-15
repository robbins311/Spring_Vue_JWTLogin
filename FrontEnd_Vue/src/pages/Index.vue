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

    <router-link to="/member/me" v-if="$store.getters.accessToken" @click.native="checkToken">UploadFiles</router-link>
   

  </div>

</template>

<script>
import router from '../router';
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
      const token = localStorage.getItem('access_token')
      let config = {
        headers: {
          "Authorization": `Bearer ${token}`,
        }
      }
      this.$axios
      .get('http://localhost:8082/member/me', config)
      .then(res=>{
        console.log(res.data);
      })
      .catch(error => {
        alert("로그인 하세요!")
        router.push('/');
        console.log(error)
      })
    },
  }
}
</script>

<style scoped>
  .logoutBtn {
    margin-bottom: 17px;
  }
</style>