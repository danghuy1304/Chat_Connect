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
                title: "Trang chủ",
                authenticate: false
            }
        },
        {
            path: '/friends',
            name: "Friend",
            component: () => import('@/views/pages/home/HomePage.vue'),
            meta: {
                title: "Bạn bè",
                authenticate: false
            }
        },
        {
            path: '/watch',
            name: "Watch",
            component: () => import('@/views/pages/home/HomePage.vue'),
            meta: {
                title: "Video",
                authenticate: false
            }
        },
        {
            path: '/groups',
            name: "Group",
            component: () => import('@/views/pages/group/GroupPage.vue'),
            meta: {
                title: "Nhóm",
                authenticate: false
            }
        }
    ]
}];