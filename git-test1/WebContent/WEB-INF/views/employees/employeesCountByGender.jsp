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
	<h1> 사원수(gender)</h1>
	<a href = "${pageContext.request.contextPath}/">홈으로</a>
	
	<table class ="table table-bordered text-center">
		<tr class="thead-dark text-center">
			<th>Gender</th>
			<th>count(gender)</th>
		</tr>
		<c:forEach var="map" items="${list}"><!--  var = "변수" items ="list에 속성을 저장한 값을 가져옴" -->
			<tr>
				<td>${map.gender}</td>
				<td>${map.cnt}</td>
			</tr>
		</c:forEach> 
	</table>
</body>
</html>