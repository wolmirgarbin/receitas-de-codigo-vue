<template>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h1>{{title}}</h1>
                <p v-if="description">{{description}}</p>
            </div>
        </div>
    </div>
</template>

<script>
// acmescript 6
export default {
    props: {
        title: {
            required: true,
            type: String
        },
        description: {
            required: false,
            type: String
        }
    }
}
</script>
<style scoped lang="scss">
h1, p { text-align: center; }
</style>