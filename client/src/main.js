import { createApp } from 'vue'
import App from './App.vue'
import router from './routers/router';
import { createPinia } from 'pinia';

const app = createApp(App);
const pinia = createPinia()

// import vuetify from './plugins/vuetify';

// app.use(vuetify);
app.use(pinia);
app.use(router);
app.mount('#app')