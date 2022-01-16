<template>
  <div class="container" style="width:1000px">
    <div style="margin-bottom: 50px">
        <h3>robbins311.com</h3>
        <h4>upload Files</h4>
    </div>
    <upload-files/>
  </div>
</template>

<script>
import UploadFiles from "../../components/UploadFiles";

export default {
  name: "Me",
  components: { UploadFiles },
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