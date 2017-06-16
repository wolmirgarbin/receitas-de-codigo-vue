<template>
  <!-- HTML -->
  <div class="container-fluid">

    <div class="row">
      <card col="12">
        <card-header title="Usuários do sistema" description="Aqui você configura todos os usuários que tem acesso aos documentos eletrônicos" />

        <div class="card-body">

        </div>
      </card>
    </div>

    <br>

    <div class="row">
      <card col="12">
        <card-header title="Usuários x Permissão" description="Atribua ou retire permissões dos usuários cadastrados para sua empresa" />

        <div class="card-body">

        </div>
      </card>
    </div>

  </div>
</template>

<script>
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';

export default {
    components: { 
      Card, CardHeader
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