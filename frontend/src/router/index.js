import { createWebHistory, createRouter } from "vue-router";
import CinemaHome from "@/views/CinemaHome.vue";
import Seating from "@/views/Seating.vue";
import RateMovie from "@/views/RateMovie.vue";

const routes = [
    {
        path: "/",
        name: "CinemaHome",
        component: CinemaHome,
    },
    {
        path: "/seating",
        name: "Seating",
        component: Seating,
    },
    {
        path: "/ratemovie",
        name: "RateMovie",
        component: RateMovie,
    },
    {
        path: '/seating/:seatingplanid/:people',
        name: 'Seating',
        component: Seating
    },
    {
        path: '/ratemovie/:movieid/:visitdate',
        name: 'RateMovie',
        component: RateMovie
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;