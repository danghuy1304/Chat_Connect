import { translate } from '../configs/i18n';

export default [{
    path: '/',
    name: "Container",
    component: () => import('../views/layouts/TheContainer.vue'),
    children: [
        {
            path: '/',
            name: "Home",
            component: () => import('@/views/pages/home/HomePage.vue'),
            meta: {
                title: translate('RouterTitle.Home', { pipe: ' | ' }),
                authenticate: false
            }
        },
        {
            path: '/friends',
            name: "Friend",
            component: () => import('@/views/pages/home/HomePage.vue'),
            meta: {
                title: translate('RouterTitle.Friend', { pipe: ' | ' }),
                authenticate: false
            }
        },
        {
            path: '/watch',
            name: "Watch",
            component: () => import('@/views/pages/home/HomePage.vue'),
            meta: {
                title: translate('RouterTitle.Watch', { pipe: ' | ' }),
                authenticate: false
            }
        },
        {
            path: '/groups',
            name: "Group",
            component: () => import('@/views/pages/group/GroupPage.vue'),
            meta: {
                title: translate('RouterTitle.Group', { pipe: ' | ' }),
                authenticate: false
            }
        },
        {
            path: '/meetings',
            name: "Meeting",
            component: () => import('@/views/pages/group/GroupPage.vue'),
            meta: {
                title: translate('RouterTitle.Meeting', { pipe: ' | ' }),
                authenticate: false
            }
        }
    ]
}];