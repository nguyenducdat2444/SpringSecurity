<template>
  <div>
    <h2>Đăng Nhập</h2>
    <form @submit.prevent="handleLogin">
      <label>Email:</label>
      <input v-model="taiKhoan.email" required />

      <label>Mật khẩu:</label>
      <input type="password" v-model="taiKhoan.matKhau" required />

      <button type="submit">Đăng Nhập</button>
    </form>
    <p>{{ message }}</p>
  </div>
</template>

<script>
import { login } from '../api/auth';

export default {
  data() {
    return {
      taiKhoan: { email: '', matKhau: '' },
      message: ''
    };
  },
  methods: {
    async handleLogin() {
      try {
        const response = await login(this.taiKhoan);
        localStorage.setItem('token', response.data.token);
        this.message = 'Đăng nhập thành công!';
        // this.$router.push('/profile');
      } catch (error) {
        this.message = 'Lỗi: ' + (error.response?.data || 'Không kết nối được máy chủ.');

      }
    }
  }
};
</script>

<style scoped>
form {
  display: flex;
  flex-direction: column;
}
</style>
