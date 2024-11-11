export default {
    mounted(el, bindings) {
        if (bindings.value) {
            el.focus();
        }
    }
}