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
<body class="container" >
	<div align="center">
	<h1 class="text-center">로그인</h1>
	<hr>

		<form method="post" action="${pageContext.request.contextPath }/login">
			<table width="30%">
				<tr>
					<td width="30%">이름 </td>
					<td><input type="text" name="firstName" value="Bezalel"></td>
				</tr>
				<tr>
					<td>성  </td>
					<td><input type="text" name="lastName" value="Simmel"></td>
				</tr>
				<tr>
					<td>사원번호 </td>
					<td><input type="text" name="empNo" value="10002"></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">확인</button>
		</form>
	</div>
</body>
</html>