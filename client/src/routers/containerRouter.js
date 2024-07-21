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
        }
    ]
}];