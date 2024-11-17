<script lang="js" setup>
import TheHeader from './header/TheHeader.vue';
import TheFooter from './footer/TheFooter.vue';
import NewMessages from '../../components/new-messages/NewMessages.vue';
</script>

<template>
    <main>
        <TheHeader />
        <section class="home--container">
            <router-view :key="$route.fullPath"></router-view>
            <NewMessages />
        </section>
        <TheFooter />
    </main>
</template>

<style lang="css" scoped>
main {
    width: 100%;
    height: 100%;
    background-color: var(--bg-main);
}
.home--container {
    position: relative;
    width: 100%;
    height: 100%;
    padding: 20px;
}
</style>
