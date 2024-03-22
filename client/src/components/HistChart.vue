<template>
  <div id="histchart"></div>

</template>

<script>
export default {
  name: "HistChart",
  data(){
    return{
      timedata:[],
      qnumdata:[],
      enumdata:[],
      correctratedata:[]

    }
  },
  methods:{
    drawChart() {
      let myEchart = this.$echarts.init(document.getElementById("histchart"));
      let option = {
        tooltip: {
          trigger: 'axis',
          axisPointer: {
            type: 'cross',
            crossStyle: {
              color: '#999'
            }
          }
        },
        toolbox: {
          feature: {
            dataView: { show: true, readOnly: false },
            magicType: { show: true, type: ['line', 'bar'] },
            restore: { show: true },
            saveAsImage: { show: true }
          }
        },
        legend: {
          data: ['Evaporation', 'Precipitation', 'Temperature']
        },
        xAxis: [
          {
            type: 'category',
            data: this.timedata,
            axisLabel: {
              formatter: function (value) {
                // 将日期格式化为年月日
                return value.substring(0, 10);
              }
            },
            axisPointer: {
              type: 'shadow'
            }
          }
        ],
        yAxis: [
          {
            type: 'value',
            name: '题目数量',
            min: 0,
            max: 50,
            interval: 50,
            axisLabel: {
              formatter: '{value} 题'
            }
          },
          {
            type: 'value',
            name: '正确率',
            min: 0,
            max: 100,
            interval: 5,
            axisLabel: {
              formatter: '{value} %'
            }
          }
        ],
        series: [
          {
            name: '题目数量',
            type: 'bar',
            tooltip: {
              valueFormatter: function (value) {
                return value + ' 题';
              }
            },
            data: this.qnumdata
          },
          {
            name: '错题数量',
            type: 'bar',
            tooltip: {
              valueFormatter: function (value) {
                return value + ' 题';
              }
            },
            data: this.enumdata
          },
          {
            name: '正确率',
            type: 'line',
            yAxisIndex: 1,
            tooltip: {
              valueFormatter: function (value) {
                return value + ' %';
              }
            },
            data: this.correctratedata
          }
        ]
      };
      myEchart.setOption(option);
    }
  },
  mounted() {
    this.$http.query408DataInfo().then((res) => {
      if (res.code == 200) {
        console.log(res.data);
        const NewData = res.data;
        // 直接提取time字段并添加到timedata数组中
        const NewTimeitem = NewData.map((item) => item.time);
        console.log(NewTimeitem);
        this.timedata = [...this.timedata, ...NewTimeitem];
        console.log(this.timedata);

        //做题数量
        const Newqnumitem = NewData.map((item) => item.qnum);
        this.qnumdata = [...this.qnumdata,...Newqnumitem];

        //错题数量
        const Newenumitem = NewData.map((item) => item.errorNum);
        this.enumdata = [...this.enumdata,...Newenumitem];
        console.log(this.enumdata)

        //正确率
        const NewCorrectitem = NewData.map((item) => item.correctRate);
        this.correctratedata = [...this.correctratedata,...NewCorrectitem];



      }
      // 在获取并填充数据后调用drawChart方法
      this.drawChart();
    });
  },
}

</script>

<style scoped>
#histchart {
  width: 1000px;
  height: 400px;
}
</style>