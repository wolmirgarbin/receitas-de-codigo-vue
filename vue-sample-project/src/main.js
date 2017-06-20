import Vue from 'vue'
import App from './App.vue'

// importando o módulo
import VueResource from 'vue-resource';

// importando o router!
import VueRouter from 'vue-router';

import { routes } from './routes';

// importando o VeeValidate 
import VeeValidate from 'vee-validate';

// importando o arquivo `Transform.js`.
import './directives/Transform';

import msg from './pt_BR';


// importando nosso CSS!
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';

import './assets/css/my.css';
import './assets/js/my.js';


// registrando o módulo/plugin no global view object
Vue.use(VueResource);
Vue.use(VueRouter);

Vue.use(VeeValidate, {
    locale: 'pt_BR',
    dictionary: {
        pt_BR: {
            messages: msg
        }
    }
});


// http usará sempre o endereço abaixo
Vue.http.options.root = process.env.API_URL ? process.env.API_URL : 'http://localhost:3000';

Vue.http.interceptors.push((req, next) => {
    // é possível colocar informações no header antes do envio da requisição
    //req.headers.set('Authorization', 'informação de segurança aqui');
    console.log('Lidando com o request');

    next(res => {
      console.log('Lidando com a resposta')
      // é possível acessar os dados da reposta e realizar transformações antes
      console.log(res.body);
    });
});


const router = new VueRouter({
  routes,
  mode: 'history'
});


new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
