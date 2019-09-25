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
<body>
	<h1 class= "text-center">연봉 통계(count sum avg max min std)</h1>
	<a href = "${pageContext.request.contextPath}/">홈으로</a>
	<table class ="table table-bordered text-center">
		<tr class="thead-dark">
			<th>COUNT</th>
			<th>SUM</th>
			<th>AVG</th>
			<th>MAX</th>
			<th>MIN</th>
			<th>STD</th>
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
</body>
</html>