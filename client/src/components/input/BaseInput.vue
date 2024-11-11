<template>
    <div :class="['input', className]">
        <label class="input__label" v-if="label !== null">{{ label }}</label>
        <input class="input__field" ref="input" :type="type" v-model="inputValue" :required="props.required"
            v-tooltip="{ disabled: tooltip === '', text: tooltip, openDelay: 300 }" v-focus="props.focus"
            :placeholder="placeholder" />
        <div v-if="errorMessage" class="input__error">errorMessage</div>
    </div>
</template>

<script setup>
import { ref, watch } from "vue";

const props = defineProps({
    required: {
        type: Boolean,
        default: false
    },
    modelValue: {},
    tooltip: {
        type: String,
        default: ''
    },
    focus: {
        type: Boolean,
        default: false
    },
    type: {
        type: String,
        default: "text"
    },
    placeholder: {
        type: String,
        default: null
    },
    errorMessage: {
        type: String,
        default: null
    },
    className: {
        type: String,
        default: null
    },
    label: {
        type: String,
        default: null
    }
})
const emit = defineEmits(["update:modelValue"])
const input = ref(null)
const inputValue = ref(props.modelValue);

watch(() => inputValue.value, (newValue) => {
    emit("update:modelValue", newValue);
})
watch(() => props.modelValue, (newValue) => {
    inputValue.value = newValue
})

// ------------- Hàm xử lý -------------------

const focus = () => {
    input.value.focus();
}
defineExpose({
    focus
})
</script>

<style scoped>
input {
    height: var(--height-btn-default);
    box-sizing: border-box;
    border-radius: var(--border-radius);
    border: 1px solid var(--color-border);
    outline: none;
    padding: 0 10px;
    width: 100%;
}

input:focus {
    border: 1px solid var(--color-primary);
}

.input__label {
    display: block;
    margin-bottom: 5px;
    font-weight: 600;
}

.input__error {
    color: var(--color-red);
    margin-top: 5px;
}
</style>