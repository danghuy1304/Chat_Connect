import { createRouter, createWebHistory } from "vue-router";
import { requireAuth } from "../middlewares/authenticate";
import containerRouter from "./containerRouter";
import { translate } from "../configs/i18n";

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
            title: 'RouterTitle.NotFound',
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

router.beforeEach(async (to, from, next) => {
    const title = translate(to.meta.title, { pipe: ' | ' });
    document.title = title;
    if (to.meta.authenticate && !localStorage.getItem('user')) {
        requireAuth(to, from, next);
    }
    next();
})

export default router;