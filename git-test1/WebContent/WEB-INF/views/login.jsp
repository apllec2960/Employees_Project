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
	<h1>로그인</h1>
	
	<form method="post" action="${pageContext.request.contextPath }/login">
		<div>first_name
			<input type="text" name="firstName">
		</div>
		<div>last_name
			<input type="text" name="lastName">
		</div>
		<div>emp_no
			<input type="text" name="empNo">
		</div>
		<button type="submit">확인</button>
	</form>
</body>
</html>