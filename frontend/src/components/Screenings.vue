<script setup>
import {ref, onMounted, computed} from "vue";
import router from "@/router/index.js";

const screenings = ref([]);
const age = ref(0);
const genre = ref("all");
const language = ref("all");
const screeningTime = ref("");
const people = ref(1);
const recommend = ref(false);


onMounted(async() => {
  //const response = await fetch("http://localhost:8080/api/screenings");
  const response = await fetch("http://localhost:8080/api/screenings/recommended/1");
  screenings.value = await response.json();
})

const sortByScreeningTime = () => {
  screenings.value.sort((a, b) => {
    return new Date(a.screeningtime) - new Date(b.screeningtime);
  });
}
const sortByTitle = () => {
  screenings.value.sort((a, b) => {
    return a.movieid.title.localeCompare(b.movieid.title);
  });
}
const sortByRecommendationScore = () => {
  screenings.value.sort((a, b) => {
    return b.recommendationScore - a.recommendationScore;
  });
}
const formatDate = (date) => {
  return new Date(date).toLocaleString();
}

const filterScreenings = computed(() => {
  return screenings.value.filter((screening) => {
    if (age.value != 0 && screening.movieid.agerestriction > age.value) {
      return false;
    }
    if (genre.value != "all" && screening.movieid.genreid.genrename != genre.value) {
      return false;
    }
    if (language.value != "all" && screening.movieid.language != language.value) {
      return false;
    }
    if (screeningTime.value != "" && new Date(screening.screeningtime) < new Date(screeningTime.value)) {
      return false;
    }
    return true;
  })})

const chooseSeating = async (seatingplan) => {
  console.log(seatingplan.id + " " + people.value);
  router.push({
    name: 'Seating',
    params: {
      seatingplanid: seatingplan.id,
      people: people.value
    }
  })
}



</script>

<template>
  <div class="sort-by">
    <button @click="sortByScreeningTime()">Screening time</button>
    <button @click="sortByTitle()">Sort by title</button>
    <button @click="sortByRecommendationScore">Sort based on viewing history</button>
    <div class="filters">
    <form>
      <input v-model.number="age" placeholder="Age restriction" />
      <select v-model="genre">
        <option value="all">All</option>
        <option v-for="(screening, index) in screenings" :key="index" :value="screening.movieid.genreid.genrename">{{screening.movieid.genreid.genrename}}</option>
      </select>
      <select v-model="language">
        <option value="all">All</option>
        <option v-for="(screening, index) in screenings" :key="index" :value="screening.movieid.language">{{screening.movieid.language}}</option>
</select>
      <input v-model="screeningTime" type="datetime-local" placeholder="Screening time" />
      <input v-model.number="people" placeholder="People" />
    </form>

    </div>
  </div>
  <table>
    <tr>
      <td> Title </td>
      <td> Screening time </td>
      <td> Genre </td>
      <td> Language </td>
      <td> Runtime </td>
      <td> Age restriction </td>
    </tr>
  </table>
<li v-for="(screening, index) in filterScreenings" :key="index" class="screenings">
    <div class="screening">
      <table>
        <tr>
          <td> {{screening.movieid.title}} </td>
          <td> {{formatDate(screening.screeningtime)}} </td>
          <td> {{screening.movieid.genreid.genrename}}</td>
          <td> {{screening.movieid.language}}</td>
          <td> {{screening.movieid.runtime}}</td>
          <td> {{screening.movieid.agerestriction}}</td>
          <td> <button @click="chooseSeating(screening.seatingplanid)">Choose seating</button> </td>
          <td> <button @click="rateMovie">Rate Movie</button></td>
        </tr>
      </table>
  </div>
</li>


</template>

<style scoped>
.screenings {
  display: grid;
  border: gray;
}
.screening {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 1vh;
  padding: 1vh;
}
.screening p {
  padding: 1vh;
}
.screening td {
  border-right: 1px solid black;
  padding: 0.5em;
}
td {
  border-right: 1px solid black;
  padding: 0.5em;
}
table {
  border: 1px solid black;
  width: 100%;
  display: flex;
  justify-content: center;
}
</style>