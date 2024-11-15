<script setup>
import { onMounted, ref, watch } from "vue";

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
    errors: {
        type: [String, Array],
        default: null
    },
    className: {
        type: String,
        default: null
    },
    label: {
        type: String,
        default: null
    },
    countChar: {
        type: Boolean,
        default: false
    },
    autocomplete: {
        type: Boolean,
        default: false
    },
    min: {
        type: [Number, String],
        default: null
    },
    max: {
        type: [Number, String],
        default: null
    },
    readonly: {
        type: [Boolean, String],
        default: false
    },
    accept: {
        type: String,
        default: null
    },
    showPassword: {
        type: [Boolean, String],
        default: false
    },
    icon: {
        type: [String, Array],
        default: null
    }
})
const emit = defineEmits(["update:modelValue"]);
const input = ref(null);
const inputValue = ref(props.modelValue);
const isError = ref(false);
const countChar = ref(0);
const isOverLimit = ref(false);
const iconEye = ref('eye');

onMounted(() => {
    const hasError = props.errors !== null && props.errors !== '' && props.errors.length > 0 && !props.errors.every(error => error === '');
    if (hasError) {
        isError.value = true;
    }
})

watch(() => inputValue.value, (newValue, oldValue) => {
    emit("update:modelValue", newValue);
    isError.value = newValue === oldValue;
    countChar.value = newValue.length;
    isOverLimit.value = countChar.value > props.max;
})

watch(() => props.modelValue, (newValue) => {
    inputValue.value = newValue;
    countChar.value = newValue.length;
})

// ------------- Hàm xử lý -------------------
const togglePassword = () => {
    input.value.type = input.value.type === 'password' ? 'text' : 'password';
    iconEye.value = input.value.type === 'password' ? 'eye' : 'eye-slash';
}

const handleClickIcon = () => {
    emit('clickIcon');
}

const focus = () => {
    input.value.focus();
}
defineExpose({
    focus
})
</script>

<template>
    <div :class="['input', className]">
        <label class="input__label" v-if="label !== null">{{ label }}</label>
        <div class="input__field-container" v-if="type === 'textarea'">
            <textarea :class="['input__field', { 'input__error': isError }]" ref="input" v-model="inputValue"
                :required="props.required" v-tooltip="{ disabled: tooltip === '', text: tooltip, openDelay: 300 }"
                v-focus="props.focus" :placeholder="placeholder" :maxlength="props.max"></textarea>
            <div v-if="props.countChar && props.max !== null"
                :class="['count-char', { 'textarea__over-limit': isOverLimit }]">
                <span>{{ countChar }} / {{ props.max }}</span>
            </div>
        </div>
        <div class="input__field-container" v-else>
            <input :class="['input__field', { 'input__error': isError }]" ref="input" :type="type" v-model="inputValue"
                :required="props.required" v-tooltip="{ disabled: tooltip === '', text: tooltip, openDelay: 300 }"
                v-focus="props.focus" :placeholder="placeholder" :min="props.min" :max="props.max"
                :readonly="props.readonly" :accept="props.accept" />
            <font-awesome-icon v-if="props.type === 'password' && props.showPassword" :icon="['fas', iconEye]"
                class="input__icon" @click="togglePassword" />
        </div>
        <font-awesome-icon v-if="icon !== null" :icon="icon" class="input__icon" @click="handleClickIcon" />
        <div v-if="isError" class="error__messages">
            <div v-if="typeof props.errors === 'string'" class="error__messages--item">{{ props.errors }}</div>
            <div v-if="Array.isArray(props.errors)" class="error__messages--item" v-for="error in props.errors"
                :key="error">{{ error }}</div>
        </div>
    </div>
</template>

<style scoped>
textarea.input__field,
input.input__field {
    min-height: var(--height-btn-default);
    box-sizing: border-box;
    border-radius: var(--border-radius);
    border: 1px solid var(--color-border);
    outline: none;
    padding: 0 10px;
    width: 100%;
}

textarea.input__field {
    padding: 5px 10px;
}

.input .input__field-container {
    position: relative;
}

.input__icon {
    position: absolute;
    right: 10px;
    top: 50%;
    transform: translateY(-50%);
    cursor: pointer;
    color: var(--color-grey);
}

.input__field:focus {
    border: 1px solid var(--color-primary);
}

.input__label {
    display: block;
    margin-bottom: 5px;
    font-weight: 600;
}

.count-char {
    display: flex;
    justify-content: end;
    font-size: 0.8rem;
    color: var(--color-grey);
}

.input__field.input__error {
    border-color: var(--color-red);
}

.error__messages {
    color: var(--color-red);
    margin-top: 4px;
}

.textarea__over-limit {
    color: var(--color-red);
}

.error__messages--item {
    font-size: 1rem;
}
</style>