<template>
  <div>
    <h2>Đăng Ký</h2>
    <form @submit.prevent="handleRegister">
      <label>Tên tài khoản:</label>
      <input v-model="taiKhoan.tenTaiKhoan" required />

      <label>Email:</label>
      <input v-model="taiKhoan.email" required />

      <label>Mật khẩu:</label>
      <input type="password" v-model="taiKhoan.matKhau" required />

      <button type="submit">Đăng Ký</button>
    </form>
    <p>{{ message }}</p>
  </div>
</template>

<script>
import { register } from '../api/auth';

export default {
  data() {
    return {
      taiKhoan: { tenTaiKhoan: '', email: '', matKhau: '' },
      message: ''
    };
  },
  methods: {
    async handleRegister() {
      try {
        const response = await register(this.taiKhoan);
        this.message = 'Đăng ký thành công!';
        console.log(response.data);
      } catch (error) {
        this.message = 'Lỗi đăng ký: ' + error.response.data;
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
