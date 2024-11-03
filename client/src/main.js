import { createApp } from 'vue'
import App from './App.vue'
import router from './routers/router';
import { createPinia } from 'pinia';
import './styles/style.css';

import vuetify from './plugins/vuetify';
import { globalComponents } from './configs/global/components';
import { globalProperties } from './configs/global/properties';
import { globalDirectives } from './configs/global/directives';
import { setupI18n } from './configs/i18n';

const app = createApp(App);
const pinia = createPinia();

// i18n
setupI18n(app);

// Global components
globalComponents(app);

// Global methods
globalProperties(app);

// Global directives
globalDirectives(app);

app.use(vuetify);
app.use(pinia);
app.use(router);
app.mount('#app')