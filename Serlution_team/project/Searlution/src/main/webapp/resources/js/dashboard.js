/* globals Chart:false, feather:false */

(function () {
  'use strict'

  feather.replace()

  // Graphs
  var ctx = document.getElementById('myChart')
  // eslint-disable-next-line no-unused-vars
  var myChart = new Chart(ctx, {
    type: 'line',
    data: {
      labels: [
        '7-01', '7-02', '7-03', '7-04', '7-05', '7-06', '7-07', '7-08', '7-09', '7-10', '7-11', '7-12'
        , '7-13', '7-14', '7-15', '7-16', '7-17', '7-18', '7-19', '7-20', '7-21', '7-22', '7-23', '7-24'
        , '7-25', '7-26', '7-27', '7-28', '7-29', '7-30'
      ],
      datasets: [{
        data: [
          15339, 21345, 18483, 24003, 23489, 24092, 21563, 18456, 19846, 13654, 13021, 12034, 20487, 19486
          , 23864, 22168, 17654, 16984, 19015, 17625, 23984, 15975, 11054, 13452, 12045, 11972, 16789, 18456
          , 17068, 14308
        ],
        lineTension: 0,
        backgroundColor: 'transparent',
        borderColor: '#007bff',
        borderWidth: 4,
        pointBackgroundColor: '#007bff'
      }]
    },
    options: {
      scales: {
        yAxes: [{
          ticks: {
            beginAtZero: false
          }
        }]
      },
      legend: {
        display: false
      }
    }
  })
}())
