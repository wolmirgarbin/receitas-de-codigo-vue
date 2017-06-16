<template>
  <div>

    <app-title title="Dados para Acesso" description="Altere seus dados para acessar o sistema" />

    <br>

    <container>


      <card col="6">
        <card-header title="Configurações de usuário" description="Para alterar sua senha, utilize este formulário" />

        <div class="card-body">
          <form method="POST" @submit.prevent="onSubmit">

            <ui-textbox label="Usuário" placeholder="Informe seu usuário" disabled />

            <ui-textbox label="Senha" placeholder="Informe sua senha" type="password" />

            <ui-textbox label="Confirma Senha" placeholder="Informe sua confirmação de senha" type="password" />

            <ui-button color="primary">SALVAR</ui-button>
          </form>
        </div>
      </card>


      <card col="6">
        <card-header title="Email para notificação" description="Algumas notificações são geradas automaticamente no sistema" />

        <div class="card-body">
          <form method="POST" @submit.prevent="onSubmit">

            <ui-textbox label="E-mail para receber notificação" placeholder="E-mail para receber notificação" />

            <ui-button color="primary">SALVAR</ui-button>
          </form>
        </div>
      </card>
    </container>

  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Container from '../../shared/container/Container.vue';
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';
import { UiButton, UiTextbox } from 'keen-ui';

export default {
  components: { 
    AppTitle, UiButton, UiTextbox, Card, Container, CardHeader
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
        alert(this.usuario);
    }
  }
}
</script>

<style scoped lang="scss">
  @import './MeusDados.scss';
</style>