<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<title>검색어 검색량</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.1/css/bootstrap.min.css" integrity="sha384-VCmXjywReHh4PwowAiWNagnWcLhlEJLA5buUprzK8rxFgeH0kww/aWY76TfkUoSX" crossorigin="anonymous">
<link rel="stylesheet" href="/searlution/resources/css/dashboard.css">

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
            <a class="nav-link">
              <span data-feather="bar-chart-2"></span><span class="text-primary font-weight-bold">그래프</span>
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="pie-chart"></span><span class="font-weight-bold">차트</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">
              <span data-feather="cloud"></span><span class="font-weight-bold">워드 클라우드</span>
            </a>
          </li>
        </ul>
      </div>
    </nav>

    <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-md-4">
      <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
        <h1 class="h2">검색어 검색량</h1>
        <div class="btn-toolbar mb-2 mb-md-0">
          <div class="btn-group mr-2">
            <button type="button" class="btn btn-sm btn-outline-secondary">
            <span data-feather="share-2"></span>Share</button>
            <button type="button" class="btn btn-sm btn-outline-secondary">
            <span data-feather="share"></span>Export</button>
          </div>
          <a class="btn btn-secondary" data-toggle="modal" href="#dateModal">검색 옵션</a>
        </div>
      </div>
	
	<div class="modal fade" id="dateModal" tabindex="-1" role="dialog" aria-labelledby="modal" aria-hidden="true">
	  	<div class="modal-dialog">
	  		<div class="modal-content">
	  			<div class="modal-header">
	  				<h5 class="modal-title" id="modal">검색 옵션</h5>
	  				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
	  					<span aria-hidden="true"><span data-feather="x"></span></span>
	  				</button>
	  			</div>
	  			<div class="modal-body">
	  				<form>
	  					<div class="form-group">
  							<label>기간</label>
  							<span class="form-control">
	  							<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="dateRadio" id="dateRadio1" value="oneMonth">
								  <label class="form-check-label" for="dateRadio1">1개월</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="dateRadio" id="dateRadio2" value="threeMonth">
								  <label class="form-check-label" for="dateRadio2">3개월</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="radio" name="dateRadio" id="dateRadio3" value="oneYear">
								  <label class="form-check-label" for="dateRadio3">1년</label>
								</div>
  							</span>
  						</div>
  						<div class="form-group">
  							<label>범위</label>
  							<span class="form-control">
  								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="rangeCheckbox" id="rangeCheckbox0">
								  <label class="form-check-label" for="rangeCheckbox0">전체</label>
								</div>
	  							<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="rangeCheckbox" id="rangeCheckbox1" value="mo">
								  <label class="form-check-label" for="rangeCheckbox1">모바일</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="rangeCheckbox" id="rangeCheckbox2" value="pc">
								  <label class="form-check-label" for="rangeCheckbox2">PC</label>
								</div>
  							</span>
  						</div>
  						<div class="form-group">
  							<label>성별</label>
  							<span class="form-control">
  								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="genderCheckbox" id="genderCheckbox0">
								  <label class="form-check-label" for="genderCheckbox0">전체</label>
								</div>
	  							<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="genderCheckbox" id="genderCheckbox1" value="f">
								  <label class="form-check-label" for="genderCheckbox1">여성</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="genderCheckbox" id="genderCheckbox2" value="m">
								  <label class="form-check-label" for="genderCheckbox2">남성</label>
								</div>
  							</span>
  						</div>
  						<div class="form-group">
  							<label>연령</label>
  							<span class="form-control">
  								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox0">
								  <label class="form-check-label" for="ageCheckbox0">전체</label>
								</div>
	  							<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox1" value="1">
								  <label class="form-check-label" for="ageCheckbox1">0-12세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox2" value="2">
								  <label class="form-check-label" for="ageCheckbox2">13-18세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox3" value="3">
								  <label class="form-check-label" for="ageCheckbox3">19-24세</label>
								</div>
							</span>
							<span class="form-control">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox4" value="4">
								  <label class="form-check-label" for="ageCheckbox4">25-29세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox5" value="5">
								  <label class="form-check-label" for="ageCheckbox5">30-34세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox6" value="6">
								  <label class="form-check-label" for="ageCheckbox6">35-39세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox7" value="7">
								  <label class="form-check-label" for="ageCheckbox7">40-44세</label>
								</div>
							</span>
							<span class="form-control">
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox8" value="8">
								  <label class="form-check-label" for="ageCheckbox8">45-49세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox9" value="9">
								  <label class="form-check-label" for="ageCheckbox9">50-54세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox10" value="10">
								  <label class="form-check-label" for="ageCheckbox10">55-60세</label>
								</div>
								<div class="form-check form-check-inline">
								  <input class="form-check-input" type="checkbox" name="ageCheckbox" id="ageCheckbox11" value="11">
								  <label class="form-check-label" for="ageCheckbox11">60세이상</label>
								</div>
  							</span>
  						</div>
	  				</form>
	  			</div>
	  			<div class="modal-footer">
	  				<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
	  				<button type="button" class="btn btn-info" onclick="doGraph()" data-dismiss="modal">적용하기</button>
	  			</div>
	  		</div>
	  	</div>
	  </div>
	
      <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>

    </main>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/feather-icons/4.9.0/feather.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.7.3/Chart.min.js"></script>

<script>
function goGraph()
{
	var tmpString = "chart/graph?keyword=${keyword}";
	
	var check_date = document.getElementsByName("dateRadio").length;
	var check_range = document.getElementsByName("rangeCheckbox").length;
	var check_gender = document.getElementsByName("genderCheckbox").length;
	var check_age = document.getElementsByName("ageCheckbox").length;
	
	var bool_date = null;
	var bool_range = null;
	var bool_gender = null;
	var bool_age = null;
	
	for(var i=0; i<check_date; i++) {
		if(document.getElementsByName("dateRadio")[i].checked == true) {
			bool_date = true;
		}
	}
	for(var i=0; i<check_range; i++) {
		if(document.getElementsByName("rangeCheckbox")[i].checked == true) {
			bool_range = true;
		}
	}
	for(var i=0; i<check_gender; i++) {
		if(document.getElementsByName("genderCheckbox")[i].checked == true) {
			bool_gender = true;
		}
	}
	for(var i=0; i<check_age; i++) {
		if(document.getElementsByName("ageCheckbox")[i].checked == true) {
			bool_age = true;
		}
	}
	
	if(bool_date != null) {
		for(var i=0; i<check_date; i++) {
			if(document.getElementsByName("dateRadio")[i].checked == true) {
				tmpString = tmpString + "&date=" + document.getElementsByName("dateRadio")[i].value;
			}
		}
	}
	if(bool_range != null) {
		for(var i=1; i<check_range; i++) {
			if(document.getElementsByName("rangeCheckbox")[i].checked == true) {
				tmpString = tmpString + "&range=" + document.getElementsByName("rangeCheckbox")[i].value;
			}
		}
	}
	if(bool_gender != null) {
		for(var i=1; i<check_gender; i++) {
			if(document.getElementsByName("genderCheckbox")[i].checked == true) {
				tmpString = tmpString + "&gender=" + document.getElementsByName("genderCheckbox")[i].value;
			}
		}
	}
	if(bool_age != null) {
		for(var i=1; i<check_age; i++) {
			if(document.getElementsByName("ageCheckbox")[i].checked == true) {
				tmpString = tmpString + "&age=" + document.getElementsByName("ageCheckbox")[i].value;
			}
		}
	}
	if(bool_date == null||bool_range == null||bool_gender == null||bool_age==null) {
		alert("모든 항목을 입력해 주세요.");
	}
	else{
		location.href = tmpString;
	}
}
</script>

<script>
/*전체 선택 함수*/
	$('#rangeCheckbox0').click(function () {
		if($("input:checkbox[id='rangeCheckbox0']").prop("checked")){
			$("input[type=checkbox][name='rangeCheckbox']").prop("checked", true);
		} else {
			$("input[type=checkbox][name='rangeCheckbox']").prop("checked", false);
		}
	});
</script>

<script>
	$('#genderCheckbox0').click(function () {
		if($("input:checkbox[id='genderCheckbox0']").prop("checked")){
			$("input[type=checkbox][name='genderCheckbox']").prop("checked", true);
		} else {
			$("input[type=checkbox][name='genderCheckbox']").prop("checked", false);
		}
	});
</script>

<script>
	$('#ageCheckbox0').click(function () {
		if($("input:checkbox[id='ageCheckbox0']").prop("checked")){
			$("input[type=checkbox][name='ageCheckbox']").prop("checked", true);
		} else {
			$("input[type=checkbox][name='ageCheckbox']").prop("checked", false);
		}
	});
</script>


<script>
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
      labels: ${label},
      datasets: [{
        data: ${data},
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

</script>

</body>
</html>