import { createI18n } from 'vue-i18n';
import en from './locales/en';
import vi from './locales/vi';
import { useLocaleStore } from '@/stores/locale';
import { createPinia } from 'pinia';

const pinia = createPinia();
const languageStore = useLocaleStore(pinia);

const i18n = createI18n({
    legacy: false,
    locale: languageStore.language,
    fallbackLocale: ['vi', 'en'],
    messages: { vi, en }
})

export const setupI18n = (app) => {
    app.use(i18n);
};

export const translate = (key, values) => {
    return i18n.global.t(key, values);
};
