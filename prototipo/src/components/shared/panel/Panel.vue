<template>
    <div class="container">
        <div class="row">
            <div :class="'col-md-'+ col ">
                <slot />
            </div>
        </div>
    </div>
</template>
<script>
export default {
    props: {
        col: {
            default: '12',
            required: false,
            type: String
        }
    }
}
</script>
<style scoped type="scss">

</style>