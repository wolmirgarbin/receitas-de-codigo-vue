//src/routes.js

import LoginVue from './components/pages/login/Login.vue';
import IndexVue from './components/pages/index/Index.vue';

// módulos independentes carregados apenas ao chamar
const MeusDados = () => System.import('./components/pages/meus-dados/MeusDados.vue');
const MapaMarker = () => System.import('./components/pages/mapa-marker/MapaMarker.vue');
const PageNotFound = () => System.import('./components/pages/help/PageNotFound.vue');

/* rotas aqui */
export const routes = [
  {path: '', component: LoginVue, name: 'login'},
  {path: '/index', component: IndexVue, name: 'index'},
  {path: '/meus-dados', component: MeusDados, name: 'meus-dados'},
  {path: '/mapa-marker', component: MapaMarker, name: 'mapa-marker'},
  {path: '*', component: PageNotFound, name: 'page-not-found' }
];