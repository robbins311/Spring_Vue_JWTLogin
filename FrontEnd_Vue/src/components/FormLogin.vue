<template>
<div id="loginForm">
  <!-- 아이디 입력 -->
  <div id="loginId">
    <label>
      <span><i class="fas fa-user" style="width: 17px; height: 15px" />  Email </span>
      <input v-model="context.email" type="text" placeholder="아이디(이메일)를 입력해주세요." autofocus />
    </label>
  </div>
  <!--  패스워드 입력  -->
  <div id="loginPw">
    <label>
      <span><i class="fas fa-unlock" style="width: 17px; height: 15px" /> Password </span>
      <input v-model="context.password" type="password" placeholder="비밀번호를 입력해주세요."/>
    </label>
  </div>
<!-- 로그인 버튼 -->
  <div id="login">
    <input value="Login" @click="onLoginClicked" type="submit" />
  </div>
<!-- 로그인 페이지로 이동 -->
  <div id="linkSignUp">
    <i class="fas fa-users" style="width: 17px; height: 15px" />
    <span>  처음이신가요? </span>
    <router-link to="/member/signup" style="color:#256fd7">Sign Up Now</router-link>
  </div>

</div>
</template>

<script>
import router from "../router";
import {store} from "../store/store";
import http from "../http-common";

export default {
  name: "FormLogin",
  data() {
    return {
      context: {
        email: '',
        password: ''
      }
    }
  },
  methods: {
    onLoginClicked(){
      // 입력받은 파라미터 값 back으로 전송
      const params = { email: this.context.email, password:this.context.password }
      // 이메일 or 패스워드 값이 입력 안됐을시 오류
      if (!params.email || !params.password) {
        alert("이메일이나 패스워드를 입력하세요.");
        return null
      } else {
        http
            .post('http://localhost:8082/auth/login', params)
            .then(function (response){
              window.alert("환영합니다! 로그인 되었습니다.");
              router.push('/');
              // 전달받은 response 값 중 accessToken만 localstorage and store에 저장
              const token = response.data.accessToken;
              localStorage.setItem("access_token", token)
              store.commit('setToken', token);
            })
            .catch(function (error){
              window.alert("아이디, 비밀번호를 다시 확인해주세요.");
              console.log(error)
            });
      }
    }
  }
}
</script>

<style scoped>
  #loginForm {
    background-color: #fff;
    border: 1px solid #e6e6e6;
    border-radius: 8px;
    margin-left: auto;
    margin-right: auto;
    width: 520px;
    height: 330px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center;
    align-items: center;
  }
  #loginId {
    width: 100%;
  }
  #loginId label {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  #loginId label span {
    width:92%;
    margin-bottom: 5px;
    font-weight: bold;
    display: inline-block;
    text-align: left;
  }

  #loginId label input {
    border: 1px solid #e6e6e6;
    border-radius: 5px;
    width: 90%;
    font-size: 12.8px;
    height: 40px;
    padding: 5px 8px;
  }

  #loginPw {
    width: 100%;
    margin: 15px 0px;
  }
  #loginPw label {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  #loginPw label span {
    width:92%;
    margin-bottom: 5px;
    font-weight: bold;
    display: inline-block;
    text-align: left;
  }
  #loginPw label input {
    border: 1px solid #e6e6e6;
    border-radius: 5px;
    width: 90%;
    font-size: 12.8px;
    height: 40px;
    padding: 5px 8px;
  }

  #login {
    width: 100%;
    margin-bottom: 15px;
  }
  #login input {
    color: #fff;
    font-weight: 550;
    border: none;
    border-radius: 5px;
    background-color: #256fd7;
    width: 92%;
    height: 38px;
    font-size: 14px;
  }
  #login input:hover {
    background-color: #207cfc;
  }

  #linkSignUp {
    margin-top: 20px;
    margin-left: -255px;
  }
</style>