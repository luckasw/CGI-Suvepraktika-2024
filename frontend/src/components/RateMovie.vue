<script setup>
import { ref, onMounted} from "vue";

const rating = ref(null);
const props = defineProps({
  movieid: Number,
  visitdate: String
})

const rateMovie = async() => {
  const usermovie = {
    userid: 1,
    movieid: props.movieid,
    rating: rating.value,
    visitdate: props.visitdate
  }
  const response = await fetch("http://localhost:8080/api/usermovies", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(usermovie)
  });
}

</script>

<template>
<input type="number" v-model="rating" min="1" max="5" placeholder="Rate the movie" />
<button @click="rateMovie">Rate</button>
</template>

<style scoped>

</style>