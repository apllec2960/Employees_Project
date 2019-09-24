<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>업무목록 (DISTINCT)</h1>
	<ul>
		<c:forEach var = "row" items ="${list}">
			<li>${row}</li>
		</c:forEach>
	</ul>
</body>
</html>