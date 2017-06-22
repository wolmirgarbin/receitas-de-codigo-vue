<template>
    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <router-link class="navbar-brand" :to="{name:'index'}">Portal DF-e</router-link>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <router-link class="link-color" :to="{name:'documentos'}">Todos os documentos</router-link>
                    </li>
                    <!--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Cadastros <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><router-link :to="{name:'clientes'}">Clientes</router-link></li>
                            <li><router-link :to="{name:'cliente-form'}">Manutenção de Cliente</router-link></li>
                        </ul>
                    </li>-->
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Configuração <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><router-link :to="{name:'usuarios'}">Usuários</router-link></li>
                        </ul>
                    </li>
                </ul>
                <!--form class="navbar-form navbar-left">
                    <div class="form-group">
                    <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form -->
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Usuário <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li>
                            <router-link :to="{name:'meus-dados'}">Meus dados</router-link>
                        </li>
                        <li role="separator" class="divider"></li>
                        <li>
                            <a href="#" @click="logoutTela">Sair</a>
                        </li>
                    </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>
<script>
export default {
    methods: {
        logoutTela() {
            localStorage.clear();
            this.$router.push('/');
            this.$emit('logoutIn', false);
        }
    }
}
</script>
<style lang="scss" scoped>
    .link-color {
        color: #FFF !important;
    }
</style>