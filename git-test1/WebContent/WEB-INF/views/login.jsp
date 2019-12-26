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
		<!-- login Form -->
		<div class="card shadow pt-2 px-2 mx-5 text-left" style="width: 380px"> 
			<form class="was-validated card-body" action="${pageContext.request.contextPath }/login" method="post">
			  <div class="form-group">
			    <label class="text-dark font-weight-bold" for="id">이름</label>
			    <input type="text" class="form-control form-control-sm" placeholder="firstName" value='Bezalel' name="firstName" required>
			    <div class="valid-feedback">좋아요.</div>
			    <div class="invalid-feedback">올바른 이메일을 입력해주세요.</div>
			  </div>
			  
			  <div class="form-group">
			    <label class="text-dark font-weight-bold" for="id">성</label>
			    <input type="text" class="form-control form-control-sm" placeholder="lastName" value='Simmel' name="lastName" required>
			    <div class="valid-feedback">좋아요.</div>
			    <div class="invalid-feedback">올바른 이메일을 입력해주세요.</div>
			  </div> 
			  
			  <div class="form-group">
			    <label class="text-dark font-weight-bold" for="pw"><span class="mr-4">사원번호</span>
			    </label> 					   
			    <input type="text" class="form-control form-control-sm" value='10002' placeholder="empNo" name="empNo" required>
			    <div class="valid-feedback">좋아요.</div>
			    <div class="invalid-feedback">비밀번호를 입력해주세요.</div>
			  </div> 
			  <button type="submit" class="btn btn-block btn-primary join" id="login">로그인</button> 
			</form>  
		</div>
	</div>
</body>
</html>