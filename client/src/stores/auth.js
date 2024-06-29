import { defineStore } from 'pinia'

export const useAuthStore = defineStore('auth', {
    state: () => ({
        isLoggedIn: !!localStorage.getItem('user'),
    }),
    getters: {},
    actions: {},
})
