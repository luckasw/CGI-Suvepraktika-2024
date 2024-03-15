<script setup>
import { ref, onMounted} from "vue";

const screenings = ref([]);

onMounted(async() => {
  //const response = await fetch("http://localhost:8080/api/screenings");
  const response = await fetch("http://localhost:8080/api/screenings/recommended/1");
  screenings.value = await response.json();
})
</script>

<template>
<div v-for="(screening, index) in screenings" :key="index">
  <h2> {{screening.movieid.title}} </h2>
  <p> {{screening.screeningTime}} </p>
</div>
</template>

<style scoped>

</style>