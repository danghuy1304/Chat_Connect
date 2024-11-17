<script lang="ts" setup>
import HomeContact from "./contact/HomeContact.vue";
import CreatePoster from "./create-poster/CreatePoster.vue";
</script>

<template>
    <section class="home-section">
        <div class="sidebar"></div>
        <div class="content">
            <CreatePoster />
        </div>
        <div class="contact">
            <HomeContact />
        </div>
    </section>
</template>

<style lang="css" scoped>
.home-section {
    width: 100%;
    display: flex;
}

.sidebar {
    width: var(--width-sidebar);
    height: 100%;
}

.content {
    width: var(--width-content);
    height: 100%;
    padding: 0 50px;
}

.contact {
    width: var(--width-account);
    height: 100%;
}
</style>
