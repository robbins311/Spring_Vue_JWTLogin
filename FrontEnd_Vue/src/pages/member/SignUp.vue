<template>
  <div id="signupText">
    <router-link to="/"><i class="fas fa-home"  style="width: 25px; height: 25px; color: #262626" /></router-link>
    <h2>회원가입</h2>
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

</style>