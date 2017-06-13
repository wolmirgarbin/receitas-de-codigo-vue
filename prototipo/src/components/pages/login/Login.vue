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
            <h2 class="text-center">Já tem um usuário</h2>

            <p v-if="mensagem" class="m-error">{{mensagem}}</p>


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

              <ui-button>LOGIN</ui-button>
            </form>
          </card>



          <card col="6">
            <h2 class="text-center" >É seu primeiro acesso?</h2>

            <p v-if="mensagem" class="m-error">{{mensagem}}</p>


            <form action="/login" method="POST" @submit.prevent="onSubmit">

                <ui-textbox
                        floating-label
                        label="Usuário"
                        placeholder="Informe seu usuário"
                        v-model="usuario">
                </ui-textbox>

              <ui-button>RECEBER SENHA</ui-button>
            </form>
          </card>
      </div>
    </div>

  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';
import { UiAlert, UiButton, UiTextbox } from 'keen-ui';

export default {
  components: { 
    AppTitle, UiAlert, UiButton, UiTextbox, Card
  },
  data() {
    return {
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
        this.$router.push('/index');

      } else {
        // mostrar mensagem de usuário e senha incorretos
        this.mensagem = 'Usuário e senha não conferem';
      }
    }
  }
}
</script>

<style scoped lang="scss">
  @import './Login.scss';
</style>