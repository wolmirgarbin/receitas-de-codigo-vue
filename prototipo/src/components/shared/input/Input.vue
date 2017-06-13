<template>
    <div :class="'form-group col-md-'+ col">
        <label :for="id">{{label}} {{required ? '*' : ''}}</label>
        <input :id="id" class="form-control" :type="type" :placeholder="placeholder" :required="required" />
    </div>
</template>

<script>
export default {
  props: {
    id : {
      required: true,
      type: String
    },
    label : {
      required: true,
      type: String
    },
    type : {
      default: 'text',
      required: false,
      type: String
    },
    placeholder: {
      default: '',
      required: false,
      type: String
    },
    col: {
      default: '12',
      required: false,
      type: String
    },
    required: {
      default: false,
      required: false,
      type: Boolean
    }
  }
}
</script>
<style lang="scss">
  
</style>