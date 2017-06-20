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
      this.mostraMenu = localStorage.getItem('usuarioLogado') != undefined;
    }
  },
    created() {
        var homer = "";
        homer += '|                                 __\n';
        homer += '|                       _ ,___,-\'",-=-. \n';
        homer += '|           __,-- _ _,-\'_)_  (""`\'-._\ `. \n';
        homer += '|        _,\'  __ |,\' ,-\' __)  ,-     /. |\n';
        homer += '|      ,\'_,--\'   |     -\'  _)/         `|\n';
        homer += '|    ,\',\'      ,\'       ,-\'_,`           :\n';
        homer += '|    ,\'     ,-\'       ,(,-(              :\n';
        homer += '|         ,\'       ,-\' ,    _            ;\n';
        homer += "|        /        ,-._/`---'            /\n";
        homer += "|       /        (____)(----. )       ,'\n";
        homer += "|      /         (      `.__,     /\ /,\n";
        homer += "|     :           ;-.___         /__\/|\n";
        homer += "|     |         ,'      `--.      -,\ |\n";
        homer += "|     :        /            \    .__/\n";
        homer += "|      \      (__            \    |_\n";
        homer += "|       \       ,`-, *       /   _|,\\\n";
        homer += "|        \    ,'   `-.     ,'_,-'    \\\n";
        homer += "|       (_\,-'    ,'\")--,'-'       __\\\n";
        homer += "|        \       /  // ,'|      ,--'  `-.\n";
        homer += "|         `-.    `-/ \'  |   _,'         `.\n";
        homer += "\n";
        homer += "Super Dica: Inspecionar elementos é um bom principio para aprender mais!\n";
        homer += "\n";


        console.log( homer );
    }
}
</script>
<style lang="scss">
  
</style>