<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
</style>
</head>
<body>
	<h1 class = "text-center">Index</h1>
	
	<div>
		<table class="table table-bordered">
			<tr class= "text-center">
				<th>테이블 이름</th>
				<th>전체 행의 수</th>
			</tr>
			<tr>
				<td>Employees</td>
				<td>${employeesRowCount}</td>
			</tr>
			<tr>
				<td>Departments</td>
				<td>${departmentsRowCount}</td>
			</tr>
			<tr>
				<td>Dept_emp</td>
				<td>${deptEmpRowCount}</td>
			</tr>
			<tr>
				<td>Dept_manager</td>
				<td>${deptManagerRowCount}</td>
			</tr>
			<tr>
				<td>Salaries</td>
				<td>${salariesRowCount}</td>
			</tr>
			<tr>
				<td>Titles</td>
				<td>${titlesRowCount}</td>
			</tr>
		</table>
	</div>
	
	<div class="text-center">
		표현식 :employees table total row Count : <%=request.getAttribute("employeesRowCount")%>
		<br>
		el : employees table total row Count : ${employeesRowCount}
	</div>
	
	<div >
		<ul class="a">
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
		</ul>
	</div>
	<div>first_name 정렬
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순(limit50)</a>	
		<a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">오름차순(limit50)</a>			
		
	</div>
</body>
</html>