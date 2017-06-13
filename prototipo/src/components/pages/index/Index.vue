<template>
  <!-- HTML -->
  <div>
    <div class="container-fluid">
      <card col="4">
        <h2>Últimos documentos carregados</h2>
        <p>Abaixo estão listados os últimos 10 documentos carregados</p>

        <table class="table">
          <thead>
            <tr>
              <th>Documento</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>NFe-000000000000000000</td>
            </tr>
          </tbody>
        </table>
      </card>

      <card col="4">
        <h2>Empresas que tem acesso</h2>
        <p>Todas as empresas que tem acesso estão aqui</p>


        <table class="table">
          <thead>
          <tr>
            <th>Documento</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td class="text-left">NFe-000000000000000000</td>
          </tr>
          </tbody>
        </table>
      </card>

      <card col="4">
        <h2>Seu plano</h2>
        <p>Veja quanto do seu plano está utilizando aqui</p>

      </card>
    </div>
  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';

export default {
    components: { 
      AppTitle, Card
    }
}
</script>

<style lang="scss">
  
</style>