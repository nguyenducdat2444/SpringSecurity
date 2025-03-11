// src/api/auth.js
import axios from 'axios';

const API_URL = '/api/auth';

export const register = (taiKhoan) => axios.post(`${API_URL}/register`, taiKhoan);
export const login = (taiKhoan) => axios.post(`${API_URL}/login`, taiKhoan);
