<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 카테고리 설정 -->
<div class="text-center small">
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<ul class="navbar-nav">
		    <li class="nav-item">
		     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesList" class="font-b">사원 목록(limit 10)</a>
		    </li>
		    <li class="nav-item">
		     	 <a class="nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsList" class="font-b">부서 목록</a>
		    </li>
		    <li class="nav-item">
		     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=asc" class="font-b">오름차순(limit50)</a>
		    </li>
		    <li class="nav-item">
		     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListOrderBy?order=desc" class="font-b">내림차순(limit50)</a>
		    </li>
		    <li class="nav-item">
		      	<a class="nav-link" href="${pageContext.request.contextPath}/salaries/getSalariesStatistics" class="font-b">연봉통계</a>
		    </li>
		    <li class="nav-item">
		     	 <a class="nav-link" href="${pageContext.request.contextPath}/titles/getTitlesListDistinct" class="font-b">업무목록(Distinct)</a>
		    </li>
		    <li class="nav-item">
		     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesCountByGender" class="font-b">사원 수(성별 group by gender)</a>
		    </li>
		    <li class="nav-item">
		      	<a class="nav-link" href="${pageContext.request.contextPath}/departments/getDepartmentsCountByDeptNo" class="font-b">부서별 인원</a>
		    </li>
		    <li class="nav-item">
		     	 <a class="nav-link" href="${pageContext.request.contextPath}/employees/getEmployeesListByPage" class="font-b">사원목록(페이징)</a>
		    </li>
		 </ul>
		
		<!-- 사원번호로 조회  -->
		 <form method="post" class="form-inline" action="${pageContext.request.contextPath}/employees/getEmployeesListBetween">
			<input type = "number" class ="form-control mr-sm-2" style="width: 30%;" name="begin" placeholder="${minEmpNo}">~<input type="number" class="form-control mr-sm-2" style="width: 30%;" name="end" placeholder="${maxEmpNo}">
			<button type="submit" class="btn btn-light btn-outline-secondary" style="color: black;">사원목록 검색</button>
		 </form>
		
		 <!-- 로그인 버튼 -->
		<c:if test= "${sessionEmpNo == null}">
			<a href="${pageContext.request.contextPath}/login" class="font-b text-light">로그인</a>  <!-- LoginServlet -->
		</c:if>
		
		<c:if test="${sessionEmpNo != null }">
			<a href="${pageContext.request.contextPath}/logout" class="font-b text-light">로그아웃</a>  <!-- LogoutServlet -->
		</c:if>
	</nav>
	</div>