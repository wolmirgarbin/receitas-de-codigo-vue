<template>
  <!-- HTML -->
  <div>

      <steps step="4" />

      <div class="container">

          <div class="row">
              <card col="6">
                  <card-header style="text-align: center" title="Plano Selecionado" description="O plano escolhido é o melhor para você e sua empresa?" />

                  <div class="card-body text-center destaque">
                      <p>Até {{plano.plano}} DF-e/mês de armazenamento</p>
                      <p>R$ {{plano.mes}} por mês</p>
                      <p>R$ {{plano.ano}} por ano</p>

                      <router-link :to="{name: 'contratar'}">Mudar o Plano</router-link>
                  </div>
              </card>

              <card col="6">
                  <card-header style="text-align: center" title="Usuário Cadastrado" description="Seu nome, e-mail e senha estão todos corretos?" />

                  <div class="card-body text-center destaque">
                      <p>Seu nome é {{usuario.nome}}</p>
                      <p>Seu e-mail principal é {{usuario.email}}</p>
                      <p>Senha *******</p>

                      <router-link :to="{name: 'cadastrar-usuario'}">Alterar o Usuário</router-link>
                  </div>
              </card>
          </div>

          <br />

          <div class="row">
              <card col="12">
                  <card-header style="text-align: center" title="Empresas Cadastradas" description="O CNPJ de cada empresa estão corretos?" />

                  <table class="table">
                      <thead>
                          <tr>
                              <th>Razão Social</th>
                              <th>CNPJ</th>
                              <th>Cidade</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr v-for="(item, index) in empresas">
                              <td>{{item.nome}}</td>
                              <td>{{item.cnpj}}</td>
                              <td>{{item.cidade}}</td>
                          </tr>
                      </tbody>
                  </table>


                  <div class="card-body text-center">
                      <router-link :to="{name: 'cadastrar-empresa'}">Alterar Empresas</router-link>
                  </div>
              </card>
          </div>

          <br />

          <div class="row">
              <card>
                  <card-header style="text-align: center" title="Todos os dados estão corretos?" description="Caso todos os dados estiverem corretos, clique em Concluir Cadastro para iniciar!" />

                  <div class="card-body text-center">
                      <ui-button @click="concluir" color="orange">Concluir Cadastro</ui-button>
                  </div>
              </card>
          </div>


          <br />
          <br />
          <br />

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
    computed: {
        plano() {
            return JSON.parse(localStorage.getItem('contrato.plano'));
        },
        usuario() {
            return JSON.parse(localStorage.getItem('contrato.usuario'));
        },
        empresas() {
            return JSON.parse(localStorage.getItem('contrato.empresas'));
        }
    },
    methods: {
        concluir() {
            // TODO - gravar os dados e limpar no localStorage

            this.$router.push({name: 'login'});
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
    .destaque {
        background: #F5F5F5;
    }
    .destaque p {
        font-weight: bold;
        color: #333;
        font-size: 16px;
    }
</style>