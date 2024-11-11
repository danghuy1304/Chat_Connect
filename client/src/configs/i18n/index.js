import { createI18n } from 'vue-i18n';
import en from './locales/en';
import vi from './locales/vi';

const i18n = createI18n({
    legacy: false,
    locale: 'vi',
    fallbackLocale: ['vi', 'en'],
    messages: { vi, en }
})

export const setupI18n = (app) => {
    app.use(i18n);
};

export const translate = (key, values) => {
    return i18n.global.t(key, values);
};
