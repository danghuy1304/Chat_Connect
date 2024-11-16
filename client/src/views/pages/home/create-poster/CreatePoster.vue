<script lang="js" setup>

const handleEnter = () => {
    alert('Enter')
}
</script>

<template>
    <div class="create-poster__container">
        <div class="create-poster--input">
            <div class="avatar"></div>
            <div class="input-box">
                <b-input countChar max="100" @enter="handleEnter"></b-input>
            </div>
        </div>
        <div class="create-poster--option"></div>
    </div>
</template>

<style lang="css" scoped>
.create-poster__container {
    width: 50%;
}
</style>
