<template>
  <div id="main">

  </div>
</template>

<script>
export default {
  name: "rate-408",
  data(){
    return{
      timedata:[],
      chapterdata:[],
      qnumdata:[],
      enumdata:[],
      correctratedata:[]
    }
  },
  methods:{
    drawChart() {
      let myEchart = this.$echarts.init(document.getElementById("main"));
      let option = {
        title: {
          text: '数据结构学情分析'
        },
        tooltip: {
          trigger: 'axis'
        },
        legend: {
          data: ['章节', '问题数量', '错题数量', '正确率']
        },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true
        },
        toolbox: {
          feature: {
            saveAsImage: {}
          }
        },
        xAxis: {
          type: 'category',
          boundaryGap: false,
          data: this.timedata,
          axisLabel: {
            formatter: function (value) {
              // 将日期格式化为年月日
              return value.substring(0, 10);
            }
          }
        },
        yAxis: [
          {
            type: 'value',
            position: 'left',  // 左侧 y 轴
            min:0,
            max:150
          },
          {
            type: 'category',
            position: 'right',  // 右侧 y 轴
            data: this.chapterdata,  // 设置章节为纵坐标的刻度
            axisLabel: {
              interval: 0,  // 强制显示所有标签
              rotate: 0,  // 不旋转标签
              formatter: function (value) {
                return `{a|${value}}\n\n`;  // 使用换行符和额外的间距
              },
              rich: {
                a: {
                  lineHeight: 30,  // 设置行高
                  padding: [0, 0, 20, 0]  // 设置上下间距
                }
              }
            }
          }
        ],
        series: [
          {
            name: '章节',
            type: 'line',
            stack: 'Total',
            data: this.chapterdata,
            yAxisIndex: 1  // 指定使用第二个 y 轴（索引从 0 开始）
          },
          {
            name: '问题数量',
            type: 'line',
            stack: 'Total',
            data: this.qnumdata
          },
          {
            name: '错题数量',
            type: 'line',
            stack: 'Total',
            data: this.enumdata
          },
          {
            name: '正确率',
            type: 'line',
            stack: 'Total',
            data:this.correctratedata
          },

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
        const NewTimeitem = NewData.map((item) => item.time).sort();
        console.log(NewTimeitem);
        this.timedata = [...this.timedata, ...NewTimeitem];
        console.log(this.timedata);

        //章节
        const NewChapteritem = NewData.map((item) => item.chapter).reverse();
        this.chapterdata = [...this.chapterdata,...NewChapteritem];

        //做题数量
        const Newqnumitem = NewData.map((item) => item.qnum).reverse();
        this.qnumdata = [...this.qnumdata,...Newqnumitem];

        //错题数量
        const Newenumitem = NewData.map((item) => item.errorNum).reverse();
        this.enumdata = [...this.enumdata,...Newenumitem];
        console.log(this.enumdata)

        //正确率
        const NewCorrectitem = NewData.map((item) => item.correctRate).reverse();
        this.correctratedata = [...this.correctratedata,...NewCorrectitem];





      }
      // 在获取并填充数据后调用drawChart方法
      this.drawChart();
    });
  },

}
</script>

<style scoped>
#main {
  width: 100%;
  height:800px;
  margin: auto;
  /*margin-top: 100px*/
}
</style>