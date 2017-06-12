<template>
  <!-- HTML -->
  <div class="container">

    <app-title title="Meus Dados" description="Edite os seus dados, para gravar as alterações clique em salvar"/>

    <div class="row">
      <div class="col-md-6 col-md-offset-3">

        <div class="painel">
          <form method="POST" @submit.prevent="onSubmit">
            
            <div class="form-group col-md-10 col-md-offset-1">
                <label for="usuario">Usuário</label>
                <input id="usuario" class="form-control" type="text" placeholder="Usuário" v-model="usuario" required autofocus />
            </div>
            
            <div class="form-group col-md-10 col-md-offset-1">
                <label for="senha">Usuário</label>
                <input id="senha" class="form-control" type="password" placeholder="Senha" v-model="senha" required />
            </div>

            <button class="btn btn-success" type="submit">SALVAR</button>
          </form>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';

export default {
  components: { 
    AppTitle
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