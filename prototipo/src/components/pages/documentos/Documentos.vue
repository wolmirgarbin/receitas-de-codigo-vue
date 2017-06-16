<template>
  <!-- HTML -->
  <div>
      <app-title title="Documentos" description="Veja aqui todos os documentos que tem acesso" />

      <card>
        <card-header title="Filtro de DF-e's" description="Filtro para documentos físcais eletrónicos que estejam armazanados no sistema" />

        <div class="card-body">

        </div>
      </card>


      <br><br><br><br><br><br><br><br>


      <card>
        <table class="table">
          <thead>
            <tr>
              <th>Número</th>
              <th>Chave de Acesso</th>
              <th>Empresa</th>
              <th>Emissão</th>
              <th>Carregada em</th>
              <th>Status</th>
              <th>Destinatário</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in itens">
              <td>{{item.codigo}}</td>
              <td>{{item.nome}}</td>
              <td>{{item.nome}}</td>
              <td>{{item.nome}}</td>
              <td>{{item.nome}}</td>
              <td>{{item.nome}}</td>
              <td>{{item.nome}}</td>
            </tr>
          </tbody>
        </table>
      </card>
  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';

export default {
    components: { 
      AppTitle, Card, CardHeader
    },
    data() {
        return {
            itens: []
        }
    }
}
</script>

<style lang="scss" scoped="">
  .teste {
    margin-bottom: 16px;
  }
</style>