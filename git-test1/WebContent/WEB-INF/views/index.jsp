<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
	<footer>
		<div style="background: gray;">

		</div>
	</footer>
	</body>
</html>
<%-- 
		#표현식 :employees table total row Count : <%=request.getAttribute("employeesRowCount")%>
		<br>
		#el : employees table total row Count : ${employeesRowCount}
--%>	