<script lang="js" setup>
import TheHeader from './header/TheHeader.vue';
import TheFooter from './footer/TheFooter.vue';
import NewMessages from '../../components/new-messages/NewMessages.vue';


</script>

<template>
    <TheHeader />
    <section>
        <router-view :key="$route.fullPath"></router-view>
        <NewMessages />
    </section>
    <TheFooter />
</template>

<style lang="css" scoped>
section {
    position: relative;
    width: 100%;
    height: 100%;
}
</style>
