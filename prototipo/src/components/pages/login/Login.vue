<template>
  <!-- HTML -->
  <div class="container">

    <app-title title="Controle de Clientes" description="Este sistema vai permitir que você gerencie seus clientes" />



    <div class="row">
      <div class="col-md-6 col-md-offset-3">

        <div class="painel">
          <h2>Login</h2>

          <p v-if="mensagem" class="m-error">{{mensagem}}</p>


          <form action="/login" method="POST" @submit.prevent="onSubmit">
            
            <div class="form-group col-md-10 col-md-offset-1">
              <input class="form-control" type="text" placeholder="Usuário" @input="usuario = $event.target.value" required autofocus />
            </div>
            
            <div class="form-group col-md-10 col-md-offset-1">
              <input class="form-control" type="password" placeholder="Senha" @input="senha = $event.target.value" required />
            </div>

            <button class="btn btn-success" type="submit">LOGIN</button>
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