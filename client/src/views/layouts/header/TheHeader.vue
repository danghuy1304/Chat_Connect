<script lang="js" setup>
import HeaderMenu from './HeaderMenu.vue';


</script>

<template>
    <header>
        <div class="header--left">
            <div class="header--logo">
                <router-link to="/">
                    <img src="@/assets/images/logo.png" alt="logo" />
                </router-link>
            </div>
            <div class="header--search">
                <div class="search__box">
                    <i class="fa-solid fa-magnifying-glass"></i>
                    <input type="text" :placeholder="$t('Layout.Header.Tooltip.Search')" />
                </div>
            </div>
        </div>
        <div class="header--center">
            <HeaderMenu />
        </div>
        <div class="header--right">
            <div class="header--message header--button">
                <b-button icon="fa-brands fa-facebook-messenger" color="var(--color-light-grey)" tooltip="Thông báo"
                    iconSize="var(--front-size-icon)" />
            </div>
            <div class="header--notification header--button">
                <b-button icon="fa-solid fa-bell" color="var(--color-light-grey)" tooltip="Thông báo"
                    iconSize="var(--front-size-icon)" />
            </div>
            <div class="header--profile header--button">
                <b-button icon="fa-solid fa-user" color="var(--color-light-grey)" tooltip="Trang cá nhân"
                    iconSize="var(--front-size-icon)" />
            </div>
        </div>
    </header>
</template>

<style lang="css" src="./header.css" scoped></style>
