import { createRouter, createWebHistory } from 'vue-router';
import LoginForm from '../components/LoginForm.vue';
import RegisterForm from '../components/RegisterForm.vue';

const routes = [
    { path: '/login', component: LoginForm },
    { path: '/register', component: RegisterForm },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
