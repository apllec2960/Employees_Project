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
<h1>사원목록</h1>
	<div>
		<form method="post" action="${pageContext.request.contextPath}/employees/getEmployeesList">
			<select name="limit">
			<c:forEach var="i" begin = "10" end = "50" step = "10">
				<option value="${i}">${i}</option>
			 </c:forEach>
			 	 </select>개 까지
			 <button type="submit">확인</button>
		</form>
	</div>
	
	
	<table>
		<thead>
			<th>사원 번호</th>
			<th>사원 생일</th>
			<th>사원 성</th>
			<th>사원 이름</th>
			<th>사원 성별</th>
			<th>입사 날짜</th>
		</thead>
		<tbody>
			<c:forEach var="employees" items="${list}">
				<tr>
					<td>${employees.empNo }</td>
					<td>${employees.birthDate }</td>
					<td>${employees.firstName }</td>
					<td>${employees.lastName }</td>
					<td>${employees.gender }</td>
					<td>${employees.hireDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>