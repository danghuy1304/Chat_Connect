import { createRouter, createWebHistory } from "vue-router";
import { requireAuth } from "../middlewares/authenticate";
import containerRouter from "./containerRouter";

const routes = [
    {
        path: '/',
        name: 'FrontSite',
        component: () => import('@/views/layouts/TheFrontSite.vue'),
        children: [
            ...containerRouter
        ]
    },
    {
        path: '/:pathMatch(.*)*',
        name: 'NotFound',
        component: () => import('@/views/pages/not-found/NotFoundPage.vue'),
        meta: {
            title: '404 - PAGE NOT FOUND'
        }
    },
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

router.beforeEach((to, from, next) => {
    document.title = to.meta.title;
    if (to.meta.authenticate && !localStorage.getItem('user')) {
        requireAuth(to, from, next);
    }
    next();
})

export default router;