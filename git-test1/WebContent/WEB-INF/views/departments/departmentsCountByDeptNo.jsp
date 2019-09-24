<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서별 인원수</h1>
	<table>
		<tr>
			<th>deptNo</th>
			<th>deptName</th>
			<th>Count(deptNo)</th>
		</tr>
		<c:forEach var="i" items="${list }">
		<tr>
			<td>${i.deptNo }</td>
			<td>${i.deptName }</td>
			<td>${i.cnt }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>