<script setup>
import SeatingPlan from "@/components/SeatingPlan.vue";
import {useRoute} from "vue-router";

const route = useRoute();
const seatingplanid = Number(route.params.seatingplanid);
const people = Number(route.params.people)
</script>

<template>
<SeatingPlan :seatingplanid="seatingplanid" :people="people"/>
</template>

<style scoped>

</style>