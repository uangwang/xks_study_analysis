import Vue from "vue";
import VueRouter from 'vue-router';
import Chart from '../views/Charts.vue';
import Login from "../views/Login.vue";
import Rate408 from "../views/rate408.vue";
import HistChart from "../components/HistChart.vue";
import PieChart from "../components/PieChart.vue";


Vue.use(VueRouter);

const routes = [{
	path: '/chart',
	component: Chart
},{
	path: '/login',
	component: Login
},{
	path: '/rate408',
	component: Rate408
},{
	path: '/histchart',
	component: HistChart
},{
	path:'/piechart',
	component:PieChart
}
]

const router = new VueRouter({
	routes,
});

export default router;