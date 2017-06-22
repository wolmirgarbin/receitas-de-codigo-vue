<template>
  <!-- HTML -->
  <div>

      <steps step="1" />


      <div class="container">

          <card>
              <card-header style="text-align: center" title="Selecione um Plano" description="Selecione o plano que melhor se adapta a sua empresa" />

              <table class="table">
                  <thead>
                    <tr>
                        <th>Plano de Armazenamento</th>
                        <th>Valor Mensal</th>
                        <th>Valor Anual</th>
                        <th>#</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="item in itens">
                        <td>Até {{item.plano}} DF-e/mês</td>
                        <td>R$ {{item.mes}}</td>
                        <td>R$ {{item.ano}}</td>
                        <td><ui-button color="green" buttonType="button" @click="salvaEtapa( item )">Contratar</ui-button></td>
                    </tr>
                  </tbody>
              </table>
          </card>

      </div>
  </div>
</template>

<script>
import Card from '../../shared/card/Card.vue';
import Steps from './Steps.vue';
import CardHeader from '../../shared/card/CardHeader.vue';
import { UiButton, UiConfirm, UiTextbox, UiAlert, UiSlider } from 'keen-ui';

export default {
    components: {
        Card, UiButton, CardHeader, Steps
    },
    data() {
        return {
            itens: [
                { plano: '100', mes: '25,00', ano: '250,00' },
                { plano: '250', mes: '70,00', ano: '700,00' },
                { plano: '500', mes: '95,00', ano: '950,00' },
                { plano: '1.000', mes: '190,00', ano: '1950,00' },
                { plano: '2.000', mes: '332,00', ano: '3320,00' },
                { plano: '3.000', mes: '475,00', ano: '4750,00' },
                { plano: '4.000', mes: '617,00', ano: '6170,00' },
                { plano: '5.000', mes: '760,00', ano: '7600,00' },
                { plano: '6.000', mes: '902,00', ano: '9020,00' },
                { plano: '7.000', mes: '1.045,00', ano: '10.450,00' },
                { plano: '8.000', mes: '1.188,00', ano: '11.880,00' },
                { plano: '9.000', mes: '1.331,00', ano: '13.310,00' },
                { plano: '10.000', mes: '1.474,00', ano: '14.740,00' },
                { plano: '> 10.000', mes: 'Sob Consulta', ano: 'Sob Consulta' }
            ]
        }
    },
    methods: {
        salvaEtapa( item ) {
            localStorage.setItem( 'contrato.plano',  JSON.stringify(item) );
            this.$router.push({name: 'cadastrar-usuario'});
        }
    },
    created() {

    }
}
</script>

<style scoped lang="scss">
.table > thead > tr > td, .table > tbody > tr > td, .table > tfoot > tr > td {
    vertical-align: center;
}
</style>