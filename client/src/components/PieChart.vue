<template>
  <div id="piechart"></div>
</template>

<script>
export default {
  name: "PieChart",
  data() {
    return {
      chapter: []
    }
  },
  methods: {
    drawChart() {
      let myEchart = this.$echarts.init(document.getElementById("piechart"));
      let option = {
        title: {
          text: '章节统计',
          subtext: '看每个章节有多少篇题',
          left: 'center'
        },
        tooltip: {
          trigger: 'item'
        },
        legend: {
          orient: 'vertical',
          left: 'left'
        },
        series: [
          {
            name: 'Access From',
            type: 'pie',
            radius: '50%',
            data: this.chapter,
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: 'rgba(0, 0, 0, 0.5)'
              }
            }
          }
        ]
      };
      myEchart.setOption(option);
    }
  },
  mounted() {

    console.log("PieChart mounted");
    this.$http.query408DataInfo().then((res) => {
      if (res.code == 200) {
        const NewData = res.data;

        //章节
        const NewChapteritem = NewData.map((item) => item.chapter);

        let chapterCounts = {};

        NewChapteritem.forEach(chapter => {
          let majorChapter = chapter.split('.')[0];
          if (chapterCounts[majorChapter]) {
            chapterCounts[majorChapter]++;
          } else {
            chapterCounts[majorChapter] = 1;
          }
        });
        console.log(chapterCounts);
        // 转换数据格式
        this.chapter = Object.keys(chapterCounts).map(key => ({
          name: `章节 ${key}`,
          value: chapterCounts[key]
        }));
        console.log(this.chapter);
        this.drawChart();


      }
    })

  }
}
</script>

<style scoped>
#piechart {
  width: 1000px;
  height: 400px;
}

</style>