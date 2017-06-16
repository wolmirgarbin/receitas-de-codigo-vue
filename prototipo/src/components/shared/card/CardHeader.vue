<template>
    <div class="card-header">
        <h2 class="card-title">{{title}}</h2>
        <p>{{description}}</p>
    </div>
</template>
<script>
export default {
    props: {
        title: {
            required: true,
            type: String
        },
        description: {
            default: '',
            required: false,
            type: String
        }
    }
}
</script>
<style scoped type="scss">

</style>