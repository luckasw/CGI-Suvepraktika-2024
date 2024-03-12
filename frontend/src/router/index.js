import { createWebHistory, createRouter } from "vue-router";
import CinemaHome from "@/views/CinemaHome.vue";

const routes = [
    {
        path: "/",
        name: "CinemaHome",
        component: CinemaHome,
    }
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;