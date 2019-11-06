<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 자바 코드를 태그로 표현을 가능케 함. -->
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
	<h1 class="text-center">부서목록</h1>
	<a href ="${pageContext.request.contextPath}/">홈으로</a>
	<hr>
	<!-- List<Departments> list = (List<Departments>)request.getAttribute("list"); -->
	 <!-- ${list} -->
	<table class="table table-bordered">
		<thead class="thead-dark">
			<tr class="text-center">
				<th>부서 번호</th>
				<th>부서 명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="departments" items="${list}" > <!--  for(Departments departments : list) {-->
				<tr class="text-center">
					<td>${departments.deptNo}</td> <!-- departments.getDeptNo() -->
					<td>${departments.deptName}</td>
				</tr>
			</c:forEach> <!--  } -->
		</tbody>
	</table>
</body>
</html>