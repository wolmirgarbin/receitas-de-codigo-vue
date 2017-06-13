<template>
    <div :class="'col-md-'+ col ">
        <div class="card clearfix">
            <slot />
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