<script setup>
import { ref, onMounted} from "vue";

const seatingPlan = ref([]);

const props = defineProps({
  seatingplanid: Number,
  people: Number
})

onMounted(async()  => {
  const response = await fetch(`http://localhost:8080/api/seatingplan/${props.seatingplanid}/${props.people}`);
  seatingPlan.value = await response.json();
})
const isOccupied = (seat) => {
  switch (seat) {
    case 0:
      return 'free';
    case 1:
      return 'occupied';
    case 2:
      return 'selected';
    default:
      return 'unknown';
  }
}

const reloadSeating = (seat, i, j) => {
  if (seat != 0 && seat != 2) return;
  if (seat == 2) {
    seatingPlan.value[i][j] = 0;
  } else {
    seatingPlan.value[i][j] = 2;
  }
}
</script>

<template>
  <div class="seatingplan">
    <div class="screen">
      <h1>Screen</h1>
    </div>
<div v-for="(row, i) in seatingPlan" :key="i" class="rows">
  <div v-for="(seat, j) in row" :key="j" class="seats">
    <div :class="isOccupied(seat)" @click="reloadSeating(seat, i, j)" >
    </div>
  </div>
</div>
</div>
</template>

<style scoped>

.rows {
  display: grid;
  grid-template-columns: repeat(30, 0fr);
}
.seats {
  display: flex;
  justify-content: center;
  align-items: center;
  border: 0.1vh solid black;
}

.free {
  background-color: green;
  width: 2vh;
  height: 2vh;
}

.occupied {
  background-color: red;
  width: 2vh;
  height: 2vh;
}

.selected {
  background-color: yellow;
  width: 2vh;
  height: 2vh;
}
.unknown {
  background-color: black;
  width: 2vh;
  height: 2vh;
}

</style>