<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>상품노출페이지</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
    
    <script src = "https://code.jquery.com/jquery-3.6.1.min.js"></script>
	<script type="text/javascript" src="http://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</head>

<body>
	<main class="front">
		<header class = "home_header">
			<span class = "aside_menu_toggle sprite">Aside Toggle Button</span>
			<c:if test="${member.adminCk== 1}">
				<a href = "register.do" class = "register">상품 등록</a>
				<a href = "admin.do" class = "register">관리자 페이지</a>
			</c:if>
			
			<div class = "top_links">
					
					<a href = "#" class = "sprite wishlist">wishlist</a>
					<a href = "cart_list.do" class = "sprite cart" data-cart-count= "0">cart</a>
			</div>
		</header>
		
		<div class="search_wrap">
        	<form id="searchForm" action="searchBtn.do" method="get">
            <div class="search_input">
            	<select name = "type">
            		<option value ="T">의류이름</option>
            	</select>
                <input type="text" name="keyword">
                <button type="submit" class="btn search_btn">검 색</button>               				
            </div>
            </form>
        </div>
        
		<div class = "home_content">
			<div class = "categories_slide">
				<div class = "category_menus">
					<div class="swiper-wrapper">
						<a href = "#" class = "swiper-slide">OUTERWEAR</a>
						<a href = "#" class = "swiper-slide">TRENCH COATS</a>
						<a href = "#" class = "swiper-slide">JACKETS</a>
						<a href = "#" class = "swiper-slide">BLAZERS</a>
						<a href = "#" class = "swiper-slide">KNITWEAR</a>
						<a href = "#" class = "swiper-slide">DRESSES</a>
						<a href = "#" class = "swiper-slide">JUMPSUITS</a>
						<a href = "#" class = "swiper-slide">T-SHIRTS</a>
						<a href = "#" class = "swiper-slide">TROUSERS</a>
						<a href = "#" class = "swiper-slide">JEANS</a>
					</div>
				</div>
			</div>
			<ul class = "products_list">
				<li>
					<a href = "detail1_list.do">
					<div class = "picture" style = "background-image:url('resources/img/item_01.jpg')">KIMONO1</div>
					</a>
					<h3><a href = "detail1_list.do">KIMONO</a></h3>
					<h4><a href = "detail1_list.do">89000</a></h4>
				</li>
				<li>
					<a href = "detail1_list.do">
					<div class = "picture" style = "background-image:url('resources/img/item_02.jpg')">KIMONO1</div>
					</a>
					<h3><a href = "detail1_list.do">DOUBLE-SIDED COAT</a></h3>
					<h4><a href = "detail1_list.do">230000</a></h4>
				</li>
				<li>
					<a href = "detail1_list.do">
					<div class = "picture" style = "background-image:url('resources/img/item_03.jpg')">KIMONO1</div>
					</a>
					<h3><a href = "detail1_list.do">BROWN DOUBLE COAT</a></h3>
					<h4><a href = "detail1_list.do">250000</a></h4>
				</li>
				<li>
					<a href = "detail1_list.do">
					<div class = "picture" style = "background-image:url('resources/img/item_04.jpg')">KIMONO1</div>
					</a>
					<h3><a href = "detail1_list.do">KHAKI JACKET</a></h3>
					<h4><a href = "detail1_list.do">149000</a></h4>
				</li>
				<li>
					<a href = "detail1_list.do">
					<div class = "picture" style = "background-image:url('resources/img/item_05.jpg')">KIMONO1</div>
					</a>
					<h3><a href = "detail1_list.do">WHITE SHORT PADDING</a></h3>
					<h4><a href = "detail1_list.do">120000</a></h4>
				</li>
				<li>
					<a href = "detail1_list.do">
					<div class = "picture" style = "background-image:url('resources/img/item_06.jpg')">KIMONO1</div>
					</a>
					<h3><a href = "detail1_list.do">IBORY JACKET</a></h3>
					<h4><a href = "detail1_list.do">130000</a></h4>
				</li>
			</ul>
		</div>
	</main>
	
	<aside>
		<header>
			<img src = "resources/img/user_profile.png" alt = "Dennis james profile">
			<!-- 로그인한 상태 -->
                <c:if test="${ member != null }">
                    <div class="login_success_area">
                        <span>회원아이디 : ${member.memberId}</span>
                        <span>이름 : ${member.memberName}</span>
                       	<span>포인트 : <fmt:formatNumber value="${member.point }" pattern="#,###" /></span>
                       	<div class = "login_menu">
							<a href="logout.do">로그아웃</a>
						</div>
                    </div>
                </c:if>
		</header>
		
		<section class = "aside_content">
			<ul class = "categories">
				<li><h3>WOMAN</h3> <span class = "sprite plus">plus</span>
					<ul>
						<li><a href = "#">OUTERWEAR</a></li>
						<li><a href = "#">TRENCH COAT</a></li>
						<li><a href = "#">JARKET</a></li>
					</ul>
				</li>
				
				<li><h3>MAN</h3> <span class = "sprite plus">plus</span>
					<ul>
						<li><a href = "#">OUTERWEAR</a></li>
						<li><a href = "#">TRENCH COAT</a></li>
						<li><a href = "#">SUITE</a></li>
					</ul>
				</li>
				
				<li><h3>KIDS</h3> <span class = "sprite plus">plus</span>
					<ul>
						<li><a href = "#">OUTERWEAR</a></li>
						<li><a href = "#">JARKET</a></li>
					</ul>
				</li>
			</ul>
			
			<ul class = "aside_menus">
				<li><a href = "#">Home</a></li>
				<li><a href = "#">Top deals</a></li>
				<li><a href = "#">News products</a></li>
				<li><a href = "#">Stores</a></li>
				<li><a href = "#">WishList</a></li>
				<li><a href = "#">Settings</a></li>
			</ul>
		</section>
	</aside>

	<script>
	

	// 홈 카테고리 슬라이드
	if($('.category_menus').length){

		$('.swiper-wrapper').slick({
			  dots: false,
			  arrows : false,
			  infinite: false,
			  speed: 300,
			  slidesToShow: 1,
			  centerMode: false,
			  variableWidth: true
			});
	}
	// Aside menu
	if($('.aside_menu_toggle').length){
		var asideToggleBtn = $('.aside_menu_toggle');
		
		asideToggleBtn.click(function(){
			$('body').toggleClass('aside_active');
		});
		
		// aside menu accodion
		var asideMenuList = $('.categories > li');
		asideMenuList.click(function(){
			$(this).find('ul').slideToggle();
			$(this).siblings('li').find('ul').slideUp();
		});
	}
	</script>
</body>
</html>
