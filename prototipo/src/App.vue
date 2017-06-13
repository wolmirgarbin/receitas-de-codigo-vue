<template>
  <!-- HTML -->
  <div>

    <menu-app @logoutIn="logout" v-if="mostraMenu" />

    <!-- é aqui que encontrará os componentes de página que queremos visualizar -->
    <router-view @acessouSistema="acessou"></router-view>

  </div>
</template>
<script>
import MenuApp from './components/shared/menu/Menu.vue';

export default {
  components: {
    //'menu-app' : MenuApp -> pode ser utilizado assim, ou simplemente MenuApp:
    MenuApp
  },
  
  data() {
    return {
      mostraMenu: true
    }
  },
  
  methods: {
    logout() {
      this.mostraMenu = false;
    },
    acessou() {
      this.mostraMenu = true;
    }
  },

  created() {
    this.mostraMenu = localStorage.getItem('usuarioLogado') != undefined;

    if( this.mostraMenu ) {
      this.$router.push('index');
    }
  }
}
</script>
<style lang="scss">
  
</style>