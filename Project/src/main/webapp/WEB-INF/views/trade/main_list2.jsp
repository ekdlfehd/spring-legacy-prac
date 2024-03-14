<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>시작</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
    
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
	<script src = "https://code.jquery.com/jquery-3.6.1.min.js"></script>
  </head>

  <body> 
	  <main class = "front">
	 	 <section class = "main_content">
	 	 	    <div class= "main_slide_wrapper">
	 	 	    	<div class="main_slide_container mySwiper">
	 	 	    		<ul class = "main_banner swiper-wrapper">
	 	 	    			<li class = "swiper-slide"><a href = "#"><img src = "resources/img/main_slide_01.jpg" alt = "1"></a></li>
							<li class = "swiper-slide"><a href = "#"><img src = "resources/img/main_slide_02.jpg" alt = "2"></a></li>
							<li class = "swiper-slide"><a href = "#"><img src = "resources/img/main_slide_03.jpg" alt = "3"></a></li>
	 	 	    			<li class = "swiper-slide"><a href = "#"><img src = "resources/img/main_slide_01.jpg" alt = "1"></a></li>
							<li class = "swiper-slide"><a href = "#"><img src = "resources/img/main_slide_02.jpg" alt = "2"></a></li>
							<li class = "swiper-slide"><a href = "#"><img src = "resources/img/main_slide_03.jpg" alt = "3"></a></li>
	 	 	    		</ul>
	 	 	    		<div class="swiper-button-next"></div>
      					<div class="swiper-button-prev"></div>
     					 <div class="swiper-pagination"></div>
	 	 	    	</div> <!-- //main_slide_container -->
	  			</div><!-- //main_slide_wrapper -->
	  			<div class = "main_content_info">
	  				<h1 class = "heading2">Free Shipping</h1>
	  				<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam consequat laoreet dignissim.</p>
	  			</div>
	 	 </section>
 	 	 <footer class = "main_footer">
	 	 	<a href = "login.do" class = "btn big">Sign In</a>
	 	 	<a href = "signup.do" class = "btn big">Sign Up</a>
	 	 </footer>
	  </main>
	  
	  


    <!-- Initialize Swiper -->
    <!-- 메인화면 슬라이드 -->
    <script>
      var swiper = new Swiper(".mySwiper", {
        slidesPerView: 1,
        spaceBetween: 25,
        width:270,
        slidesPerGroup: 3,
        loop: true,
        loopFillGroupWithBlank: true,
        pagination: {
          el: ".swiper-pagination",
          clickable: true,
        },
        navigation: {
          nextEl: ".swiper-button-next",
          prevEl: ".swiper-button-prev",
        },
      });
    </script>
  </body>
</html>
