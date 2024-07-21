<script lang="js" setup>
import TheHeader from './TheHeader.vue';
import TheFooter from './TheFooter.vue';


</script>

<template>
    <TheHeader />
    <section>
        <router-view :key="$route.fullPath"></router-view>
    </section>
    <TheFooter />
</template>

<style lang="css" scoped></style>
