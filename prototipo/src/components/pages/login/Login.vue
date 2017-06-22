<template>
    <div class="page">

        <app-title title="Portal DF-e" description="Arquivo de documentos físcais eletrônicos" />

        <div class="container-fluid text-center line-login">
            <div class="row">
                <div class="col-md-12">
                    <h2>Aqui você pode</h2>
                </div>
            </div>

            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <h3>Arquivar NF-e e CT-e</h3>
                        <p>No portal DF-e da Viasoft você pode armazenar todas as suas NF-e e seus CT-e com segurança e comodidade.</p>
                    </div>
                    <div class="col-md-4">
                        <h3>Consultar a hora que precisar</h3>
                        <p>Sempre que precisar recuperar documentos, temos o melhor mecanismo de busca para localizar os documentos com facilidade e praticidade</p>
                    </div>
                    <div class="col-md-4">
                        <h3>Fazer manifestação destinatário</h3>
                        <p>Precisa fazer a manifestação de destinatário? Faça pelo portal a hora que precisar.</p>
                    </div>
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <card col="12">
                        <card-header style="text-align: center;" title="Já tem um usuário" description="Se você já tem um cadastro no sistema informe seu usuário e senha" />

                        <div class="card-body">
                            <ui-alert type="error" v-show="mensagem">
                                {{mensagem}}
                            </ui-alert>


                            <form action="/login" method="POST" @submit.prevent="onSubmit">

                                <ui-textbox
                                        floating-label
                                        label="Usuário"
                                        placeholder="Informe seu usuário"
                                        v-model="usuario">
                                </ui-textbox>

                                <ui-textbox
                                        floating-label
                                        label="Senha"
                                        placeholder="Informe sua senha"
                                        v-model="senha"
                                        type="password">
                                </ui-textbox>

                                <ui-button color="primary">LOGIN</ui-button>
                                <ui-button buttonType="button" class="pull-right">Recuperar Senha</ui-button>
                            </form>
                        </div>
                    </card>
                </div>

            </div>
        </div>





        <div class="container-fluid text-center line-login line-contrata">

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Contrate o Portal</h2>
                        <p>Contratar o portal é muito fácil e leva menos de 2 minutos. Informe seu e-mail e veja as opções</p>
                        <div class="card-body">
                            <ui-button @click="toContratar" color="orange">CONTRATAR PORTAL</ui-button>
                        </div>
                    </div>
                </div>
            </div>
        </div>



        <div class="container-fluid text-center">

            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <h2>Contato</h2>
                        <p>Para mais informações entre em contato, ficaremos felizes em lhe atender</p>
                        <div class="card-body">
                            <ui-button @click="toContratar" color="orange">CONTRATAR PORTAL</ui-button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>
</template>

<script src="./Login.js"></script>

<style scoped lang="scss">
  @import './Login.scss';
</style>