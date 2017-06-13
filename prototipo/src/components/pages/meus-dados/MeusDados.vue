<template>
  <!-- HTML -->
  <div>

    <app-title title="Meus Dados" description="Edite os seus dados, para gravar as alterações clique em salvar"/>

    <br>

    <div class="container">
      <div class="row">
        <div class="col-md-6">
          <p class="text-left">Altere sua senha através deste cadastro.</p>

          <p class="text-left">Recomendações para sua senha:</p>
          <ul>
            <li>Adicione pelo menos um caracter especial</li>
            <li>Não utilize seu nome nem números de documentos</li>
            <li>Adicione ao menos um número</li>
          </ul>
        </div>

        <card col="6">
            <form method="POST" @submit.prevent="onSubmit">

              <ui-textbox label="Usuário" placeholder="Informe seu usuário" required="true" />

              <ui-textbox label="Senha" placeholder="Informe sua senha" required="true" type="password" />

              <ui-textbox label="Confirma Senha" placeholder="Informe sua confirmação de senha" required="true" type="password" />

              <ui-button color="primary">SALVAR</ui-button>
            </form>
        </card>
      </div>
    </div>
  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';
import { UiButton, UiTextbox } from 'keen-ui';

export default {
  components: { 
    AppTitle, UiButton, UiTextbox, Card
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