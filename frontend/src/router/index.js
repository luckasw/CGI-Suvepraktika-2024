import { createWebHistory, createRouter } from "vue-router";
import CinemaHome from "@/views/CinemaHome.vue";
import Seating from "@/views/Seating.vue";

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
        path: '/seating/:seatingplanid/:people',
        name: 'Seating',
        component: Seating
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;