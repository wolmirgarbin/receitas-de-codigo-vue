<template>
  <!-- HTML -->
  <div>

    <app-title title="Clientes" description="Acesse todos os clientes" />

    <panel>
      <app-input id="search" label="Busca" placeholder="Digite aqui ..." />
      <table class="table">
        <thead>
          <tr>
            <th>Código</th>
            <th>Nome</th>
            <th>#</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in itens">
            <td>{{item.codigo}}</td>
            <td>{{item.nome}}</td>
            <td>
              <a href="#">Detalhes</a> | <a href="#">Editar</a>
            </td>
          </tr>
        </tbody>
      </table>
    </panel>
  </div>
</template>

<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';
import Panel from '../../shared/panel/Panel.vue';
import AppInput from '../../shared/input/Input.vue';

export default {
    components: { 
      AppTitle, Panel, AppInput
    },
    data() {
        return {
            itens: []
        }
    }
}
</script>

<style lang="scss">
  
</style>