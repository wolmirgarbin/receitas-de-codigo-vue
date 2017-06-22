import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';

import { UiAlert, UiButton, UiTextbox } from 'keen-ui';

export default {
    components: {
        AppTitle, UiAlert, UiButton, UiTextbox, Card, CardHeader
    },
    created() {
        console.log( localStorage.getItem('usuarioLogado') );

        if( localStorage.getItem('usuarioLogado') != undefined ) {
            this.$router.push({name: 'index'});
        }
    },
    data() {
        return {
            usuarioPrimeiroAcesso : '',
            mensagemPrimeiroAcesso: '',
            mensagem: '',
            usuario : '',
            senha : ''
        }
    },
    methods : {
        onSubmit() {


            // usando JWT
            /*this.$http.post('http://localhost:28080/login', {'username': this.usuario, 'password': this.senha })
                .then((response) => {

                    this.mensagem = '';

                    // adiciona o usuário na sessão do navegador
                    localStorage.setItem('usuarioLogado', {'usuario': this.usuario, 'mostraMenu': true, 'authorization' : response.body });
                    localStorage.setItem('authorization', response.body);

                    // emite um evento mostrando que o login foi realizado com sucesso!
                    this.$emit('acessouSistema');

                    // ir para a home do sistema
                    //location.href = '/index';
                    this.$router.push({name: 'index'});
                }, err => {
                    this.mensagem = 'Usuário e senha não conferem';
            });*/


            // Usando oauth
            var formData = new FormData();
            formData.append('username', this.usuario);
            formData.append('password', this.senha);
            formData.append('grant_type', 'password');

            this.$http.post('http://localhost:28080/oauth/token', formData, {
                headers: {
                    'Content-Type':'application/x-www-form-urlencoded',
                    'Authorization':'Basic YXBwOmFwcA=='
                }
            })
                .then((response) => {

                    console.log( response.body.access_token );

                    this.mensagem = '';

                    // adiciona o usuário na sessão do navegador
                    localStorage.setItem('usuarioLogado', JSON.stringify({'usuario': this.usuario, 'mostraMenu': true, 'authorization' : response.body }));
                    localStorage.setItem('authorization', JSON.stringify(response.body.access_token));

                    // emite um evento mostrando que o login foi realizado com sucesso!
                    this.$emit('acessouSistema');

                    // ir para a home do sistema
                    //location.href = '/index';
                    this.$router.push({name: 'index'});
                }, err => {
                    this.mensagem = 'Usuário e senha não conferem';
                }
            );
        },

        toContratar() {
            this.$router.push({name: 'contratar'});
        }
    }
}