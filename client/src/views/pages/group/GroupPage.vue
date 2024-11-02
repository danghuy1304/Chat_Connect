<script lang="js" setup>
import { useI18n } from 'vue-i18n'
const { t } = useI18n()
</script>

<template>
    <h1>{{ t('RouterTitle.Group', { pipe: '|' }) }}</h1>
</template>

<style lang="css" scoped></style>
