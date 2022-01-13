<template>
  <div id="signupText">
    <div id="sf">
      <h2>회원가입</h2>
    </div>
    <form-sign-up/>
  </div>
</template>

<script>
import FormSignUp from "../../components/FormSignUp";
export default {
  name: "SignUp",
  components: { FormSignUp }
}
</script>

<style scoped>
  #sf {
    margin-bottom: 30px;
  }
  #sf h2 {
    color: #2c3e50;
    font-weight: 500;
  }
</style>