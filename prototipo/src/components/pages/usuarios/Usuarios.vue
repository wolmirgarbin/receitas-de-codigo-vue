<template>
  <!-- HTML -->
  <div class="container-fluid">

    <div class="row">
      <card col="12">
        <card-header title="Usuários do sistema" description="Aqui você configura todos os usuários que tem acesso aos documentos eletrônicos" />

        <form action="#" method="POST" @submit.prevent="onSubmit">

          <div class="card-body clearfix">
            <div class="col-md-2">
              <ui-textbox label="Código" placeholder="Gerado automanticamente" v-model="form.codigo" disabled></ui-textbox>
            </div>
            <div class="col-md-4">
              <ui-textbox label="Nome" placeholder="Nome completo do usuário" v-model="form.nome"></ui-textbox>
            </div>
            <div class="col-md-3">
              <ui-textbox label="Usuário" placeholder="Usuário para utilizar no campo login" v-model="form.usuario"></ui-textbox>
            </div>
            <div class="col-md-3">
              <ui-textbox label="E-mail" placeholder="E-mail para contato e notificações" v-model="form.email"></ui-textbox>
            </div>

            <div class="col-md-12">
              <ui-checkbox-group :options="['Dashboard', 'Listas notas', 'Baixar notas', 'Usuários']" v-model="form.roles">Permissões</ui-checkbox-group>
            </div>


            <div class="col-md-12">
              <ui-button buttonType="button" color="primary" @click="limpar">Limpar</ui-button>
              <ui-button color="green" :loading="loading">Salvar Usuário</ui-button>
            </div>

          </div>
        </form>
      </card>
    </div>

    <br>

    <div class="row">
      <card col="12">
        <card-header title="Usuários x Permissão" description="Atribua ou retire permissões dos usuários cadastrados para sua empresa" />

        <table class="table">
          <thead>
              <tr>
                <th>Código</th>
                <th>Usuário</th>
                <th>Nome</th>
                <th>E-mail</th>
                <th>Acessos</th>
              </tr>
          </thead>
          <tbody>
              <tr v-for="item in itens">
                <td>{{item.codigo}}</td>
                <td><a href="#" @click.prevent="editar(item)">{{item.usuario}}</a></td>
                <td>{{item.nome}}</td>
                <td>{{item.email}}</td>
                <td>{{item.roles}}</td>
              </tr>
          </tbody>
        </table>
      </card>
    </div>

  </div>
</template>

<script>
import Card from '../../shared/card/Card.vue';
import CardHeader from '../../shared/card/CardHeader.vue';
import { UiButton, UiTextbox, UiSelect, UiCollapsible, UiDatepicker, UiCheckboxGroup } from 'keen-ui';

export default {
    components: { 
      Card, CardHeader, UiButton, UiTextbox, UiSelect, UiCollapsible, UiDatepicker, UiCheckboxGroup
    },
    data() {
        return {
            itens: [],
            form: {
                codigo: '',
                nome: '',
                usuario: '',
                email: '',
                roles: []
            },
            loading : false
        }
    },
    methods: {
        onSubmit() {
            var self = this;

            this.itens.push( this.form );

            this.limpar();

            self.loading = true;

            setTimeout(() => { self.loading = false; }, 1500);
        },
        limpar() {
            this.form = {
                codigo: '',
                  nome: '',
                  usuario: '',
                  email: '',
                  roles: []
            }
        },
        editar(item) {
            this.form = item;
        }
    }
}
</script>

<style lang="scss">
  
</style>