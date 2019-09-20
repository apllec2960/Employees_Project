<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Index</h1>
	<div>
		<ul>
			<li><a href="${pageContext.request.contextPath}/employees/getEmployeesList">사원 목록</a></li>
			<li><a href="${pageContext.request.contextPath}/departments/getDepartmentsList">부서 목록</a></li>
		</ul>
	</div>
	
	<div>
		표현식 :employees table total row Count : <%=request.getAttribute("employeesRowCount")%>
		<br>
		el : employees table total row Count : ${employeesRowCount}
		
	</div>
</body>
</html>