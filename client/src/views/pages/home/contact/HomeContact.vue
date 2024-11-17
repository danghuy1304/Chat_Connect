<script lang="js" setup></script>

<template>
    <div class="contact--container">
        <div class="contact--header">
            <div class="contact--header__title">
                <span>{{ $t("Page.Home.Contact.Title") }}</span>
            </div>
            <div class="contact--header__option">
                <div class="option--item option--search">
                    <b-button
                        class="option__btn"
                        :icon="['fas', 'magnifying-glass']"
                    >
                    </b-button>
                </div>
                <div class="option--item option--setting">
                    <b-button class="option__btn" :icon="['fas', 'ellipsis']">
                    </b-button>
                </div>
            </div>
        </div>
        <div class="contact--content">
            <ul>
                <li v-for="item in 15" :key="item" tabindex="0">
                    <div class="contact--content__avatar">
                        <img src="" alt="" />
                    </div>
                    <div class="contact--content__name">
                        <span>Đặng Đình Huy</span>
                    </div>
                </li>
            </ul>
        </div>
        <div class="line"></div>
        <div class="contact--footer">
            <b-button class="group-chat__btn" :icon="['fas', 'plus']">
                {{ $t("Button.Title.CreateGroupChat") }}
            </b-button>
        </div>
    </div>
</template>

<style lang="css" src="./contact.css" scoped></style>
