//src/routes.js

import LoginVue from './components/pages/login/Login.vue';
import IndexVue from './components/pages/index/Index.vue';

// módulos independentes carregados apenas ao chamar
const MeusDados = () => System.import('./components/pages/meus-dados/MeusDados.vue');
const PageNotFound = () => System.import('./components/pages/help/PageNotFound.vue');
const Documentos = () => System.import('./components/pages/documentos/Documentos.vue');
const Usuarios = () => System.import('./components/pages/usuarios/Usuarios.vue');

const ClienteList = () => System.import('./components/pages/cliente/ClienteList.vue');
const ClienteForm = () => System.import('./components/pages/cliente/ClienteForm.vue');


/* rotas aqui */
export const routes = [
    {path: '', component: LoginVue, name: 'login'},
    {path: '/index', component: IndexVue, name: 'index'},
    {path: '/meus-dados', component: MeusDados, name: 'meus-dados'},
    {path: '/clientes', component: ClienteList, name: 'clientes'},
    {path: '/cliente-form', component: ClienteForm, name: 'cliente-form'},
    {path: '/cliente-form/:id', component: ClienteForm, name: 'cliente-edit'},
    {path: '/documentos', component: Documentos, name: 'documentos'},
    {path: '/usuarios', component: Usuarios, name: 'usuarios'},
    {path: '*', component: PageNotFound, name: 'page-not-found' }
];
