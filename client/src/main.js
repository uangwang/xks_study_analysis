import Vue from 'vue'
import App from './App.vue'
import router from './router';
import * as echarts from 'echarts';
import 'echarts-gl';
Vue.prototype.$echarts = echarts

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
    router,
}).$mount('#app')
