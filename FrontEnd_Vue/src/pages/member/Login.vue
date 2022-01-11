<template>
  <div>
    <router-link to="/"><i class="fas fa-home" style="width: 25px; height: 25px; color: #262626; " /></router-link>
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

</style>