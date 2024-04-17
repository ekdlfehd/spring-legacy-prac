<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"/>
    <script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
    <script src = "https://code.jquery.com/jquery-3.6.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<body>
	<main class="front">
		<header class = "home_header">
			<div class = "product_details_header">
				<a href = "" class = "sprite arrow_left go_back">go back</a>
				<h2>Outerwear</h2>
			</div>
			<div class = "top_links">
				<a href = "/cart/${member.memberId}" class = "sprite cart" data-cart-count= "0">cart</a>
			</div>
		</header>
		
		<div class = "home_content">
			<div class = "search sm_padding">
				<form action = >
					<label for = "search" class = "sprite search_icon">search</label>
					<input type = "text" id = "search" placeholder = "Search...">
				</form>
				<div class = "sprite barcode">Open barcode</div>
			</div>
			<div class = "product_details sm_padding">
				<div class = "top_info">
					<div class = "product_img">
						<div class = "product_img_top">
							<img src= "resources/img/outerwear_bic_01.jpg" alt = "outerwear">
							<div class = "buttons">
								<form action = "">
									<button><i class ="sprite wishlist">like</i></button>
								</form>
								<span><i class ="sprite share">share</i></span>
							</div>
						</div>
						<div class = "product_img_bottom">
							<div class = "titles">
								<h3>Kimono</h3>
								<h4>$89.00</h4>
							</div>
							<form action = "">
								<button class = "btn default">Add to Cart</button>
							</form>
						</div>
					</div>
					<hr>
					<div class = "product_thumb">
						<div class="product_thumb_container">
	 	 	    			<ul class = "product_thumb_slides swiper-wrapper">
	 	 	    				<li class = "swiper-slide"><img  src="resources/img/outerwear_sm_01.jpg" alt="outerwear_sm_01"></li>
	 	 	    				<li class = "swiper-slide"><img  src="resources/img/outerwear_sm_02.jpg" alt="outerwear_sm_02"></li>
	 	 	    				<li class = "swiper-slide"><img  src="resources/img/outerwear_sm_03.jpg" alt="outerwear_sm_03"></li>
	 	 	    			</ul>
	 	 	    		</div>
					</div>
				</div>
				<div class = "description">
					<h3 class = "product_detail_tt">DESCRIPTION</h3>
					<div class = "desc_content">
						<p>Kimono with lapel collar, long sleeves, slit in the back at the hem and matching belt.</p>
						<p><span class ="uppercase">HEIGHT OF MODEL: </span>178 cm. / 5′ 10″</p>
					</div>
				</div>
				<div class = "people_like">
					<h3 class = "product_detail_tt">PEOPLE LIKE</h3>
					<div class = "like_content">
						<ul>
							<li><img src="resources/img/like_people_01.png" alt="like_people_01" ></li>
							<li><img src="resources/img/like_people_02.png" alt="like_people_02" ></li>
							<li><img src="resources/img/like_people_03.png" alt="like_people_03" ></li>
							<li><img src="resources/img/like_people_04.png" alt="like_people_04" ></li>
							<li class = "total_like">+32</li>
						</ul>
					</div>
				</div>
				<div class = "wear_with">
					<h3 class = "product_detail_tt">WEAR WITH</h3>
					<div class = "wear_content">
						<ul>
							<li>
								<img src="resources/img/wear_with_01.jpg" alt="wear_with_01">
								<h4>RIBBED MIDI SKIRT</h4>
								<h5>$ 45.00</h5>
							</li>
							<li>
								<img src="resources/img/wear_with_02.jpg" alt="wear_with_02">
								<h4>HEEL ANKLE BOOTS</h4>
								<h5>$ 99.00</h5>
							</li>
							<li>
								<img src="resources/img/wear_with_03.jpg" alt="wear_with_03">
								<h4>EMBOSSED CITY BAG</h4>
								<h5>$ 289.00</h5>
							</li>
						</ul>
					</div>
				</div>
				<div class = "review">
					<div class = "review_header">
						<h3 class = "product_detail_tt">REVIEW</h3>
						<a href = "">See All Review</a>
					</div>
					<div class = "review_content">
						<ul>
							<li>
								<img src="resources/img/reviewer_thumb_01.png" alt="reviewer_thumb_01">
								<div class = "review_list_content">
									<div class = "review_list_content_header">
										<div class = "reivew_content_header_tt">
											<h4>Ellen McLaughlin</h4>
											<div class = "rating" data-rate = "5">
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
											</div>
										</div>
										<div class = "time">
											2 hours ago
										</div>
									</div>
									<div class = "review_list_content_body">
										<p>So we needed up ordering the deep fried salmon roll with Chinese hot mustard and wasabi noodles with salmon.</p>
									</div>
								</div>
							</li>
							<li>
								<img src="resources/img/reviewer_thumb_02.png" alt="reviewer_thumb_02">
								<div class = "review_list_content">
									<div class = "review_list_content_header">
										<div class = "reivew_content_header_tt">
											<h4>Vincent King</h4>
											<div class = "rating" data-rate = "3">
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
											</div>
										</div>
										<div class = "time">
											3 hours ago
										</div>
									</div>
									<div class = "review_list_content_body">
										<p>We been there yesterday for dinner,ordered tandoori lobster and mutton galouti and few mains and biryani.</p>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</main>
	
    <!-- 상세페이지 상품슬라이드 -->
    <script>
    if($('.product_thumb_slides').length){
    
    	var swiper = new Swiper('.product_thumb_container', {
       		slidesPerView: 2.5,
        	spaceBetween: 13,
     	 });
    
    	/* 이미지 변경하기  */
    	var thumbImg = $('.product_thumb_slides li img');
    	var targetImg = $('.product_img_top img');
    
    	thumbImg.click(function(){
    		var targetImgUrl = $(this).attr('src');
    		targetImg.attr('src',targetImgUrl);
   		 });
    }
    </script>
    <script>
    /* 상세페이지 별점표시 */
    if($('.review_content').length){
    	var rating = $('.review_content li .rating');
    	rating.each(function(){
			var starscore = $(this).attr('data-rate');
			$(this).find('i:nth-child(-n+' + starscore + ')').css({color:'#f05522'});
		});    	
    }
    </script>
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
    </script>
	
</body>
</html>
