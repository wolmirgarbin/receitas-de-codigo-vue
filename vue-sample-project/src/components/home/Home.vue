<template>
  <div>
    <h1 class="centralizado" v-meu-transform:scale.animate="1.2">Fotos</h1>

    <!-- novo elemento para exibir mensagens para o usuário -->
    <p v-show="mensagem" class="centralizado">{{ mensagem }}</p>

    <input type="search" v-on:input="filtro = $event.target.value" class="filtro" placeholder="filtre pelo título da foto" :focus="foco">
    <button @click="updateFoco">YTEsteste</button>

    <ul class="lista-fotos">
      <li class="lista-fotos-item" v-for="foto of fotosComFiltro">
          
          <meu-painel2 :titulo="foto.titulo">
            <imagem-responsiva :url="foto.url" :titulo="foto.titulo" v-meu-transform:rotate.animate.reverse="15" />

            <router-link :to="{ name: 'altera', params: { id : foto._id }}">
              <meu-botao 
                rotulo="Alterar" 
                tipo="button"/>
            </router-link>  

            <meu-botao rotulo="remover" estilo="perigo" tipo="button" :confirmacao="true" @botaoAtivado="remove(foto)"/>
          </meu-painel2>

      </li>
    </ul>


    <componente-qualquer>
        <div slot="cabecalho">
            <h1>Bem-vindo!</h1>
        </div>
        <p>Seja bem-vindo à Alura!</p>
        <div slot="rodape">
            <p>copyright 2017</p>
        </div>
    </componente-qualquer>


  </div>
</template>

<script>
// importando nosso Painel 
import Painel from '../shared/painel/Painel.vue';
import ComponenteQualquer from '../shared/painel/ComponenteQualquer.vue';
import ImagemResponsiva from '../shared/imagem-responsiva/ImagemResponsiva.vue';

// Fazendo o import do botão. Não esqueça de adicioná-lo em components
import Botao from '../shared/botao/Botao.vue';

// importando FotoService
import FotoService from '../../domain/foto/FotoService';


export default {
  components: {
    'meu-painel2': Painel,
    'componente-qualquer': ComponenteQualquer,
    'imagem-responsiva': ImagemResponsiva,
    'meu-botao': Botao
  },
  data() {
    return {
      fotos: [],
      resource: {},
      filtro : '',
      recebeFoco : false,
      mensagem: ''
    } 
  },
  methods: {
    remove(foto) {
      alert(foto.titulo);
    },
    updateFoco() {
      this.recebeFoco = true;
    },
    remove(foto) {
      this.service
        .apaga(foto._id)
        .then(() => {
            let indice = this.fotos.indexOf(foto);
            this.fotos.splice(indice, 1);
            this.mensagem = 'Foto removida com sucesso'
          }, 
          err => this.mensagem = err.message
        )
    }
  },
  computed: {
    fotosComFiltro() {
      if (this.filtro) {
        // criando uma expressão com o valor do filtro, insensitivo
        let exp = new RegExp(this.filtro.trim(), 'i');
        // retorna apenas as fotos que condizem com a expressão
        return this.fotos.filter(foto => exp.test(foto.titulo));
      } else {
        // se o campo estiver vazio, não filtramos, retornamos a lista
        return this.fotos;
      }
    },
    foco() {
      return this.recebeFoco;
    }
  },
  created() {

    // criando uma instância do nosso serviço que depende de $resource
    this.service = new FotoService(this.$resource);

    this.service
      .lista()
      .then(
        fotos => this.fotos = fotos, 
        err => this.mensagem = err.message
      );
  }
}
</script>

<style lang="scss">
  .centralizado {
    text-align: center;
  }

  .lista-fotos {
    list-style: none;
  }

  .imagem-responsiva {
    width: 100%;
  }

  .lista-fotos .lista-fotos-item {
    display: inline-block;
  }

  /* estilo do painel */ 

   .painel {
    padding: 0 auto;
    border: solid 2px grey;
    display: inline-block;
    margin: 5px;
    box-shadow: 5px 5px 10px grey;
    width: 200px;
    height: 100%;
    vertical-align: top;
    text-align: center;
  }

  .painel .painel-titulo {
    text-align: center;
    border: solid 2px;
    background: lightblue;
    margin: 0 0 15px 0;
    padding: 10px;
    text-transform: uppercase;
  }
  .filtro {
    display: block;
    width: 100%;
  }
</style>