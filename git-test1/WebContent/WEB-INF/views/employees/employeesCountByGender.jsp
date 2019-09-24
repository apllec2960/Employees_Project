<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1> 사원수(gender)</h1>
	<table>
		<tr>
			<th>Gender</th>
			<th>count(gender)</th>
		</tr>
		<c:forEach var="i" items="${list }"></c:forEach> <!--  var = "변수" items ="list에 속성을 저장한 값을 가져옴" -->
		<tr>
			<td>${i.gender }</td>
			<td>${i.cnt }</td>
		</tr>
	</table>
</body>
</html>