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

<style>
	.wrapper {
		    display: grid;
		    grid-template-columns: 20% 20% 20% 20% 20%;
		    grid-template-rows: 10vh 10vh 10vh 10vh 10vh;
		}
</style>
</head>
<body class="container">

	<!-- 로그인/로그아웃 버튼 및 상단 바 -->
	<jsp:include page="../navbar.jsp"></jsp:include>
	
	<div class="mt-5 pt-3">	
	<strong>Employees</strong>
	<div>
		<h3>Employees Database 업무목록 (DISTINCT)</h3>
	</div>

	<a href = "${pageContext.request.contextPath}/">홈으로</a>
	<div class="wrapper card">
			<c:forEach var = "row" items ="${list}">
				<p>${row}</p>
			</c:forEach>
	</div>
	</div>
</body>
</html>