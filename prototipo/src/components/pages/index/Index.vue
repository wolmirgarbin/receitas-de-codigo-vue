<template>
  <!-- HTML -->
  <div>
    <div class="container-fluid">

        <div class="row">
            <card col="8">
                <card-header title="Armazenamento mensal" description="Este gráfico mostra a quantidade de arquivos armazenados mensalmente no sistema" />

                <div class="card-body">
                    <uso-plano-ultimos-meses-chart :height="100" />
                </div>
            </card>

            <card col="4">
                <card-header title="Seu plano" description="Veja quanto do seu plano está utilizando" />

                <div class="card-body">
                    <uso-plano-mes-atual-chart :height="212"/>
                </div>
            </card>
        </div>

        <br />

        <div class="row">
              <card col="6">
                  <card-header title="Últimos documentos carregados" description="Abaixo estão listados os últimos 10 documentos carregados" />

                  <table class="table">
                      <thead>
                        <tr>
                            <th>Chave</th>
                            <th>Série</th>
                        </tr>
                      </thead>
                      <tbody>
                        <tr v-for="item in documentos">
                            <td>{{item.chave}}</td>
                            <td>{{item.serie}}</td>
                        </tr>
                      </tbody>
                  </table>

                  <div class="card-body">
                        <router-link :to="{name:'documentos'}">Ver todos os documentos</router-link>
                  </div>
              </card>



              <card col="6">
                  <card-header title="CNPJ's base para armazenar as notas" description="Abaixo estão todos os CNPJ's que serão utilizados na importação" />


                    <ui-alert @dismiss="showAlert2 = false" type="success" v-show="showAlert2">
                        {{msgAlert2}}
                    </ui-alert>

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Empresas</th>
                                <th>#</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr v-for="(item, index) in itens">
                                <td class="text-left">{{item}}</td>
                                <td><a href="#" @click="removeItem( index )">Remover</a></td>
                            </tr>
                        </tbody>
                    </table>


                    <ui-confirm
                            ref="basicConfirm"
                            title="Basic Confirm"
                            @confirm="onConfirm"
                            @deny="onDeny">
                      <div class="painel-padding">
                        <ui-textbox label="Informe o CNPJ" v-model="cnpj" type="number" />
                      </div>
                    </ui-confirm>

                  <div class="card-body">
                    <ui-button @click="showConfirm('basicConfirm')">Registrar novo CNPJ</ui-button>
                  </div>
              </card>
        </div>
    </div>
  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';
import { UiButton, UiConfirm, UiTextbox, UiAlert, UiSlider } from 'keen-ui';
import UsoPlanoUltimosMesesChart from '../../graficos/sample/UsoPlanoUltimosMesesChart.js';
import UsoPlanoMesAtualChart from '../../graficos/sample/UsoPlanoMesAtualChart.js';

export default {
    components: {
        AppTitle, Card, UiButton, UiConfirm, UiTextbox, UiAlert, UiSlider, CardHeader, UsoPlanoUltimosMesesChart, UsoPlanoMesAtualChart
    },
    data() {
        return {
            itens: [],
            cnpj: '',
            showAlert2: false,
            msgAlert2: '',
            slider3: 60,
            documentos: []
        }
    },
    methods: {
        showConfirm(ref) {
            this.$refs[ref].open();
        },
        hideConfirm(ref) {
            this.$refs[ref].close();
        },
        onConfirm() {
            if( this.cnpj.length < 11 ) {
                this.showAlert2 = true;
                this.msgAlert2 = 'Deve ter no mínimo 11 números!';
            } else if( this.cnpj.length > 14 ) {
                this.showAlert2 = true;
                this.msgAlert2 = 'Deve ter no maximo 14 números!';
            } else {
                this.showAlert2 = false;
                this.itens.push( this.cnpj );
                this.cnpj = '';
            }
        },
        onDeny() {
            this.cnpj = '';
        },
        removeItem(item) {
            console.log( item );
            this.itens.splice(item, 1);
        }
    },
    created() {
        this.$http.get('http://localhost:28080/dfe')
            .then(res => res.json())
            .then(documentos => this.documentos = documentos, err => console.log(err));
    }
}
</script>

<style scoped="" lang="scss">
  .painel-padding {
    padding: 10px;
  }
</style>