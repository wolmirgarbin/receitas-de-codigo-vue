<template>
  <!-- HTML -->
  <div class="page">

    <app-title title="Portal DF-e" description="Arquivo de documentos físcais eletrônicos" />


    <div class="container-fluid text-center line-login">
      <div class="row">
        <div class="col-md-12">
          <h2>Aqui você pode</h2>
        </div>
      </div>

      <div class="container">
          <div class="row">
            <div class="col-md-4">
                <h3>Arquivar NF-e e CT-e</h3>
                <p>No portal DF-e da Viasoft você pode armazenar todas as suas NF-e e seus CT-e com segurança e comodidade.</p>
            </div>
            <div class="col-md-4">
                <h3>Consultar a hora que precisar</h3>
                <p>Sempre que precisar recuperar documentos, temos o melhor mecanismo de busca para localizar os documentos com facilidade e praticidade</p>
            </div>
            <div class="col-md-4">
                <h3>Fazer manifestação destinatário</h3>
                <p>Precisa fazer a manifestação de destinatário? Faça pelo portal a hora que precisar.</p>
            </div>
          </div>
      </div>
    </div>


    <div class="container">
      <div class="row">

          <card col="6">
              <card-header title="Já tem um usuário" description="Se você já tem um cadastro no sistema informe seu usuário e senha" />

              <div class="card-body">
                  <ui-alert type="error" v-show="mensagem">
                      {{mensagem}}
                  </ui-alert>


                  <form action="/login" method="POST" @submit.prevent="onSubmit">

                    <ui-textbox
                            floating-label
                            label="Usuário"
                            placeholder="Informe seu usuário"
                            v-model="usuario">
                    </ui-textbox>

                    <ui-textbox
                            floating-label
                            label="Senha"
                            placeholder="Informe sua senha"
                            v-model="senha"
                            type="password">
                    </ui-textbox>

                    <ui-button color="primary">LOGIN</ui-button>
                  </form>
              </div>
          </card>



          <card col="6">
              <card-header title="É seu primeiro acesse" description="Informe seu email para prosseguir com o cadastro" />

              <div class="card-body">
                  <form action="/login" method="POST" @submit.prevent="onSubmitPrimeiroAcesso">

                    <ui-alert type="error" v-show="mensagemPrimeiroAcesso">
                        {{mensagemPrimeiroAcesso}}
                    </ui-alert>

                    <ui-textbox
                            floating-label
                            label="Usuário"
                            placeholder="Informe seu usuário"
                            v-model="usuarioPrimeiroAcesso">
                    </ui-textbox>

                      <ui-button color="primary">RECEBER SENHA</ui-button>
                  </form>
              </div>
          </card>
      </div>
    </div>

  </div>
</template>

<script>
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
            usuario : '',
            senha : '',
            mensagem: ''
        }
    },
    methods : {
      onSubmit() {

          // TODO - verificar o usuário e senha no servidor

          if( this.usuario == 'wolmir' && this.senha == '123' ) {
            this.mensagem = '';

            // adiciona o usuário na sessão do navegador
            localStorage.setItem('usuarioLogado', {'usuario': this.usuario, 'mostraMenu': true});

            // emite um evento mostrando que o login foi realizado com sucesso!
            this.$emit('acessouSistema');

            // ir para a home do sistema
            //location.href = '/index';
            this.$router.push({name: 'index'});

          } else {
            // mostrar mensagem de usuário e senha incorretos
            this.mensagem = 'Usuário e senha não conferem';
          }
      },

      onSubmitPrimeiroAcesso() {
          if( this.usuarioPrimeiroAcesso == 'wolmir' ) {
              this.mensagemPrimeiroAcesso = 'Enviado para seu e-mail!';
          } else {
              this.mensagemPrimeiroAcesso = 'Usuário não existe!';
          }
      }
    }
}
</script>

<style scoped lang="scss">
  @import './Login.scss';
</style>