<script setup>
import RateMovie from "@/components/RateMovie.vue";
import {useRoute} from "vue-router";

const route = useRoute();
const movieid = Number(route.params.movieid);
const visitdate = route.params.visitdate;
</script>

<template>
<rate-movie :movieid="movieid" :visitdate="visitdate"/>
</template>

<style scoped>

</style>