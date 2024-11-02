import { createApp } from 'vue'
import App from './App.vue'
import router from './routers/router';
import { createPinia } from 'pinia';
import './styles/style.css';

const app = createApp(App);
const pinia = createPinia();

// Components
import BaseButton from '@/components/button/BaseButton.vue';
app.component('b-button', BaseButton);

import vuetify from './plugins/vuetify';

app.use(vuetify);
app.use(pinia);
app.use(router);
app.mount('#app')