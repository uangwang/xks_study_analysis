import Vue from "vue";
import VueRouter from 'vue-router';
import Chart from '../views/Charts.vue';
import Login from "../views/Login.vue";


Vue.use(VueRouter);

const routes = [{
	path: '/chart',
	component: Chart
},{
	path: '/login',
	component: Login

}]

const router = new VueRouter({
	routes,
});

export default router;