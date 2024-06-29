import { createRouter, createWebHistory } from "vue-router";
import { requireAuth } from "../middlewares/authenticate";

const routes = [

];

const router = createRouter({
    history: createWebHistory(),
    routes,
    scrollBehavior(to, from, savedPosition) {
        if (savedPosition) {
            return savedPosition
        } else {
            return {
                top: 0, behavior: 'smooth',
            }
        }
    }
});

router.beforeEach(async (to, from, next) => {
    document.title = to.meta.title;
    if (to.meta.authenticate && !localStorage.getItem('user')) {
        requireAuth(to, from, next);
    }
    next();
})

export default router;