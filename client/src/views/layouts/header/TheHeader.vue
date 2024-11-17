<script lang="js" setup>
import HeaderMenu from './HeaderMenu.vue';
</script>

<template>
    <header>
        <div class="header--left">
            <div class="header--logo">
                <router-link to="/">
                    <font-awesome-icon
                        class="header--logo--icon"
                        :icon="['fab', 'snapchat']"
                    />
                </router-link>
            </div>
            <div class="header--search">
                <div class="search__box">
                    <label class="search__box--icon" for="search-input">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </label>
                    <b-input
                        id="search-input"
                        type="text"
                        :placeholder="$t('Layout.Header.Tooltip.Search')"
                    />
                </div>
            </div>
        </div>
        <div class="header--center">
            <HeaderMenu />
        </div>
        <div class="header--right">
            <div class="header--messenger header--button">
                <b-button
                    icon="fa-brands fa-facebook-messenger"
                    color="var(--color-light-grey)"
                    :tooltip="$t('Layout.Header.Tooltip.Messenger')"
                    iconSize="var(--front-size-icon)"
                />
            </div>
            <div class="header--notification header--button">
                <b-button
                    icon="bell"
                    color="var(--color-light-grey)"
                    :tooltip="$t('Layout.Header.Tooltip.Notification')"
                    iconSize="var(--front-size-icon)"
                />
            </div>
            <div class="header--profile header--button">
                <b-button
                    icon="user"
                    color="var(--color-light-grey)"
                    :tooltip="$t('Layout.Header.Tooltip.Account')"
                    iconSize="var(--front-size-icon)"
                />
            </div>
        </div>
    </header>
</template>

<style lang="css" src="./header.css" scoped></style>
