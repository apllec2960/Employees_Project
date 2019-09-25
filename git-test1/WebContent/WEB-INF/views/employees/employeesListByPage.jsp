<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>
	<h1 class = "text-center">사원목록 페이징
		<div>
			<form method="get" action ="${pageContext.request.contextPath}/employees/getEmployeesListByPage?limit=${rowPerPage}">
				<select name="rowPerPage">
					<option value="10">10</option>
					<option value="20">20</option>
					<option value="30">30</option>
					<option value="40">40</option>
					<option value="50">50</option>
				</select>
				<button type="submit">확인</button>
			</form>
		</div>
	</h1>
	<table  class ="table table-bordered text-center">
		<tr class ="thead-dark">
			<th>emp_no</th>
			<th>birth_date</th>
			<th>first_name</th>
			<th>last_name</th>
			<th>gender</th>
			<th>hire_date</th>
		</tr>
		<c:forEach var="i" items = "${list }">
			<tr>
				<td>${i.empNo }</td>
				<td>${i.birthDate }</td>
				<td>${i.firstName }</td>
				<td>${i.lastName }</td>
				<td>${i.gender }</td>
				<td>${i.hireDate }</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<c:if test="${currentPage > 1 }">	<!-- if문과 같음  if(currentPage >1) -->
			<a href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a>
		</c:if>
		<c:if test="${currentPage < lastPage }">
			<a href ="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
		</c:if>
	</div>
</body>
</html>