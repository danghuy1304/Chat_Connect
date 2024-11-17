<script lang="js" setup></script>

<template>
    <div class="create-poster__container">
        <div class="create-poster--input">
            <div class="avatar">
                <router-link class="avatar__link" :to="{ name: 'Home' }">
                    <img src="" alt="" />
                </router-link>
            </div>
            <div class="input-box">
                <span class="input__placeholder">
                    {{ $t("Page.Home.CreatePoster.InputPlaceholder") }}
                </span>
            </div>
        </div>
        <div class="line"></div>
        <div class="create-poster--option">
            <div class="option--item">
                <b-button
                    class="item--btn live-stream"
                    :icon="['fas', 'tower-broadcast']"
                    iconColor="var(--color-red)"
                >
                    {{ $t("Button.Title.LiveStream") }}
                </b-button>
            </div>
            <div class="option--item">
                <b-button
                    class="item--btn photo"
                    :icon="['fas', 'photo-film']"
                    iconColor="var(--color-green)"
                >
                    {{ $t("Button.Title.PhotoOrVideo") }}
                </b-button>
            </div>
            <div class="option--item">
                <b-button
                    class="item--btn feeling"
                    :icon="['far', 'face-laugh']"
                    iconColor="var(--color-yellow)"
                >
                    {{ $t("Button.Title.FeelingOrActivity") }}
                </b-button>
            </div>
        </div>
    </div>
</template>

<style lang="css" src="./create-poster.css" scoped></style>
