<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 자바 코드를 태그로 표현을 가능케 함. -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>부서목록</h1>
	<!-- List<Departments> list = (List<Departments>)request.getAttribute("list"); -->
	 <!-- ${list} -->
	<table>
		<thead>
			<tr>
				<th>부서 번호</th>
				<th>부서 명</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="departments" items="${list}" > <!--  for(Departments departments : list) {-->
				<tr>
					<td>${departments.deptNo}</td> <!-- departments.getDeptNo() -->
					<td>${departments.deptName}</td>
				</tr>
			</c:forEach> <!--  } -->
		</tbody>
	</table>
</body>
</html>