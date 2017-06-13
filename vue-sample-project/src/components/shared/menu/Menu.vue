<!-- alurapic/src/components/shared/menu/Menu.vue -->

<template>
    <nav>
      <span v-for="rota in rotas">
        <router-link :to="rota.path ? rota.path : '/'">{{rota.titulo}}</router-link> &nbsp;
      </span>
    </nav>

</template>
<script>
export default {

    props: {
        rotas: {
            type: Array, 
            required: true
        }
    }
}
</script>
<style scoped>

</style>