import Vue from 'vue'
import App from './App.vue'
import router from './router';
import * as echarts from 'echarts';
import 'echarts-gl';
import http from './api/http.js'
Vue.prototype.$echarts = echarts

Vue.config.productionTip = false
// 将http.js文件给存放到VUE的prototye中取了个别名叫http
Vue.prototype.$http = http;

new Vue({
  render: h => h(App),
    router,
}).$mount('#app')
