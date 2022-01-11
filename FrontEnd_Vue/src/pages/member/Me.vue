<template>
  <div>
    <!-- <div id="authModal">
      <div class="black-bg" v-if="modal == true">
        <div class="white-bg" @click="modal=false">
          <img src="../../assets/logo.png" alt="">
          <h1>인증된 사용자 입니다.</h1>
        </div>
      </div>
    </div>
    <button @click="onAuthClicked" >인증하기</button> -->
    <upload-files/>
    </div>
</template>

<script>
//import {store} from "../../store/store";
import UploadFiles from "../../components/UploadFiles";
//import router from "../../router";

export default {
  name: "Me",
  components: { UploadFiles },
  // data() {
  //   return {
  //     modal: false,
  //     leaveBtn: false
  //   }
  // },  methods: {

  //     onAuthClicked() {

  //      // const token = localStorage.getItem('access_token')

  //       const token = store.getters.accessToken
  //       let config = {
  //         headers: {
  //           "Authorization": `Bearer ${token}`,
  //         }
  //       }
  //       //console.log(token)
  //       this.$axios
  //       .get('http://localhost:8082/member/me', config)
  //       .then(res=>{
  //         if(this.modal == true) {
  //           alert("이미 인증되었습니다.")
  //         } else {
  //           alert("Authorization User")
  //           this.modal = true
  //           console.log(token)
  //           console.log(res.data)
  //         }
  //       })
  //       .catch(error => {
  //         alert("로그인 하세요!")
  //         this.modal = false
  //         console.log(error)
  //       })
  //     },
  //       /*      logout() {
  //       const token = store.getters.accessToken
  //       if (token == undefined ) {
  //         this.leaveBtn = true;
  //         alert("이미 로그아웃 되었습니다.")
  //         return null;
  //       } else {
  //         alert("로그아웃 되었습니다.")
  //         this.leaveBtn = true;
  //         this.modal = false
  //         router.push('/');
  //         store.commit('delToken', token)
  //         //localStorage.removeItem('access_token');
  //       }
  //     }*/
  //   }
}
</script>

<style>
div {
  box-sizing: border-box;
}
#authModal {
  width: 500px;
  height: 385px;
}
.black-bg {
  width: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed;
  padding: 20px;
}
.white-bg {
  width: 100%;
  background: white;
  border-radius: 8px;
  padding: 20px;
}
</style>