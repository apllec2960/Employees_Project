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
<body class="container">
	
	<!-- 로그인/로그아웃 버튼 및 상단 바 -->
	<jsp:include page="../navbar.jsp"></jsp:include>
	
	<div class="mt-5 pt-3">	
	<strong>Employees</strong>
	<div>
		<h3>Employees Database 사원목록 페이징</h3>
	</div>
	
	<!-- 보여줄 행의 수 선택 -->
	<div>
		<form method="get" action ="${pageContext.request.contextPath}/employees/getEmployeesListByPage?limit=${rowPerPage}">
			<select name="rowPerPage">
				<option value="10">10</option>
				<option value="20">20</option>
				<option value="30">30</option>
				<option value="40">40</option>
				<option value="50">50</option>
			</select>
			<button type="submit">확인</button>
		</form>
	</div>
	
	<!-- 리스트 출력 테이블 -->
	<table  class ="table table-bordered text-center">
		<tr class ="thead-dark">
			<th>사원번호</th>
			<th>생년월일</th>
			<th>이름</th>
			<th>성</th>
			<th>성별</th>
			<th>입사일</th>
		</tr>
		<c:forEach var="i" items = "${list }">
			<tr>
				<td>${i.empNo }</td>
				<td>${i.birthDate }</td>
				<td>${i.firstName }</td>
				<td>${i.lastName }</td>
				<td>${i.gender }</td>
				<td>${i.hireDate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 버튼 -->
	<div>
		<c:if test="${currentPage > 1 }">	<!-- if문과 같음  if(currentPage >1) -->
			<a class="btn btn-secondary" href="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage-1}&rowPerPage=${rowPerPage}">이전</a></button>
		</c:if>
		<c:if test="${currentPage < lastPage }">
			<a class="btn btn-secondary" href ="${pageContext.request.contextPath}/employees/getEmployeesListByPage?currentPage=${currentPage+1}&rowPerPage=${rowPerPage}">다음</a>
		</c:if>
	</div>
	</div>
</body>
</html>