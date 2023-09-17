<template>
  <div class="chart-container">
    <table class="table">
      <!-- 表头 -->
      <thead>
      <tr>
        <th>edge设备个数</th>
        <th>同时加工工序个数</th>
        <th>edge的加工利用率</th>
      </tr>
      </thead>
      <!-- 表格内容 -->
      <tbody>
      <tr v-for="(item, index) in tableData" :key="index">
        <td>{{ item.date }}</td>
        <td>{{ item.sales }}</td>
        <td>{{ item.profit }}</td>
      </tr>
      </tbody>
    </table>
    <div class="chart-row">
      <!-- 柱状图1 -->
      <div class="chart-column">
        <div class="chart1"></div>
      </div>
      <!-- 柱状图2 -->
      <div class="chart-column">
        <div class="chart2"></div>
      </div>
    </div>
    <div class="chart-row">
      <!-- 折线图1 -->
      <div class="chart-column">
        <div class="chart3"></div>
      </div>
      <!-- 折线图2 -->
      <div class="chart-column">
        <div class="chart4"></div>
      </div>
    </div>


  </div>
</template>

<script>
import echarts from "echarts";

export default {
  name: "edge_5",
  data() {
    return {
      // 表格数据
      tableData: [
        { date: "edge-1", sales: 1, profit: 0 },
        { date: "edge-2", sales: 1, profit: 0 },
        { date: "edge-3", sales: 1, profit: 0 },
        { date: "edge-4", sales: 1, profit: 0 },
        { date: "edge-5", sales: 1, profit: 0 },
        { date: "edge-6", sales: 1, profit: 0 },

      ]
    };
  },
  mounted() {
    // 柱状图1
    this.drawChart1();
    // 柱状图2
    this.drawChart2();
    // 折线图1
    this.drawChart3();
    // 折线图2
    this.drawChart4();
    this.get_data();
  },
  methods: {
    get_data(){
      this.$axios.get("/api/getAllWorkCenterData").then(res=>{

        if (res.status==200){
          console.log("res:",res.data.data)
          const result = res.data.data.reduce((acc, cur) => {
            const index = cur.workCenterIndex;
            if (!acc[index]) {
              acc[index] = { workCenterIndex: index, processingTime: 0 };
            }
            acc[index].processingTime += cur.processingTime;
            return acc;
          }, []);
          const maxEndTime = Math.max(...res.data.data.map(item => item.endTime));
          console.log("maxEndTime",maxEndTime);

          console.log("result:",result)
          const finalResult = result.map(obj => obj.processingTime);
          console.log("finalResult:",finalResult)
          console.log("data--:",this.tableData[0]["profit"])
          this.tableData[0]["profit"] = finalResult[0]/Math.max(...finalResult);
          this.tableData[1]["profit"] = finalResult[1]/Math.max(...finalResult);
          this.tableData[2]["profit"] = finalResult[2]/Math.max(...finalResult);
          this.tableData[3]["profit"] = finalResult[3]/Math.max(...finalResult);
          this.tableData[4]["profit"] = finalResult[4]/Math.max(...finalResult);
          this.tableData[5]["profit"] = finalResult[5]/Math.max(...finalResult);
          // 柱状图1
          this.drawChart1([this.tableData[0]["profit"], this.tableData[1]["profit"], this.tableData[2]["profit"], this.tableData[3]["profit"], this.tableData[4]["profit"],this.tableData[5]["profit"]]);
        }

      })
    },



    // 柱状图1
    drawChart1(aaa) {
      const chart1 = echarts.init(document.querySelector(".chart1"));
      const option1 = {
        // 标题
        title: {
          text: 'edge设备资源利用率'
        },
        // 图例
        legend: {
          data: ['利用率']
        },
        // X 轴数据
        xAxis: {
          type: 'category',
          data: ['edge_1', 'edge_2', 'edge_3', 'edge_4', 'edge_5','edge_6'],
          color:"#100e0e"
        },
        // Y 轴数据
        yAxis: {
          type: 'value',
          color:"#100e0e"
        },
        // 系列数据
        series: [{
          name: '利用率',
          type: 'bar',
          data: aaa,
          //柱状粗细
          barWidth:25,
          itemStyle: {
            normal: {
              color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                offset: 0,
                color: "#1268f3" // 0% 处的颜色
              }, {
                offset: 0.6,
                color: "#08a4fa" // 60% 处的颜色
              }, {
                offset: 1,
                color: "#01ccfe" // 100% 处的颜色
              }], false)
            }
          },

        }],
        // color:{
        //   color:green
        // }
      }
      chart1.setOption(option1);
    },


    // 柱状图2
    drawChart2() {
      const chart2 = echarts.init(document.querySelector(".chart2"));
      const option2 = {
        // 标题
        title: {
          text: '云边传输速率（kb/s）'
        },
        // 图例
        legend: {
          data: ['速率']

        },
        // X 轴数据
        xAxis: {
          type: 'category',
          data: ['edge_1', 'edge_2', 'edge_3', 'edge_4', 'edge_5', 'edge_6'],
          color: "#100e0e"
        },
        // Y 轴数据
        yAxis: {
          type: 'value',
          color: "#100e0e"
        },
        // 系列数据
        series: [{
          name: '速率',
          type: 'bar',
          data: [812, 546, 784, 664, 953, 482],
          //柱状粗细
          barWidth: 25,
          itemStyle: {
            normal: {
              color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [{
                offset: 0,
                color: "#1268f3" // 0% 处的颜色
              }, {
                offset: 0.6,
                color: "#08a4fa" // 60% 处的颜色
              }, {
                offset: 1,
                color: "#01ccfe" // 100% 处的颜色
              }], false)
            }
          },
        }],
      }
      chart2.setOption(option2);
    },

    // 折线图1
    drawChart3() {
      const chart3 = echarts.init(document.querySelector(".chart3"));
      const option3 = {
        // 标题
        title: {
          text: "销售额变化率趋势图",
          textStyle: {
            fontWeight: "bold",
            fontSize: 16,
          },
          left: "center",
          padding: [20, 0],
        },
        // X 轴数据
        xAxis: {
          type: "category",
          data: [
            "2021-01-01",
            "2021-01-02",
            "2021-01-03",
            "2021-01-04",
            "2021-01-05",
          ],
          axisLabel: {
            color: "#100e0e",
            fontSize: 12,
          },
          axisLine: {
            lineStyle: {
              color: "#cccccc",
            },
          },
        },
        // Y 轴数据
        yAxis: {
          type: "value",
          axisLabel: {
            color: "#100e0e",
            fontSize: 12,
          },
          axisLine: {
            lineStyle: {
              color: "#cccccc",
            },
          },
        },
        // 系列数据
        series: [
          {
            name: "销售额变化率",
            type: "line",
            data: [0.2, 0.25, -0.2, 0.33, 0.15],
            itemStyle: {
              color: "#1268f3",
            },
            lineStyle: {
              width: 3,
            },
          },
        ],
      };
      chart3.setOption(option3);
    },

// 折线图2
    drawChart4() {
      const chart4 = echarts.init(document.querySelector(".chart4"));
      const option4 = {
        // 标题
        title: {
          text: "利润变化率趋势图",
          textStyle: {
            fontWeight: "bold",
            fontSize: 16,
          },
          left: "center",
          padding: [20, 0],
        },
        // X 轴数据
        xAxis: {
          type: "category",
          data: [
            "2021-01-01",
            "2021-01-02",
            "2021-01-03",
            "2021-01-04",
            "2021-01-05",
          ],
          axisLabel: {
            color: "#100e0e",
            fontSize: 12,
          },
          axisLine: {
            lineStyle: {
              color: "#cccccc",
            },
          },
        },
        // Y 轴数据
        yAxis: {
          type: "value",
          axisLabel: {
            color: "#100e0e",
            fontSize: 12,
          },
          axisLine: {
            lineStyle: {
              color: "#cccccc",
            },
          },
        },
        // 系列数据
        series: [
          {
            name: "利润变化率",
            type: "line",
            data: [0.1, 0.15, -0.15, 0.25, 0.08],
            itemStyle: {
              color: "#AA00FF",
            },
            lineStyle: {
              width: 3,
            },
          },
        ],
      };
      chart4.setOption(option4);
    },
  },
};
</script>

<style scoped>
.chart-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 20px;
}

.table {
  margin-bottom: 30px;
  border-collapse: collapse;
  width: 100%;
  max-width: 1200px;
  background-color: #fff;
}

.table th,
.table td {
  padding: 8px 16px;
  text-align: center;
}

.table th {
  background-color: #007aff;
  color: white;
}

.table tr:nth-child(even) {
  background-color: #f2f2f2;
}

.chart-row {
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
  gap: 20px;
  width: 100%;
  max-width: 1000px;
  /*background-color: #007aff;*/

}

.chart-column {
  flex-basis: calc(50% - 10px);
  min-width: 450px;
  border-radius: 4px;
  background-color: rgba(238, 229, 229, 0.55);
  backdrop-filter: blur(10px);
  -webkit-backdrop-filter: blur(5px);
  margin-top: 10px;
}

.chart1,
.chart2,
.chart3,
.chart4 {
  height: 300px;

}
</style>


