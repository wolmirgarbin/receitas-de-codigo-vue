<template>
    <div class="form-group col-md-10 col-md-offset-1">
        <input class="form-control" type="password" placeholder="Senha" @input="senha = $event.target.value" required />
    </div>
</template>

<script>
// acmescript 6
export default {
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
        
        // ir para a home do sistema
        location.href = '/index';

      } else {
        // mostrar mensagem de usuário e senha incorretos
        this.mensagem = 'Usuário e senha não conferem';
      }
    }
  }
}
</script>

<style lang="scss">
  /* css com sass */
  h1 { 
    text-align: center;
  }
  p {
    text-align: center;
  }
  .painel {
    width: 100%;
    margin: 0px auto;
    background-color: #F0F0F0;
    padding: 16px;
    border-radius: 4px;
    text-align: center;
  }
  .painel input {
    border: 1px solid #CCC;
    border-radius: 2px;
    padding: 5px;
    height: 44px;
  }
  .m-error {
    padding: 10px;
    background: red;
    color: #FFF;
    border-radius: 2px;
    text-align: center;
  }
</style>