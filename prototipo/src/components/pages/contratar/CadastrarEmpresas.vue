<template>
  <!-- HTML -->
  <div>

      <steps step="3" />

      <div class="container">

          <card>
              <card-header style="text-align: center" title="Cadastro de Empresa" description="Cadastre uma ou mais empresas que quer armazenar os documentos físcais, incluindo filiais" />

              <div class="card-body">

                  <div class="row">
                      <div class="col-md-6">
                          <ui-textbox floatingLabel autofocus label="Nome/Razão social da Empresa" v-model="form.nome"></ui-textbox>
                      </div>

                      <div class="col-md-6">
                          <ui-textbox floatingLabel label="CNPJ" v-model="form.cnpj"></ui-textbox>
                      </div>

                      <div class="col-md-6">
                          <ui-textbox floatingLabel label="Cidade" v-model="form.cidade"></ui-textbox>
                      </div>

                      <div class="col-md-6">
                          <ui-textbox floatingLabel label="Observação" v-model="form.observacao"></ui-textbox>
                      </div>

                      <div class="col-md-12">
                          <ui-button class="pull-right" color="green" @click="adicionar">Adicionar Empresa</ui-button>
                      </div>
                  </div>
              </div>


              <table class="table">
                  <thead>
                    <tr>
                        <th>Razão Social</th>
                        <th>CNPJ</th>
                        <th>Cidade</th>
                        <th>#</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr v-for="(item, index) in itens">
                        <td>{{item.nome}}</td>
                        <td>{{item.cnpj}}</td>
                        <td>{{item.cidade}}</td>
                        <td><a href="#" @click.prevent="remover(index)">Remover</a></td>
                    </tr>
                  </tbody>
              </table>


              <div class="card-body">
                  <div class="clearfix">
                      <br>
                      <router-link :to="{name:'cadastrar-usuario'}">Voltar (Editar usuário)</router-link>
                      <ui-button class="pull-right" color="green" @click="salvar">salvar e prosseguir</ui-button>
                  </div>
              </div>
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
        Card, UiButton, CardHeader, Steps, UiTextbox
    },
    data() {
        return {
            itens: [],
            form : {
                nome: '',
                cnpj: '',
                cidade: '',
                observacao: ''
            }
        }
    },
    methods: {
        adicionar() {
            this.itens.push( this.form );

            this.form = {
                nome: '',
                cnpj: '',
                cidade: '',
                observacao: ''
            };

            localStorage.setItem('contrato.empresas', JSON.stringify( this.itens ));
        },
        salvar() {
            this.$router.push({name: 'cadastrar-verificacao'});
        },
        remover(index) {
            this.itens.splice(index, 1);
        }
    },
    created() {
        if( localStorage.getItem('contrato.empresas') != undefined ) {
            this.itens = JSON.parse(localStorage.getItem('contrato.empresas'));
        }
    }
}
</script>

<style scoped lang="scss">
  .topo {
      padding: 16px;
      color: #FFFFFF;
      background: #1565c0;
  }
</style>