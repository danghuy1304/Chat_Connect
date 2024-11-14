<script lang="js" setup>

</script>

<template>
    <div class="create-poster__container">
        <div class="create-poster--input">
            <div class="avatar">

            </div>
            <div class="input-box">
                <b-input type="password" showPassword :errors="['lỗi']" countChar max="100"></b-input>
            </div>
        </div>
        <div class="create-poster--option">

        </div>
    </div>
</template>

<style lang="css" scoped>
.create-poster__container {
    width: 50%;
}
</style>
