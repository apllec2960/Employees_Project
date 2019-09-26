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
</style>
</head>
<body>
	<h1 class = "text-center">Index</h1>
	<c:if test= "${sessionEmpNo == null}">
		<a href="${pageContext.request.contextPath}/login">로그인</a>  <!-- LoginServlet -->
	</c:if>
	
	<c:if test="${sessionEmpNo != null }">
		<a href="${pageContext.request.contextPath}/logout">로그아웃</a>  <!-- LogoutServlet -->
	</c:if>
	
	<div>
		<table class ="table-border">
			<tr>
				<td><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록(limit 10)</a></td>
				<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></td>
				<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc">오름차순(limit50)</a></td>
				<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc">내림차순(limit50)</a></td>
				<td><a href="${pageContext.request.contextPath}/salaries/getSalariesStatistics">연봉통계</a></td>
				<td><a href="${pageContext.request.contextPath}/titles/getTitlesListDistinct">업무목록(Distinct)</a></td>
				<td><a href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender">사원 수(성별 group by gender)</a></td>
				<td><a href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo">부서별 인원</a></td>
				<td><a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage">사원목록(10paging)</a></td>
			</tr>
		</table>
	</div>
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
		<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type = "number" name="begin">~<input type="number" name="end">
			<button type="submit">사원목록 beween ... and ...</button>
			(${maxEmpNo}~${minEmpNo})
		</form>
		표현식 :employees table total row Count : <%=request.getAttribute("employeesRowCount")%>
		<br>
		el : employees table total row Count : ${employeesRowCount}
	</div>
	
</body>
</html>