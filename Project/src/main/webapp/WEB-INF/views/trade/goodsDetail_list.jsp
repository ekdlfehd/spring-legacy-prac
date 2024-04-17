<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title>상품검색페이지</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">

<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
</head>

<body>
	<main class="front">
		<header class="home_header">
			<span class="aside_menu_toggle sprite">Aside Toggle Button</span>
			<c:if test="${member.adminCk== 1}">
				<a href="register.do" class="register">상품 등록</a>
				<a href="admin.do" class="register">관리자 페이지</a>
			</c:if>

			<div class="top_links">
				<a href="#" class="sprite wishlist">wishlist</a> <a
					href="cart_list.do" class="sprite cart" data-cart-count="0">cart</a>
			</div>
		</header>

		<div class="search_wrap">
			<form id="searchForm" action="searchBtn.do" method="get">
				<div class="search_input">
					<select name="type">
						<option value="T">의류이름</option>
					</select> <input type="text" name="keyword"
						value="<c:out value ="${pageMaker.cri.keyword}"/>">
					<button type="submit" class="btn search_btn">검 색</button>
				</div>
			</form>
		</div>

		<div class="home_content">
			<div class="categories_slide">
				<div class="category_menus">
					<div class="swiper-wrapper">
						<a href="#" class="swiper-slide">OUTERWEAR</a> <a href="#"
							class="swiper-slide">TRENCH COATS</a> <a href="#"
							class="swiper-slide">JACKETS</a> <a href="#" class="swiper-slide">BLAZERS</a>
						<a href="#" class="swiper-slide">KNITWEAR</a> <a href="#"
							class="swiper-slide">DRESSES</a> <a href="#" class="swiper-slide">JUMPSUITS</a>
						<a href="#" class="swiper-slide">T-SHIRTS</a> <a href="#"
							class="swiper-slide">TROUSERS</a> <a href="#"
							class="swiper-slide">JEANS</a>
					</div>
				</div>
			</div>

			<div class="content_area">
			
				<div class="line">
			</div>			
			<div class="content_top">
				<div class="ct_left_area">
					<div class="image_wrap" data-clothesid="${goodsInfo.imageList[0].clothesId}" data-path="${goodsInfo.imageList[0].uploadPath}" data-uuid="${goodsInfo.imageList[0].uuid}" data-filename="${goodsInfo.imageList[0].fileName}">
						<img>
					</div>				
				</div>
				<div class="ct_right_area">
					<div class="title">
						<h1>
							[${goodsInfo.cateName}]  
							${goodsInfo.clothesName}
						</h1>
					</div>
					<div class="line">
					</div>
					<div class="line">
					</div>	
					<div class="price">
						<div class="sale_price">정가 : <fmt:formatNumber value="${goodsInfo.clothesPrice}" pattern="#,### 원" /></div>
						<div class="discount_price">
							판매가 : <span class="discount_price_number"><fmt:formatNumber value="${goodsInfo.clothesPrice - (goodsInfo.clothesPrice*goodsInfo.clothesDiscount)}" pattern="#,### 원" /></span> 
							[<fmt:formatNumber value="${goodsInfo.clothesDiscount*100}" pattern="###" />% 
							<fmt:formatNumber value="${goodsInfo.clothesPrice*goodsInfo.clothesDiscount}" pattern="#,### 원" /> 할인]</div>							
					</div>			
					<div class="line">
					</div>	
					<div class="button">						
						<div class="button_quantity">
							주문수량
							<input type="text" value="1">
							<span>
								<button>+</button>
								<button>-</button>
							</span>
						</div>
						<div class="button_set">
							<a class="btn_cart">장바구니 담기</a>
							<a class="btn_buy">바로구매</a>
						</div>
					</div>
				</div>
			</div>
			<div class="line">
			</div>				
			<div class="content_middle">
				<div class="clothes_intro">
					<h1>상품 상세</h1>
				
				
					${goodsInfo.clothesIntro}
				</div>
			</div>
			<div class="line">
			</div>			
				
			<div class="content_bottom">
				<div class="clothes_intro">
					<h1>리 뷰</h1>
					
					<div class="reply_not_div">
					
					</div>
					
						<ul class="reply_content_ul">
							
						</ul>
						
					<div class="repy_pageInfo_div">
						<ul class="pageMaker">
						
						</ul>
					</div>
					
				</div>
			</div>
			
			<c:if test="${member != null}">
				<div class="reply_button_wrap">
					<button>리뷰 쓰기</button>
				</div>
			</c:if>

			</div>

		</div>
	</main>
	<aside>
		<header>
			<img src="resources/img/user_profile.png" alt="Dennis james profile">
			<!-- 로그인한 상태 -->
			<c:if test="${ member != null }">
				<div class="login_success_area">
					<span>회원아이디 : ${member.memberId}</span> <span>이름 :
						${member.memberName}</span> <span>포인트 : <fmt:formatNumber
							value="${member.point }" pattern="#,###" /></span>
					<div class="login_menu">
						<a href="logout.do">로그아웃</a>
					</div>
				</div>
			</c:if>
		</header>

		<section class="aside_content">
			<ul class="categories">
				<li>
					<h3>WOMAN</h3> <span class="sprite plus">plus</span>
					<ul>
						<li><a href="#">OUTERWEAR</a></li>
						<li><a href="#">TRENCH COAT</a></li>
						<li><a href="#">JARKET</a></li>
					</ul>
				</li>

				<li>
					<h3>MAN</h3> <span class="sprite plus">plus</span>
					<ul>
						<li><a href="#">OUTERWEAR</a></li>
						<li><a href="#">TRENCH COAT</a></li>
						<li><a href="#">SUITE</a></li>
					</ul>
				</li>

				<li>
					<h3>KIDS</h3> <span class="sprite plus">plus</span>
					<ul>
						<li><a href="#">OUTERWEAR</a></li>
						<li><a href="#">JARKET</a></li>
					</ul>
				</li>
			</ul>

			<ul class="aside_menus">
				<li><a href="#">Home</a></li>
				<li><a href="#">Top deals</a></li>
				<li><a href="#">News products</a></li>
				<li><a href="#">Stores</a></li>
				<li><a href="#">WishList</a></li>
				<li><a href="#">Settings</a></li>
			</ul>
		</section>
	</aside>

	<script>
		// 홈 카테고리 슬라이드
		if ($('.category_menus').length) {
			$('.swiper-wrapper').slick({
				dots : false,
				arrows : false,
				infinite : false,
				speed : 300,
				slidesToShow : 1,
				centerMode : false,
				variableWidth : true
			});
		}
		// Aside menu
		if ($('.aside_menu_toggle').length) {
			var asideToggleBtn = $('.aside_menu_toggle');
			asideToggleBtn.click(function() {
				$('body').toggleClass('aside_active');
			});

			// aside menu accodion
			var asideMenuList = $('.categories > li');
			asideMenuList.click(function() {
				$(this).find('ul').slideToggle();
				$(this).siblings('li').find('ul').slideUp();
			});
		}

		/* 페이지 이동 버튼 */
		const moveForm = $('#moveForm');

		$(".pageMaker_btn a").on("click", function(e) {

			e.preventDefault();

			moveForm.find("input[name='pageNum']").val($(this).attr("href"));

			moveForm.submit();

		});
		/* 리뷰쓰기 */
		$(".reply_button_wrap").on("click", function(e){
			
			e.preventDefault();			
			
			const memberId = '${member.memberId}';
			const clothesId = '${goodsInfo.clothesId}';
			
			$.ajax({
				data : {
					clothesId : clothesId,
					memberId : memberId
				},
				url : "/reply/check",
				type : 'POST',
				success : function(result){
					
					if(result === '1'){
						alert("이미 등록된 리뷰가 존재 합니다.")
					} else if(result === '0'){
						let popUrl = "replyEnroll.do" + memberId + "?clothesId=" + clothesId;
						console.log(popUrl);
						let popOption = "width = 490px, height=490px, top=300px, left=300px, scrollbars=yes";
						
						window.open(popUrl,"리뷰 쓰기",popOption);							
					}
				}
			});
			
		});
		
		

		$(document).ready(function() {
			
			// 검색 타입 selected
			const selectedType = '<c:out value="${pageMaker.cri.type}"/>';
			if (selectedType != "") {
			$("select[name='type']").val(selectedType).attr("selected", "selected");
							}
			/* 이미지 삽입 */
			$(".image_wrap").each(function(i, obj){
				
				const bobj = $(obj);
				
				if(bobj.data("clothesid")){
				const uploadPath = bobj.data("path");
				const uuid = bobj.data("uuid");
				const fileName = bobj.data("filename");
				
				const fileCallPath = encodeURIComponent(uploadPath + "/" + uuid + "_" + fileName);
				
				$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
				}else {
					$(this).find("img").attr('src', '/resources/img/noimage.jpg');
				}
			});
			
			
			/* 리뷰 리스트 출력 */
			const clothesId = '${goodsInfo.clothesId}';	

			$.getJSON("/reply/list", {clothesId : clothesId}, function(obj){
				
				makeReplyContent(obj);
				
			}); 
			
						}); // $(document).ready(function(){}
						
		/* 댓글 페이지 정보 */
		 const cri = {
			clothesId : '${goodsInfo.clothesId}',
			pageNum : 1,
			amount : 10
		}				
						
						
		/* 댓글 페이지 이동 버튼 동작 */
		$(document).on('click', '.pageMaker_btn a', function(e){
			e.preventDefault();
			
			let page = $(this).attr("href");	
			cri.pageNum = page;		
			
			replyListInit();					
								
		 });				
						
		/* 댓글 데이터 서버 요청 및 댓글 동적 생성 메서드 */
		let replyListInit = function(){
			$.getJSON("/reply/list", cri , function(obj){
								
				makeReplyContent(obj);
								
			});		
		}					
		
		/* 리뷰 수정 버튼 */
		 $(document).on('click', '.update_reply_btn', function(e){
			e.preventDefault();
			let replyId = $(this).attr("href");
			let popUrl = "/replyUpdate?replyId=" + replyId + "&clothesId=" + '${goodsInfo.clothesId}' + "&memberId=" + '${member.memberId}';	
			let popOption = "width = 490px, height=490px, top=300px, left=300px, scrollbars=yes"	
			
			window.open(popUrl,"리뷰 수정",popOption);
		 });
		
		/* 댓글(리뷰) 동적 생성 메서드 */
		function makeReplyContent(obj){
			if(obj.list.length === 0){
				$(".reply_not_div").html('<span>리뷰가 없습니다.</span>');
				$(".reply_content_ul").html('');
				$(".pageMaker").html('');
			} else{
				
				$(".reply_not_div").html('');
				
				const list = obj.list;
				const pf = obj.pageInfo;
				const userId = '${member.memberId}';		
				
				/* list */
				
				let reply_list = '';			
				
				$(list).each(function(i,obj){
					reply_list += '<li>';
					reply_list += '<div class="comment_wrap">';
					reply_list += '<div class="reply_top">';
					/* 아이디 */
					reply_list += '<span class="id_span">'+ obj.memberId+'</span>';
					/* 날짜 */
					reply_list += '<span class="date_span">'+ obj.regDate +'</span>';
					/* 평점 */
					reply_list += '<span class="rating_span">평점 : <span class="rating_value_span">'+ obj.rating +'</span>점</span>';
					if(obj.memberId === userId){
						reply_list += '<a class="update_reply_btn" href="'+ obj.replyId +'">수정</a><a class="delete_reply_btn" href="'+ obj.replyId +'">삭제</a>';
					}
					reply_list += '</div>'; //<div class="reply_top">
					reply_list += '<div class="reply_bottom">';
					reply_list += '<div class="reply_bottom_txt">'+ obj.content +'</div>';
					reply_list += '</div>';//<div class="reply_bottom">
					reply_list += '</div>';//<div class="comment_wrap">
					reply_list += '</li>';
				});		
				
				$(".reply_content_ul").html(reply_list);			
				
				/* 페이지 버튼 */
				
				let reply_pageMaker = '';	
				
					/* prev */
					if(pf.prev){
						let prev_num = pf.pageStart -1;
						reply_pageMaker += '<li class="pageMaker_btn prev">';
						reply_pageMaker += '<a href="'+ prev_num +'">이전</a>';
						reply_pageMaker += '</li>';	
					}
					/* numbre btn */
					for(let i = pf.pageStart; i < pf.pageEnd+1; i++){
						reply_pageMaker += '<li class="pageMaker_btn ';
						if(pf.cri.pageNum === i){
							reply_pageMaker += 'active';
						}
						reply_pageMaker += '">';
						reply_pageMaker += '<a href="'+i+'">'+i+'</a>';
						reply_pageMaker += '</li>';
					}
					/* next */
					if(pf.next){
						let next_num = pf.pageEnd +1;
						reply_pageMaker += '<li class="pageMaker_btn next">';
						reply_pageMaker += '<a href="'+ next_num +'">다음</a>';
						reply_pageMaker += '</li>';	
					}	
					
				$(".pageMaker").html(reply_pageMaker);				
				
			}
		}
		/* 리뷰 삭제 버튼 */
		 $(document).on('click', '.delete_reply_btn', function(e){

			e.preventDefault();
			let replyId = $(this).attr("href");	
			
			$.ajax({
				data : {
					replyId : replyId,
					clothesId : '${goodsInfo.clothesId}'
				},
				url : '/reply/delete',
				type : 'POST',
				success : function(result){
					replyListInit();
					alert('삭제가 완료되엇습니다.');
				}
			});		
				
		 });

		

	</script>
</body>
</html>

