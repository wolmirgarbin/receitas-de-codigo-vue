<template>
  <!-- HTML -->
  <div>

    <app-title title="Usuários" description="Configure nesta tela todos os usuários e acessos" />


  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Panel from '../../shared/panel/Panel.vue';
import AppInput from '../../shared/input/Input.vue';

export default {
    components: { 
      AppTitle, Panel, AppInput
    },
    data() {
        return {
            itens: []
        }
    }
}
</script>

<style lang="scss">
  
</style>