import { createRouter, createWebHistory } from "vue-router"

import HomeView from "../views/HomeView.vue"
import ClientsView from "../views/ClientsView.vue"
import OrdersView from "../views/OrdersView.vue"

const routes = [
  { path: "/", component: HomeView },
  { path: "/clients", component: ClientsView },
  { path: "/orders", component: OrdersView }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router