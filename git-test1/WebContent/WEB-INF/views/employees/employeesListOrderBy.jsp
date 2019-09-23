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
</head>
<body>
<h1 class="text-center">사원목록</h1>
<a href = "${pageContext.request.contextPath}/">홈으로</a>
	<div class="text-right">
		<form method="get" action="${pageContext.request.contextPath}/employees/getEmployeesList">
			<select name="limit">	 <!-- 페이지당 보여줄 개수선택 -->
				<c:forEach var="i" begin="10" end="50" step="10">  <!--변수, 시작, 끝, 반복하는 수 -->
					<option value="${i}">${i}</option>	
				</c:forEach>
			</select>개
			<button type="submit">보기</button>
		</form>
	</div>
	<div>
		<table class= "table table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>사원 번호</th>
					<th>사원 생일</th>
					<th>사원 성</th>
					<th>사원 이름</th>
					<th>사원 성별</th>
					<th>입사 날짜</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employees" items="${list}">
					<tr>
						<td>${employees.empNo }</td>
						<td>${employees.birthDate }</td>
						<td>${employees.firstName }</td>
						<td>${employees.lastName }</td>
						<td>${employees.gender }</td>
						<td>${employees.hireDate }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>