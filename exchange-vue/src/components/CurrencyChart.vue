<template>
  <Bar
  v-if="chartData"
    id="my-chart-id"
    :options="chartOptions"
    :data="chartData"
  />
</template>

<script>
import axios from 'axios'
import { Bar } from 'vue-chartjs'
import { Chart as ChartJS, Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale } from 'chart.js'

ChartJS.register(Title, Tooltip, Legend, BarElement, CategoryScale, LinearScale)


export default {
  name: 'BarChart',
  components: { Bar },
  data() {
    return {
      chartData: null,
      chartOptions: null
    }
  },
  async created() {
    try {
      const response = await axios.get('http://localhost:8080/api/currency/rates')
      const results = response.data.results.HUF
      const labels = Object.keys(results)
      const values = Object.values(results)

      this.chartData = {
        labels: labels,
        datasets: [
          {
            label: 'CZK to HUF',
            data: values,
            backgroundColor: 'rgba(75, 192, 192, 0.2)',
            borderColor: 'rgba(75, 192, 192, 1)',
            borderWidth: 1
          }
        ]
      }

      this.chartOptions = {
        scales: {
          y: {
            min: Math.min(...values) - 0.05,
            max: Math.max(...values) + 0.05
          }
        }
      }
    } catch (error) {
      console.error(error)
    }
  }
}
</script>
