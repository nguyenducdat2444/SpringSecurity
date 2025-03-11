<template>
  <div>
    <nav>
      <router-link to="/register">Đăng Ký</router-link> |
      <router-link to="/login">Đăng Nhập</router-link> |
<!--      <router-link to="/profile">Thông Tin</router-link>-->
    </nav>
    <router-view />
  </div>
</template>

<script>
export default { name: 'App' };
</script>

<style scoped>
nav {
  margin-bottom: 20px;
}
</style>