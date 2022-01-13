<template>
<div id="signUpForm">
<!-- 아이디 입력 -->
  <div id="id">
    <label>
      <span><i class="fas fa-user" style="width: 17px; height: 15px;" />  Email </span>
      <input v-model="context.email" type="text" placeholder="아이디(이메일)를 입력해주세요." autofocus />
    </label>
  </div>
<!--  패스워드 입력  -->
  <div id="pw">
    <label>
      <span><i class="fas fa-unlock" style="width: 17px; height: 15px" /> Password </span>
      <input v-model="context.password" type="password" placeholder="비밀번호를 입력해주세요."/>
    </label>
  </div>
<!--  회원가입 버튼 -->
  <div id="signUp">
    <input value="Sign Up" @click="onSignUpClicked" type="submit" />
  </div>
<!-- 로그인 페이지로 이동 -->
  <div id="linkLogin">
    <i class="fas fa-users" style="width: 17px; height: 15px" />
    <span>  회원이신가요? </span>
    <router-link to="/member/login" style="color:#256fd7">Login</router-link>
    <router-link to="/" style="display:block; margin-left:-86px; margin-top:10px; margin-bottom:10px;">메인페이지</router-link>
  </div>

</div>
</template>

<script>
import router from "../router";

export default {
  name: "FormSignUp",
  data() {
    return {
      context: {
        email: '',
        password: ''
      }

      }
  },
  methods: {

   onSignUpClicked () {
     // 입력받은 정보를 넘김.
     const params = { email: this.context.email, password:this.context.password }
     // 파라미터값이 입력이 안됐을때 null return
     if (!params.email || !params.password) {
       console.log(params);
       alert("이메일이나 패스워드를 입력하세요.");
       return null
     } else {
       console.log(params);
       /* axios를 통해 backend와 통신 */
       this.$axios
           .post('http://localhost:8082/auth/signup', params,
               {
                 // header값 Json
                 headers: {
                   'Content-type': 'application/json'
                 }
               })
           // 회원가입이 성공했을때 alert 메세지와 login페이지로 이동.
           .then(function (response) {
             window.alert("회원가입 되었습니다! 로그인 페이지로 이동합니다.");
             router.push('/member/login');
             console.log(response);
           })
           // backend와 연결되어 동일한 아이디 입력시 에러 alert 띄움
           .catch(function (error){
             window.alert("이미 가입되어있는 사용자 입니다.");
             console.log(error);
           });
     }
   },
  }
}

</script>

<style scoped>
  body {
    background-color: lightslategray;
  }
  #signUpForm {
    background-color: #fff;
    border: 1px solid #e6e6e6;
    border-radius: 8px;
    margin-left: auto;
    margin-right: auto;
    width: 520px;
    height: 370px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-content: center;
    align-items: center;
  }
  #id {
    width: 100%;
  }
  #id label {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  #id label span {
    width:92%;
    margin-bottom: 5px;
    font-weight: bold;
    display: inline-block;
    text-align: left;
  }
  #id label input {
    border: 1px solid #e6e6e6;
    border-radius: 5px;
    font-size: 12.8px;
    width: 90%;
    height: 40px;
    padding: 5px 8px;
  }
  #pw {
    width: 100%;
    margin: 15px 0px;
  }
  #pw label {
    display: flex;
    flex-direction: column;
    align-items: center;
  }
  #pw label span {
    width:92%;
    margin-bottom: 5px;
    font-weight: bold;
    display: inline-block;
    text-align: left;
  }
  #pw label input {
    border: 1px solid #e6e6e6;
    border-radius: 5px;
    font-size: 12.8px;
    width: 90%;
    height: 40px;
    padding: 5px 8px;
  }
  #signUp {
    width: 100%;
    margin-bottom: 15px;
  }
  #signUp input {
    color: #fff;
    font-weight: 550;
    border: none;
    border-radius: 5px;
    background-color: #256fd7;
    width: 92%;
    height: 38px;
    font-size: 14px;
  }
  #linkLogin {
    margin-top: 20px;
    margin-left: -300px;
  }
</style>