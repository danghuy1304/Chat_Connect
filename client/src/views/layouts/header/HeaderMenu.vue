<script lang="js" setup>

</script>

<template>
    <div class="header--menu">
        <div class="menu__item">
            <router-link :to="{ name: 'Home' }">
                <i class="fa-solid fa-house"></i>
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Friend' }">
                <i class="fa-solid fa-user-group"></i>
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Watch' }">
                <i class="fa-solid fa-circle-play"></i>
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Group' }">
                <i class="fa-solid fa-users-rectangle"></i>
            </router-link>
        </div>
    </div>
</template>

<style lang="css" src="./header.css" scoped></style>
