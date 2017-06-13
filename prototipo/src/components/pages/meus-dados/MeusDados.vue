<template>
  <!-- HTML -->
  <div class="container">

    <app-title title="Meus Dados" description="Edite os seus dados, para gravar as alterações clique em salvar"/>

    <div class="row">
      <div class="col-md-6 col-md-offset-3">

        <div class="painel">
          <form method="POST" @submit.prevent="onSubmit">
            
            <app-input id="nome" label="Seu nome" placeholder="Informe seu nome" required="true" />
            
            <app-input id="usuario" label="Usuario para acesso" placeholder="Informe seu usuário" />

            <app-input id="senha" label="Senha" placeholder="Informe sua senha" type="password" />

            <app-input id="confirmaSenha" label="confirma Senha" placeholder="Informe sua confirmação de senha" type="password" />

            <button class="btn btn-success" type="submit">SALVAR</button>
          </form>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import AppInput from '../../shared/input/Input.vue';

export default {
  components: { 
    AppTitle, AppInput
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