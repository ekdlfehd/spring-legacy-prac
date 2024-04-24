<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>	
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<title></title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css" />
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.1.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.0/css/all.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>

<body>
	<main class="front cart-page">
		<header class="home_header">
			<a href="" class="sprite close">close page</a>
			<h2 class="heading5">My Cart</h2>
		</header>
		<div class="home_content">
			<form action="/cart/update" method="post" class="quantity_update_form">
				<input type="hidden" name="cartId" class="update_cartId">
				<input type="hidden" name="clothesCount" class="update_clothesCount">
				<input type="hidden" name="memberId" value="${member.memberId}">
				<div class="cart_content">
					<h3>
						<span>your cart</span>
					</h3>
					<ul class="cart_list">
						<c:forEach items="${cartInfo}" var="ci">
					
							<li class = "cart_info_td">
							<input type="checkbox" class="individual_cart_checkbox input_size_20" checked="checked">
							<input type="hidden" class="individual_clothesPrice_input" value="${ci.clothesPrice}">
							<input type="hidden" class="individual_salePrice_input" value="${ci.salePrice}">
							<input type="hidden" class="individual_clothesCount_input" value="${ci.clothesCount}">
							<input type="hidden" class="individual_totalPrice_input" value="${ci.salePrice * ci.clothesCount}">
							<input type="hidden" class="individual_point_input" value="${ci.point}">
							<input type="hidden" class="individual_totalPoint_input" value="${ci.totalPoint}">
							</li>
						
							<li>
								<div class="image_wrap2" data-clothesid="${ci.imageList[0].clothesId}" data-path="${ci.imageList[0].uploadPath}" data-uuid="${ci.imageList[0].uuid}" data-filename="${ci.imageList[0].fileName}">
									<img>
								</div>
								<div class="cart_list_info">
									<h4>${ci.clothesName}</h4>

									<h5 class="unit_price"><span class = "clothesprice_color1">정가 : <fmt:formatNumber value="${ci.clothesPrice}" pattern="#,### 원" /></span></h5>
									<h5 class="unit_price">판매가 :<span class = "clothesprice_color2"><fmt:formatNumber value="${ci.salePrice}" pattern="#,### 원" /></span><br></h5>
									<h5 class="unit_price">마일리지 (5%) :<span class = "clothesprice_color3"><fmt:formatNumber value="${ci.point}" pattern="#,###" />적립</span><br></h5>
									
									<div class="qty">
										<label for="quantity">수량</label> <input type="number"
											min="1" id="quantity" value="${ci.clothesCount}">
											<a class="quantity_modify_btn" data-cartId="${ci.cartId}">변경</a>
									</div>
									<div class="pri">
										<label for="quantity">합계</label> <fmt:formatNumber value="${ci.salePrice * ci.clothesCount}" pattern="#,### 원" />
									</div>
									
								</div>
								<button class="sprite cart_item_del" data-cartid="${ci.cartId}">Delete cart item</button>
							</li>
				
						</c:forEach>
					</ul>


				</div>
				<div class="cart_total">
					<div class="shipping">
						<h6>장바구니 합계</h6>
						<span class="totalPrice_span">$ 59.00</span>
					</div>
					<div class="shipping">
						<h6>총 주문수량</h6>
						<span class="totalCount_span">$ 59.00</span>
					</div>
					<div class="shipping">
						<h6>배송비</h6>
						<span class="delivery_price">3000</span>
					</div>
					<div class="total_price">
						<h6>총 결제 예상금액</h6>
						<span class="finalTotalPrice_span">$ 899.00</span>
					</div>
					<div class="total_price">
						<h6>총 적립 마일리지</h6>
						<span class="totalPoint_span">$ 899.00</span>
					</div>
				</div>
				<button class="btn big">check out</button>
			</form>
		</div>
		<!-- 삭제 form -->
			<form action="/cart/delete" method="post" class="quantity_delete_form">
				<input type="hidden" name="cartId" class="delete_cartId">
				<input type="hidden" name="memberId" value="${member.memberId}">
			</form>
	</main>

	<script>
	$(document).ready(function(){
	    setTotalInfo(); // 초기화할 때 매개변수 없이 호출
	    
	    /* 이미지 삽입 */
		$(".image_wrap2").each(function(i, obj){
			const bobj = $(obj);
			
			if(bobj.data("clothesid")){
				const uploadPath = bobj.data("path");
				const uuid = bobj.data("uuid");
				const fileName = bobj.data("filename");
				
				const fileCallPath = encodeURIComponent(uploadPath + "/" + uuid + "_" + fileName);
				
				$(this).find("img").attr('src', '/display?fileName=' + fileCallPath);
			} else {
				$(this).find("img").attr('src', '/resources/img/noimage.jpg');
			}
		});
	}); 

	/* 체크여부에 따른 종합 정보 변화 */
	$(".individual_cart_checkbox").on("change", function(){
	    /* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
	    setTotalInfo($(".cart_info_td"));
	}); 

	/* 총 주문 정보 세팅(배송비, 총 가격, 마일리지, 물품 수, 종류) */
function setTotalInfo(){
    let totalPrice = 0;
    let totalCount = 0;
    let totalPoint = 0;
    let deliveryPrice = 0;
    let finalTotalPrice = 0;

    // 각 제품 정보를 가진 요소에 접근하여 값 계산
    $(".cart_info_td").each(function(index, element){
        // 체크된 상품에 대해서만 정보를 고려
        if($(element).find(".individual_cart_checkbox").is(":checked")) {
            totalPrice += parseInt($(element).find(".individual_totalPrice_input").val());
            totalCount += parseInt($(element).find(".individual_clothesCount_input").val());
            totalPoint += parseInt($(element).find(".individual_totalPoint_input").val());
        }
    });

    // 배송비 계산
    if(totalPrice >= 30000){
        deliveryPrice = 0;
    } else if(totalPrice == 0){
        deliveryPrice = 0;
    } else {
        deliveryPrice = 3000;
    }

    // 최종 가격 계산
    finalTotalPrice = totalPrice + deliveryPrice;

    // 값 삽입
    $(".totalPrice_span").text(totalPrice.toLocaleString());
    $(".totalCount_span").text(totalCount);
    $(".totalPoint_span").text(totalPoint.toLocaleString());
    $(".delivery_price").text(deliveryPrice);    
    $(".finalTotalPrice_span").text(finalTotalPrice.toLocaleString());     
}

$(".quantity_modify_btn").on("click", function(){
    let cartId = $(this).data("cartid");
    let clothesCount = $(this).closest(".qty").find("input").val();
    $(".update_cartId").val(cartId);
    $(".update_clothesCount").val(clothesCount);
    $(".quantity_update_form").submit();
});

/* 장바구니 삭제 버튼 */
$(".cart_item_del").on("click", function(e){
	e.preventDefault();
	const cartId = $(this).data("cartid");
	$(".delete_cartId").val(cartId);
	$(".quantity_delete_form").submit();
});




// 히스토리 뒤로가기
$('.close').click(function(e) {
	e.preventDefault();
	if (window.history.length > 1) {
		window.history.go(-1);
	} else {
		location.href = "main_list2.do"
	}
});

</script>


</body>
</html>
