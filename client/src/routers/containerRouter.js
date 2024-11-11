export default [{
    path: '/',
    name: "Container",
    component: () => import('@/views/layouts/TheContainer.vue'),
    children: [
        {
            path: '/',
            name: "Home",
            component: () => import('@/views/pages/home/HomePage.vue'),
            meta: {
                title: 'RouterTitle.Home',
                authenticate: false
            }
        },
        {
            path: '/friends',
            name: "Friend",
            component: () => import('@/views/pages/friend/FriendPage.vue'),
            meta: {
                title: 'RouterTitle.Friend',
                authenticate: false
            }
        },
        {
            path: '/watch',
            name: "Watch",
            component: () => import('@/views/pages/watch/WatchPage.vue'),
            meta: {
                title: 'RouterTitle.Watch',
                authenticate: false
            }
        },
        {
            path: '/groups',
            name: "Group",
            component: () => import('@/views/pages/group/GroupPage.vue'),
            meta: {
                title: 'RouterTitle.Group',
                authenticate: false
            }
        },
        {
            path: '/meetings',
            name: "Meeting",
            component: () => import('@/views/pages/meeting/MeetingPage.vue'),
            meta: {
                title: 'RouterTitle.Meeting',
                authenticate: false
            }
        }
    ]
}];