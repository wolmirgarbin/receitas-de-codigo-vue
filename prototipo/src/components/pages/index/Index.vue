<template>
  <!-- HTML -->
  <div>
    <div class="container-fluid">
      <card col="4">
          <card-header title="Últimos documentos carregados" description="Abaixo estão listados os últimos 10 documentos carregados" />

          <table class="table">
              <thead>
                <tr>
                    <th>Código</th>
                    <th>Empresa</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="item in documentos">
                  <td>{{item.nota}}</td>
                    <td>{{item.empresa}}</td>
                </tr>
              </tbody>
          </table>

          <div class="card-body">
                <router-link :to="{name:'documentos'}">Ver todos os documentos</router-link>
          </div>
      </card>



      <card col="4">
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



      <card col="4">
          <card-header title="Seu plano" description="Veja quanto do seu plano está utilizando aqui" />

          <div class="card-body">
              <ui-slider show-marker v-model="slider3"></ui-slider>
          </div>
      </card>
    </div>
  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';
import { UiButton, UiConfirm, UiTextbox, UiAlert, UiSlider } from 'keen-ui';

export default {
    components: {
        AppTitle, Card, UiButton, UiConfirm, UiTextbox, UiAlert, UiSlider, CardHeader
    },
    data() {
        return {
            itens: [],
            cnpj: '',
            showAlert2: false,
            msgAlert2: '',
            slider3: 60,
            documentos: [
                {nota: 'NFe-123123123123', empresa: '00011122233'},
                {nota: 'CTe-123123123123', empresa: '00011122233'},
                {nota: 'NFe-223123123123', empresa: '00011122233'},
                {nota: 'CTe-223123123123', empresa: '00011122233'},
                {nota: 'NFe-323123123123', empresa: '00011122233'},
                {nota: 'CTe-323123123123', empresa: '00011122233'},
                {nota: 'NFe-423123123123', empresa: '00011122233'}
            ]
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
    }
}
</script>

<style scoped="" lang="scss">
  .painel-padding {
    padding: 10px;
  }
</style>