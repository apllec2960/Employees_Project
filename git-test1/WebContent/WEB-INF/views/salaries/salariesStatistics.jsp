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
</head>
<body class="container">

	<!-- 로그인/로그아웃 버튼 및 상단 바 -->
	<jsp:include page="../navbar.jsp"></jsp:include>
	
	<div class="mt-5 pt-3">	
	<strong>Employees</strong>
	<div>
		<h3>Employees Database 연봉 통계(count sum avg max min std)</h3>
	</div>

	<a href = "${pageContext.request.contextPath}/">홈으로</a>
	<table class ="table table-bordered text-center">
		<tr class="thead-dark">
			<th>모든 사원 수(COUNT)</th>
			<th>연봉 합계(SUM)</th>
			<th>평균 연봉(AVG)</th>
			<th>최고 연봉(MAX)</th>
			<th>최소 연봉(MIN)</th>
			<th>연봉 편차(STD)</th>
		</tr>
		<tr>
			<td>${map.COUNT }</td>
			<td>${map.SUM }</td>
			<td>${map.AVG }</td>
			<td>${map.MAX }</td>
			<td>${map.MIN }</td>
			<td>${map.STD }</td>
		</tr>
	</table>
	</div>
</body>
</html>