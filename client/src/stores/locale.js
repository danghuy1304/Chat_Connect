import { defineStore } from 'pinia'

export const useLocaleStore = defineStore('locale', {
    state: () => ({
        language: 'vi',
    }),
    getters: {},
    actions: {
        changeLanguage(language) {
            this.language = language;
        }
    },
})
