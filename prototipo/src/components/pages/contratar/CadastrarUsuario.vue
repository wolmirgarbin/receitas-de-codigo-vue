<template>
  <!-- HTML -->
  <div>

      <steps step="2" />

      <div class="container">

          <card>
              <card-header style="text-align: center" title="Cadastre um usuário" description="Este usuário você utilizará para acessar o sistema sempre que precisar" />

              <div class="card-body">

                  <div class="row">
                      <div class="col-md-6">
                        <ui-textbox floatingLabel autofocus label="Nome Completo" v-model="form.nome"></ui-textbox>
                      </div>

                      <div class="col-md-6">
                          <ui-textbox floatingLabel label="E-mail (usado como usuário)" v-model="form.email"></ui-textbox>
                      </div>

                      <div class="col-md-6">
                          <ui-textbox floatingLabel label="Senha" v-model="form.senha"></ui-textbox>
                      </div>

                      <div class="col-md-6">
                          <ui-textbox floatingLabel label="Confirma Senha" v-model="form.senhaConfirma"></ui-textbox>
                      </div>
                  </div>
              </div>

              <div class="card-body">
                  <div class="clearfix">
                      <br>
                      <router-link :to="{name:'contratar'}">Voltar (Trocar plano)</router-link>
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
        UiTextbox, Card, UiButton, CardHeader, Steps
    },
    data() {
        return {
            form: {
                nome: '',
                email: '',
                senha: '',
                senhaConfirma: ''
            }
        }
    },
    methods: {
        salvar() {
            localStorage.setItem('contrato.usuario', JSON.stringify(this.form));
            this.$router.push({name: 'cadastrar-empresa'});
        }
    },
    created() {
        if( localStorage.getItem('contrato.usuario') != undefined ) {
            this.form = JSON.parse(localStorage.getItem('contrato.usuario'));
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