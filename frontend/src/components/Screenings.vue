<script setup>
import {ref, onMounted, computed} from "vue";

const screenings = ref([]);
const age = ref(0);
const genre = ref("all");
const language = ref("all");
const screeningTime = ref("");


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
</script>

<template>
  <div class="sort-by">
    <button @click="sortByScreeningTime()">Screening time</button>
    <button @click="sortByTitle()">Sort by title</button>
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
    </form>

    </div>
  </div>
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
  border: 0.1vh solid black;
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
</style>