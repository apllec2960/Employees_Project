<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>연봉 통계(count sum avg max min std)</h1>
	<table>
		<tr>
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