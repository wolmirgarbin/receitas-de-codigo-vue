import Vue from 'vue'
import App from './App.vue'

// importando o router!
import VueRouter from 'vue-router';

// importando o módulo
import VueResource from 'vue-resource';

// importar as rotas que estão em routes.js
import {routes} from './routes'; // como é um .js não precisa adicionar a extenção no import

// importar o css do bootstrap como um módulo
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.js';

import 'keen-ui/dist/keen-ui.css';

import './assets/css/my.css';
import './assets/js/my.js';


// registrando o router no vue
Vue.use(VueRouter);

// registrando o módulo/plugin no global view object
Vue.use(VueResource);


// Vue.http.options.root = process.env.API_URL ? process.env.API_URL : 'http://localhost:28080';

Vue.http.interceptors.push((req, next) => {

    // é possível colocar informações no header antes do envio da requisição
    if( localStorage.getItem('authorization') != undefined ) {
        req.headers.set('Authorization', localStorage.getItem('authorization') );
    }

    next(res => {
        //console.log('Lidando com a resposta')
        // é possível acessar os dados da reposta e realizar transformações antes
        //console.log(res.body);
    });
});


const router = new VueRouter({
  routes//, /* : routes - como eles tem o mesmo nome podemos manter apenas 1*/
  //mode: 'history' /* remove o # da barra de navegação */
});

router.beforeEach((to, from, next) => {
    //console.log( from.path +' para '+ to.path );

    if( to.path.indexOf('/admin') != -1 ) {

      //console.log( 'locado: '+ (localStorage.getItem('usuarioLogado') != undefined) );

        if( localStorage.getItem('usuarioLogado') != undefined ) {
            next();
        } else {
            next( {path: '/'} );
        }
    } else {
        next();
    }
});


new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
