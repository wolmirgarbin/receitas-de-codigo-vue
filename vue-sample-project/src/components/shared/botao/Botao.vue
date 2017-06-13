<!-- alurapic/src/components/shared/botao/Botao.vue -->
<template>
    <button :class="estiloDoBotao" :type="tipo" @click="disparaAcao()">{{rotulo}}</button>
</template>
<script>
export default {
   props: {
   		tipo: {
	        required: true,
	        type: String
	    },

	    rotulo: {
	        required: true,
	        type: String
	    },

	    confirmacao: {
	        required: false,
	        default: false,
	        type: Boolean
	    },

	    estilo: {
	        required: false,
	        default: 'padrao',
	        type: String
	    }
   },
   methods: {

       disparaAcao() {
           if(this.confirmacao) {

               if(confirm('Confirma operacao?')) {
                    this.$emit('botaoAtivado');
               }
               return;
           }
           this.$emit('botaoAtivado');
       }
   },
   computed: {
       estiloDoBotao() {
           // se o valor é padrão ou não passou nada para estilo
           if(this.estilo == 'padrao') return 'botao botao-padrao';
           if(this.estilo == 'perigo') return 'botao botao-perigo';
       }
   }
}
</script>    

<style scoped lang="sass">
    @import './Botao.scss';
</style>