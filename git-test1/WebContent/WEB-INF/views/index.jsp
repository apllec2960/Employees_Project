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

	<!-- 로그인 버튼 -->
	<c:if test= "${sessionEmpNo == null}">
		<a href="${pageContext.request.contextPath}/login" class="font-b" style="float: right;">로그인</a>  <!-- LoginServlet -->
	</c:if>
	
	<c:if test="${sessionEmpNo != null }">
		<a href="${pageContext.request.contextPath}/logout" class="font-b" style="float: right;">로그아웃</a>  <!-- LogoutServlet -->
	</c:if>

	<h1 class = "text-center">EMPLOYEES</h1>
	
	<!-- 카테고리 설정 -->
	<div class="text-center small">
		<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
			<ul class="navbar-nav">
			    <li class="nav-item">
			     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesList" class="font-b">사원 목록(limit 10)</a>
			    </li>
			    <li class="nav-item">
			     	 <a class="nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsList" class="font-b">부서 목록</a>
			    </li>
			    <li class="nav-item">
			     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc" class="font-b">오름차순(limit50)</a>
			    </li>
			    <li class="nav-item">
			     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc" class="font-b">내림차순(limit50)</a>
			    </li>
			    <li class="nav-item">
			      	<a class="nav-link" href="${pageContext.request.contextPath}/salaries/getSalariesStatistics" class="font-b">연봉통계</a></td>
			    </li>
			    <li class="nav-item">
			     	 <a class="nav-link" href="${pageContext.request.contextPath}/titles/getTitlesListDistinct" class="font-b">업무목록(Distinct)</a>
			    </li>
			    <li class="nav-item">
			     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender" class="font-b">사원 수(성별 group by gender)</a>
			    </li>
			    <li class="nav-item">
			      	<a class="nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo" class="font-b">부서별 인원</a>
			    </li>
			    <li class="nav-item">
			     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListByPage" class="font-b">사원목록(페이징)</a>
			    </li>
			 </ul>
			
			<!-- 사원번호로 조회  -->
			 <form method="post" class="form-inline" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
				<input type = "number" class ="form-control mr-sm-2" style="width: 30%;" name="begin" placeholder="${minEmpNo}">~<input type="number" class="form-control mr-sm-2" style="width: 30%;" name="end" placeholder="${maxEmpNo}">
				<button type="submit" class="btn btn-light btn-outline-secondary" style="color: black;">사원목록 검색</button>
			 </form>
		</nav>
 	</div>
 	
	<div>
		<h3>Employees Database 테이블 정보</h2>
	</div>
	
	
	<div>	
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
		asdassad
		</div>
	</footer>
	</body>
</html>
<%-- 
		#표현식 :employees table total row Count : <%=request.getAttribute("employeesRowCount")%>
		<br>
		#el : employees table total row Count : ${employeesRowCount}
--%>	