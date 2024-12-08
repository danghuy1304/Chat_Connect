<script setup>
import { ref } from "vue";
const props = defineProps({
    value: {
        type: String,
        default: null,
    },
    type: {
        type: String,
        default: null,
    },
    icon: {
        type: [String, Array],
        default: null,
    },
    tooltip: {
        type: String,
        default: "",
    },
    color: {
        type: String,
        default: null,
    },
    iconSize: {
        type: String,
        default: null,
    },
    iconColor: {
        type: String,
        default: null,
    },
    focus: {
        type: Boolean,
        default: false,
    },
    class: {
        type: String,
        default: null,
    },
});

// Khai báo biến
const refBtn = ref(null);
const focusVisible = ref(false);

const btnType = (type) => {
    switch (type) {
        case "secondary":
            return "btn-secondary";
        case "primary":
            return "btn-primary";
    }
};

// ---------------------- Hàm xử lý ----------------------------

const focus = (visible = true) => {
    refBtn.value.focus();
    focusVisible.value = visible;
};

defineExpose({
    focus,
});
</script>

<template>
    <button
        v-focus="props.focus"
        type="button"
        :style="'color:' + props.color"
        ref="refBtn"
        v-tooltip="{ disabled: tooltip === '', text: tooltip, openDelay: 300 }"
        :class="[
            btnType(props.type),
            { 'focus-visible': focusVisible },
            props.class,
        ]"
    >
        <font-awesome-icon
            v-if="icon !== null"
            :icon="props.icon"
            class="btn__icon"
            :style="{ 'font-size': iconSize, color: iconColor }"
        />
        {{ props.value }}
        <slot></slot>
    </button>
</template>

<style scoped>
button {
    cursor: pointer;
    padding: 0 15px;
    height: var(--height-btn-default);
    box-sizing: border-box;
    border-radius: var(--border-radius);
    font-weight: 600;
    width: fit-content;
    display: flex;
    justify-content: center;
    align-items: center;
    gap: 8px;
    border: 1px solid transparent;
    position: relative;
    line-height: 0;
}

button > i {
    font-size: 15px;
}

button.btn-secondary {
    background-color: var(--color-primary-opacity);
    color: var(--color-primary);
    border: 1px solid var(--color-primary);
}

button.btn-secondary:hover {
    background-color: var(--color-white);
}

button.btn-primary {
    background-color: var(--color-primary);
    color: var(--color-white);
}

button.btn-primary:hover {
    background-color: var(--color-primary-hover);
}

button.btn-primary:focus,
button.btn-primary:active {
    background-color: var(--color-primary-focus);
    color: var(--color-white);
}

button:focus-visible {
    outline: 2px solid var(--color-outline);
    outline-offset: var(--outline-offset);
}

.btn__tooltip {
    display: block;
    position: absolute;
    top: 100%;
    left: 50%;
    transform: translateX(-50%);
    border: 1px solid var(--color-greyish);
    width: fit-content;
    padding: 5px 10px;
    border-radius: var(--border-radis-components);
    color: var(--color-white);
    background-color: var(--color-black);
}

.focus-visible:focus-visible {
    outline: 2px solid var(--color-outline);
    outline-offset: var(--outline-offset);
}

.btn__icon {
    font-size: 1rem;
    color: var(--color-text);
}
</style>
