<!-- alurapic/src/components/help/PageNotFound.vue -->

<template>
  <div>
    <h1 class="centralizado">Página não Encontrada {{titulo}}</h1>
    <p>Esta página não foi encontrada, para voltar para a home <router-link :to="{name:'home'}">clique aqui</router-link></p>
    <img src="/static/logo.png">
  </div>
</template>
<script>
 export default {
   data() {
     return {
       titulo : 'Teste'
     }
   }
 }
</script>
<style scoped>
  .centralizado {
    text-align: center;
  }

</style>