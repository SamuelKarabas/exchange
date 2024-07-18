<template>
    <div id="app">
      <b-container>
        <currency-chart></currency-chart>
      </b-container>
    </div>
  </template>
  
  <script>
  import CurrencyChart from './components/CurrencyChart.vue'
  
  export default {
    name: 'App',
    components: {
      CurrencyChart
    }
  }
  </script>
  
  <style>
  @import 'bootstrap/dist/css/bootstrap.css';
  @import 'bootstrap-vue/dist/bootstrap-vue.css';
  
  #app {
    margin-top: 40px;
  }
  </style>
  