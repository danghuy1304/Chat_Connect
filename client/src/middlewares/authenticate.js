import { dialog } from '@/helpers/swal';
import { useAuthStore } from '@/stores/auth';

export const requireAuth = (to, from, next) => {
    const authStore = useAuthStore();
    if (!authStore.isLoggedIn) {
        next({ name: 'Login', query: { redirect: to.fullPath } });
    }
    else {
        next();
    }
}