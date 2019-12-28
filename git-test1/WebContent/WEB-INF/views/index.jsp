<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- chart.js -->
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<style>
	<!--ul 가운데 정렬 -->
	ul.a {
		display: table;
        margin-left: auto;
        margin-right: auto;
	}
	table {
  border-collapse: collapse;
  width: 100%;
}
	.font-b{
	color: black;
	}

</style>
</head>
<body class="container">

	<!-- 로그인/로그아웃 버튼 및 상단 바 -->
	<jsp:include page="navbar.jsp"></jsp:include>
	<!-- main content -->
	<div class="mt-5 pt-3">	
		<strong>Employees</strong>
		<div>
			<h3>Employees Database 테이블 정보</h3>
		</div>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Employees</th>
					<th>Departments</th>
					<th>DeptEmp</th>
					<th>DeptManage</th>
					<th>Salaries</th>
					<th>titles</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${employeesRowCount}</td>
					<td>${departmentsRowCount}</td>
					<td>${deptEmpRowCount}</td>
					<td>${deptManagerRowCount}</td>
					<td>${salariesRowCount}</td>
					<td>${titlesRowCount}</td>				
				</tr>
			</tbody>			
		</table>
	</div>
	
	<!-- 차트출력(부서별 인원수 ) -->
	<div class="card">
	<canvas id="myChart"></canvas>
	
	</div>
	
	<footer>
		<div style="background: gray;">

		</div>
	</footer>
	</body>
</html>
<script>
	//chart.js bar  
	var ctx = document.getElementById('myChart')
	//부서별 인원수 배열
	var deptEmpCount = [0,0,0,0,0,0,0,0,0];
	//부서명 배열
	var labelName = ["","","","","","","","",""];
	var objson;
	$.ajax({
		url : "${pageContext.request.contextPath}/deptEmp/GetDepartmentEmpServlet",
		method : "post",
		success : function(json){
			console.log("chart",json)
			//*jsonArray - JSON 파싱
			objson = JSON.parse(json);
			console.log(objson)
			
			$(objson).each(function(index, item){
				deptEmpCount[index] = item.count;
				labelName[index] = item.departments.deptName;
			}); 
			console.log(deptEmpCount,"deptEmpCount")
			chart.update();
		},
	})
	
	var chart = new Chart(ctx, {
    type: 'bar',
    data: {
        labels: labelName,
        datasets: [{
            label: '부서별 인원 수',
            backgroundColor: 'rgb(255, 99, 132)',
            borderColor: 'rgb(255, 99, 132)',
            data: deptEmpCount,
        }],
    },

    // Configuration options go here
    options: {}
});
	
</script>
<%-- 
		#표현식 :employees table total row Count : <%=request.getAttribute("employeesRowCount")%>
		<br>
		#el : employees table total row Count : ${employeesRowCount}
--%>	