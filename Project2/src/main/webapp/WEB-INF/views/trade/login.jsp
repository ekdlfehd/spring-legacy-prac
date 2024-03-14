<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
    <title>login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<script src = "https://code.jquery.com/jquery-3.6.1.min.js"></script>
	
</head>

 <body> 
	<main class = "front">
	 	<header>
 			<a href = "" class = "sprite arrow_left go_back">go back</a>
 		</header>
 		<section class = "sub_content">
 			<h1 class = "heading1">Welcome back !</h1>
 			<form class = "login_form">
				<fieldset>
					<legend class = "hidden">Login form</legend>
					<label for = "memberId">ID</label>
					<input type = "text" id = "memberId" name = "memberId" placeholder="아이디를 입력하세요">
					<label for = "memberPw">Password</label>
					<input type = "text" id = "memberPw" name = "memberPw" placeholder="비밀번호를 입력하세요">
				</fieldset>
				<a href = "#">Forgot password ?</a>
				
				<c:if test= "${result==0}">
					<div class="Login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다</div>
				</c:if>
           		 
				<input type = "submit" value = "Sign In" class = "btn big" onclick = "login(this.form)">
	 		</form>	
 		</section>
	</main>  
	
	<script>
	// 히스토리 뒤로가기
	$('.go_back').click(function(e){
		e.preventDefault();
		if(window.history.length > 1){
			window.history.go(-1);
		}else{
			location.href = "main_list2.do"
		}
	});
	
	// 로그인 버튼 클릭
	function login(f){
		
		
		
		
		f.action = "login_start.do";
		f.method = "POST";
		f.submit();
	} 
	</script>
</body>
</html>
