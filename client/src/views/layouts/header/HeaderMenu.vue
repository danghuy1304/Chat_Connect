<script lang="js" setup>

</script>

<template>
    <div class="header--menu">
        <div class="menu__item">
            <router-link :to="{ name: 'Home' }" v-tooltip="{ text: $t('Layout.Header.Tooltip.Home'), openDelay: 300 }">
                <i class="fa-solid fa-house"></i>
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Friend' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Friend'), openDelay: 300 }">
                <i class="fa-solid fa-user-group"></i>
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Watch' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Watch'), openDelay: 300 }">
                <i class="fa-solid fa-circle-play"></i>
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Group' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Group'), openDelay: 300 }">
                <i class="fa-solid fa-users-rectangle"></i>
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Meeting' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Meeting'), openDelay: 300 }">
                <i class="fa-solid fa-video"></i>
            </router-link>
        </div>
    </div>
</template>

<style lang="css" src="./header.css" scoped></style>
