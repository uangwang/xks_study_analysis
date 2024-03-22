<template>
  <div>
    <div id="main"></div>
  </div>
</template>

<script>

export default {
  name: "Charts-view",
  methods:{
    drawChart() {
      let myEchart = this.$echarts.init(document.getElementById("main"));
      let option = {
        title: {
          text: 'ECharts 入门示例'
        },
        tooltip: {},
        xAxis: {
          data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
        },
        yAxis: {},
        series: [
          {
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
          }
        ]
      };
      myEchart.setOption(option);
    }
  },
  mounted() {
    this.drawChart();
  }

}



</script>


<style scoped>
#main {
  width: 600px;
  height:400px;
  margin: auto;
  margin-top: 100px
}
</style>