<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>워드 클라우드</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<link rel="stylesheet" href="../css/dashboard.css">
<style>
#chartdiv {
  height: 600px;
}
</style>
</head>
<body>
<!-- navbar -->
<nav class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
  <a class="navbar-brand col-md-3 col-lg-2 mr-0 px-3" href="#">Searlution</a>
  <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-toggle="collapse" data-target="#sidebarMenu" aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <ul class="navbar-nav px-3">
      <li class="nav-item">
        <a class="nav-link" href="#">로그아웃</a>
      </li>
  </ul>
  <div class="form-check px-3">
	  <input class="form-check-input" type="checkbox" value="" id="advertisement">
	  <label class="form-check-label text-white" for="advertisement">No ad</label>
  </div>
  <input class="form-control form-control-dark w-60" type="text" placeholder="검색어를 입력하세요." aria-label="검색어를 입력하세요.">
  <ul class="navbar-nav px-3">
    <li class="nav-item text-nowrap">
      <a class="nav-link font-weight-bold" href="#">Search</a>
    </li>
  </ul>
</nav>

<div class="container-fluid">
  <div class="row">
    <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
      <div class="sidebar-sticky pt-3">
        <ul class="nav flex-column">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="hash"></span><span class="font-weight-bold">검색 결과 링크</span>
            </a>
          </li>
        </ul>

        <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
          <span class="font-weight-bold">시각화 탭</span>
          <a class="d-flex align-items-center text-muted" aria-label="Add a new report">
            <span data-feather="log-in"></span>
          </a>
        </h6>
        <ul class="nav flex-column mb-2">
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="bar-chart-2"></span><span class="font-weight-bold">그래프</span>
              <span class="sr-only"></span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="pie-chart"></span><span class="font-weight-bold">차트</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link">
              <span data-feather="cloud"></span><span class="text-primary font-weight-bold">워드 클라우드</span>
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">워드 클라우드</h1>
      </div>
      
      <div id="chartdiv"></div>

    </main>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>

<script src="https://cdn.amcharts.com/lib/4/core.js"></script>
<script src="https://cdn.amcharts.com/lib/4/charts.js"></script>
<script src="https://cdn.amcharts.com/lib/4/plugins/wordCloud.js"></script>
<script src="https://cdn.amcharts.com/lib/4/themes/animated.js"></script>

<script>
am4core.ready(function() {
	// Themes begin
	am4core.useTheme(am4themes_animated);
	// Themes end
	
	var chart = am4core.create("chartdiv", am4plugins_wordCloud.WordCloud);
	chart.fontFamily = "Courier New";
	var series = chart.series.push(new am4plugins_wordCloud.WordCloudSeries());
	series.randomness = 0.1;
	series.rotationThreshold = 0.5;
	
	series.data = [ {
	    "tag": "${wordCounts[0].word_name",
	    "count": "${wordCounts[0].word_count}"
	}, {
	    "tag": "${wordCounts[1].word_name",
	    "count": "${wordCounts[1].word_count}"
	}, {
	    "tag": "${wordCounts[2].word_name",
	    "count": "${wordCounts[2].word_count}"
	}, {
	    "tag": "${wordCounts[3].word_name",
	    "count": "${wordCounts[3].word_count}"
	}, {
	    "tag": "${wordCounts[4].word_name",
	    "count": "${wordCounts[4].word_count}"
	}, {
	    "tag": "${wordCounts[5].word_name",
	    "count": "${wordCounts[5].word_count}"
	}, {
	    "tag": "${wordCounts[6].word_name",
	    "count": "${wordCounts[6].word_count}"
	}, {
	    "tag": "${wordCounts[7].word_name",
	    "count": "${wordCounts[7].word_count}"
	}, {
	    "tag": "${wordCounts[8].word_name",
	    "count": "${wordCounts[8].word_count}"
	}, {
	    "tag": "${wordCounts[9].word_name",
	    "count": "${wordCounts[9].word_count}"
	}, {
	    "tag": "${wordCounts[10].word_name",
	    "count": "${wordCounts[10].word_count}"
	}, {
	    "tag": "${wordCounts[11].word_name",
	    "count": "${wordCounts[11].word_count}"
	}, {
	    "tag": "${wordCounts[12].word_name",
	    "count": "${wordCounts[12].word_count}"
	}, {
	    "tag": "${wordCounts[13].word_name",
	    "count": "${wordCounts[13].word_count}"
	}, {
	    "tag": "${wordCounts[14].word_name",
	    "count": "${wordCounts[14].word_count}"
	}, {
	    "tag": "${wordCounts[15].word_name",
	    "count": "${wordCounts[15].word_count}"
	}, {
	    "tag": "${wordCounts[16].word_name",
	    "count": "${wordCounts[16].word_count}"
	}, {
	    "tag": "${wordCounts[17].word_name",
	    "count": "${wordCounts[17].word_count}"
	}, {
	    "tag": "${wordCounts[18].word_name",
	    "count": "${wordCounts[18].word_count}"
	}, {
	    "tag": "${wordCounts[19].word_name",
	    "count": "${wordCounts[19].word_count}"
	}];
	
	series.dataFields.word = "tag";
	series.dataFields.value = "count";
	
	series.heatRules.push({
	 "target": series.labels.template,
	 "property": "fill",
	 "min": am4core.color("#0000ff"),
	 "max": am4core.color("#ff0066"),
	 "dataField": "value"
	});
	
	series.labels.template.url = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query={word}";
	series.labels.template.urlTarget = "_blank";
	series.labels.template.tooltipText = "{word}: {value}";
	
	var hoverState = series.labels.template.states.create("hover");
	hoverState.properties.fill = am4core.color("#FF0000");

	
	}); // end am4core.ready()
</script>
</body>
</html>