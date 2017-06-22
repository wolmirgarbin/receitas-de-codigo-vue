<template>
    <div>
        <div class="container-fluid topo">
            <app-title title="Contrate o Portal DF-e" description="Contratar o portal DF-e é muito fácil e leva menos de 2 minutos" />
        </div>

        <div class="container steps">
            <div class="row">
                <div class="col-md-3">
                    <span :class="step == 1 ? 'ativo': 'inativo'">01 <i>Plano</i></span>
                </div>
                <div class="col-md-3">
                    <span :class="step == 2 ? 'ativo': 'inativo'">02 <i>Usuário</i></span>
                </div>
                <div class="col-md-3">
                    <span :class="step == 3 ? 'ativo': 'inativo'">03 <i>Empresas</i></span>
                </div>
                <div class="col-md-3">
                    <span :class="step == 4 ? 'ativo': 'inativo'">04 <i>Verificação</i></span>
                </div>
            </div>
        </div>

    </div>
</template>
<script>
import AppTitle from '../../shared/app-title/AppTitle.vue';

export default {
    props: {
        step: {
            default: 1,
            required: false,
            type: String
        }
    },
    components: {
        AppTitle
    }
}
</script>
<style scoped type="scss">
    .topo {
        padding: 16px;
        color: #FFFFFF;
        background: #1565c0;
    }
    .steps {
        margin-top: 16px;
        margin-bottom: 16px;
        text-align: center;
        background-color: #78909C;
        padding: 20px;
        color: #FFF;
        font-weight: bold;
        font-size: 20px;
    }
    .ativo {
        opacity: 1;
    }
    .inativo {
        opacity: 0.3;
    }
</style>