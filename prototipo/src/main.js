import Vue from 'vue'
import App from './App.vue'

// importando o router!
import VueRouter from 'vue-router';

// importar as rotas que estão em routes.js
import {routes} from './routes'; // como é um .js não precisa adicionar a extenção no import

// importar o css do bootstrap como um módulo
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';

import './assets/css/my.css';
import './assets/js/my.js';


// registrando o router no vue
Vue.use(VueRouter);

const router = new VueRouter({
  routes, /* : routes - como eles tem o mesmo nome podemos manter apenas 1*/
  mode: 'history' /* remove o # da barra de navegação */
});


new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
