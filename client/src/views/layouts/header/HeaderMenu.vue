<script lang="js" setup>

</script>

<template>
    <div class="header--menu">
        <div class="menu__item">
            <router-link :to="{ name: 'Home' }" v-tooltip="{ text: $t('Layout.Header.Tooltip.Home'), openDelay: 300 }">
                <font-awesome-icon icon="house" class="menu__item--icon" />
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Friend' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Friend'), openDelay: 300 }">
                <font-awesome-icon icon="user-group" class="menu__item--icon" />
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Watch' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Watch'), openDelay: 300 }">
                <font-awesome-icon icon="circle-play" class="menu__item--icon" />
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Group' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Group'), openDelay: 300 }">
                <font-awesome-icon icon="users-rectangle" class="menu__item--icon" />
            </router-link>
        </div>
        <div class="menu__item">
            <router-link :to="{ name: 'Meeting' }"
                v-tooltip="{ text: $t('Layout.Header.Tooltip.Meeting'), openDelay: 300 }">
                <font-awesome-icon icon="video" class="menu__item--icon" />
            </router-link>
        </div>
    </div>
</template>

<style lang="css" src="./header.css" scoped></style>
