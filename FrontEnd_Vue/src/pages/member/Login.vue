<template>
  <div>
    <router-link to="/"><i class="fas fa-home" style="width: 40px; height: 40px; margin-bottom:15px; color: #262626; " /></router-link>
    <h2>로그인</h2>
    <form-login/>
  </div>
</template>

<script>
import FormLogin from "../../components/FormLogin";
export default {
  name: "Login",
  components: { FormLogin }
}
</script>

<style scoped>
  h2 {
    margin-bottom: 30px;
    color: #2c3e50;
    font-weight: 500;
  }
</style>