<!-- alurapic/src/App.vue -->

<template>
  <div class="corpo">

    <meu-menu :rotas="routes"/>

    <transition name="pagina">
      <div class="relativo">
        <!-- é aqui que encontrará os componentes de página que queremos visualizar -->
        <router-view></router-view>
      </div>
    </transition>

  </div>
</template>

<script>
import { routes }  from './routes';
import Menu from './components/shared/menu/Menu.vue';

export default {
  components: {
    'meu-menu' : Menu
  },
  data() {
    return {
      routes : routes.filter(route => route.menu)
    }
  }
}
</script>

<style>
  .corpo {
    font-family: Helvetica, sans-serif;
    margin: 0 auto;
    width: 96%;
  }
  .relativo {
    position: relative;
  }
  .pagina-enter-active, .pagina-leave-active {
    transition: opacity .3s
  }
  .pagina-enter, .pagina-leave-active {
    opacity: 0
  }
</style>