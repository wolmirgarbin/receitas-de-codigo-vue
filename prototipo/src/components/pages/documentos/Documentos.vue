<template>
  <!-- HTML -->
  <div>

      <div class="container-fluid">
        <div class="row">
          <card col="12">

            <card-header title="Filtrar Documentos Armazenados" description="Veja aqui todos os documentos armazenados que tem acesso" />


            <form action="#" method="POST" v-on:submit.prevent="onSubmit">

              <div class="card-body clearfix">
                <div class="col-md-2">
                  <ui-textbox label="Número" placeholder="Nr. do documento" v-model="form.numero"></ui-textbox>
                </div>
                <div class="col-md-6">
                  <ui-textbox label="Chave de acesso" placeholder="Informe a chave de acesso para localizar" v-model="form.chave"></ui-textbox>
                </div>
                <div class="col-md-4">
                  <ui-select label="Tipos de arquivos" placeholder="Selecione o tipo de arquivo que quer ver" :options="tipoFiltrosArquivos" v-model="form.tipo"></ui-select>
                </div>

                <div class="col-md-12">
                  <ui-collapsible title="Opções de filtros avançados">
                    <div class="clearfix">

                      <div class="col-md-6">
                        <p class="text-center">Filtre por Data de Emissão</p>

                        <div class="col-md-6">
                          <ui-datepicker placeholder="Selecione uma data" v-model="form.emissaoInicial">Emissão Inicial</ui-datepicker>
                        </div>
                        <div class="col-md-6">
                          <ui-datepicker placeholder="Selecione uma data" v-model="form.emissaoFinal">Emissão Final</ui-datepicker>
                        </div>
                      </div>


                      <div class="col-md-6">
                        <p class="text-center">Filtre por Data de Carregamento</p>

                        <div class="col-md-6">
                          <ui-datepicker placeholder="Selecione uma data" v-model="form.carregamentoInicial">Carregamento Inicial</ui-datepicker>
                        </div>
                        <div class="col-md-6">
                          <ui-datepicker placeholder="Selecione uma data" v-model="form.carregamentoFinal">Carregamento Final</ui-datepicker>
                        </div>
                      </div>

                      <br>

                      <div class="col-md-12">
                        <div class="col-md-6">
                          <ui-textbox label="Nome do Emissor/Destinatário" placeholder="Informe parte do nome do Emissor ou Destinatário" v-model="form.relacionadaComNome"></ui-textbox>
                        </div>

                        <div class="col-md-6">
                          <ui-textbox label="CNPJ ou CPF do Emissor/Destinatário" placeholder="Informe o CNPJ ou CPF do Emissor ou Destinatário" v-model="form.relacionadaComCnpj"></ui-textbox>
                        </div>
                      </div>

                    </div>
                  </ui-collapsible>
                </div>

                <div class="col-md-12">
                  <p class="text-center">Caso não encontrar a nota, efetue o <a href="https://www.nfe.fazenda.gov.br/portal/principal.aspx">download diretamente na receita federal</a> e envie para o portal</p>

                  <ui-button buttonType="button" color="primary" @click="limpar">Limpar</ui-button>
                  <ui-button color="green" :loading="loading">Filtrar Documentos</ui-button>
                </div>

              </div>
            </form>

          </card>
        </div>

        <br>


        <div class="row">
          <card col="12">

            <card-header title="Lista de Documentos" description="Para fazer o download clique sobre a chave" />

            <table class="table">
              <thead>
                <tr>
                  <th>Número</th>
                  <th>Chave de Acesso</th>
                  <th>Empresa</th>
                  <th>Emissão</th>
                  <th>Carregada em</th>
                  <th>Status</th>
                  <th>Emissor/Destinatário</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="item in itens">
                  <td>{{item.codigo}}</td>
                  <td><a href="#">{{item.chave}}</a></td>
                  <td>{{item.empresa}}</td>
                  <td>{{item.emissao}}</td>
                  <td>{{item.carregamento}}</td>
                  <td>{{item.status}}</td>
                  <td>{{item.emitida ? '->' : '<-'}} {{item.relacionadaCom}}</td>
                </tr>
              </tbody>
            </table>
          </card>
        </div>
      </div>
  </div>
</template>


<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';
import { UiButton, UiTextbox, UiSelect, UiCollapsible, UiDatepicker } from 'keen-ui';

export default {
    components: { 
      AppTitle, Card, CardHeader, UiButton, UiTextbox, UiSelect, UiCollapsible, UiDatepicker
    },
    data() {
        return {
            itens: [
                { codigo: 125412, chave: 'NFe42140406235400000162550060001445511000422016', empresa: 'Nick Name', emissao: '12/10/2015', carregamento: '13/10/2015', status: 100, relacionadaCom:  'Empresa X', emitida: false },
                { codigo: 125412, chave: 'NFe42140406235400000162550060001445511000422016', empresa: 'Nick Name', emissao: '12/10/2015', carregamento: '13/10/2015', status: 100, relacionadaCom:  'Empresa Y', emitida: true }
            ],
            tipoFiltrosArquivos: [
                { label: 'Enviadas', value: 'ENVIADAS' },
                { label: 'Recebidas', value: 'RECEBIDAS' },
                { label: 'Todas', value: 'TODAS' },
            ],
            form: {
                tipo : 'Todas',
                chave: '',
                numero: '',
                relacionadaComNome: '',
                relacionadaComCnpj: '',
                emissaoInicial: new Date((new Date()).getFullYear(), 11, 25),
                emissaoFinal: null,
                carregamentoInicial: null,
                carregamentoFinal: null
            },
            loading : false
        }
    },
    methods : {
        onSubmit() {
            var self = this;

            this.loading = ! this.loading;

            //alert( this.form.numero );

            window.setTimeout(() => { self.loading = false; }, 2000);

        },
        limpar() {
            this.form = {
                tipo : 'Todas',
                chave: '',
                numero: '',
                relacionadaComNome: '',
                relacionadaComCnpj: '',
                emissaoInicial: null,
                emissaoFinal: null,
                carregamentoInicial: null,
                carregamentoFinal: null
            }
        }
    }
}
</script>

<style lang="scss" scoped="">
  .teste {
    margin-bottom: 16px;
  }
</style>