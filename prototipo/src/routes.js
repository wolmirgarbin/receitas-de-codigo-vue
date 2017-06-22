//src/routes.js

import LoginVue from './components/pages/login/Login.vue';
import IndexVue from './components/pages/index/Index.vue';

// módulos independentes carregados apenas ao chamar
const MeusDados = () => System.import('./components/pages/meus-dados/MeusDados.vue');
const PageNotFound = () => System.import('./components/pages/help/PageNotFound.vue');
const Documentos = () => System.import('./components/pages/documentos/Documentos.vue');
const Usuarios = () => System.import('./components/pages/usuarios/Usuarios.vue');

const Contratar = () => System.import('./components/pages/contratar/Contratar.vue');
const CadastrarUsuario = () => System.import('./components/pages/contratar/CadastrarUsuario.vue');
const CadastrarEmpresas = () => System.import('./components/pages/contratar/CadastrarEmpresas.vue');
const VerificaDados = () => System.import('./components/pages/contratar/VerificaDados.vue');


/* rotas aqui */
export const routes = [
    {path: '', component: LoginVue, name: 'login'},
    {path: '/contratar', component: Contratar, name: 'contratar'},
    {path: '/cadastrar-usuario', component: CadastrarUsuario, name: 'cadastrar-usuario'},
    {path: '/cadastrar-empresa', component: CadastrarEmpresas, name: 'cadastrar-empresa'},
    {path: '/cadastrar-verificacao', component: VerificaDados, name: 'cadastrar-verificacao'},

    {path: '/admin/index', component: IndexVue, name: 'index'},
    {path: '/admin/meus-dados', component: MeusDados, name: 'meus-dados'},
    //{path: '/admin/cliente-form/:id', component: ClienteForm, name: 'cliente-edit'},
    {path: '/admin/documentos', component: Documentos, name: 'documentos'},
    {path: '/admin/usuarios', component: Usuarios, name: 'usuarios'},
    {path: '*', component: PageNotFound, name: 'page-not-found' }
];
