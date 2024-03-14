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
	<main class="front cart-page">
		<header class = "home_header">
				<a href = "" class = "sprite close">close page</a>
				<h2 class = "heading5">My Cart</h2>
		</header>
		
		<div class = "home_content">
			<form action = "check_out.do">
				<div class = "cart_content">
					<h3><span>4 items</span> in your cart</h3>
					<ul class = "cart_list">
						<li>
							<img src= "resources/img/cart_item_01.jpg" alt="cart_item_01">
							<div class = "cart_list_info">
								<h4>LONG DRESS WITH SLITS</h4>
								<h5 class = "unit_price">$ 95.00</h5>
								<div class = "size">
									<label for = "size">Size</label>
									<select name = "size" id = "size">
										<option value = "XS">XS</option>
										<option value = "S">S</option>
										<option value = "M">M</option>
										<option value = "L">L</option>
										<option value = "XL">XL</option>
									</select>
								</div>
								<div class = "qty">
									<label for = "quantity">quantity</label>
									<input type = "number" min = "1" id = "quantity" value = "1">
								</div>
							</div>
							<span class = "sprite cart_item_del">Delete cart item</span>
						</li>
						<li>
							<img src= "resources/img/cart_item_02.jpg" alt="cart_item_02">
							<div class = "cart_list_info">
								<h4>LONG DRESS WITH SLITS</h4>
								<h5 class = "unit_price">$ 90.00</h5>
								<div class = "size">
									<label for = "size">Size</label>
									<select name = "size" id = "size">
										<option value = "XS">XS</option>
										<option value = "S">S</option>
										<option value = "M">M</option>
										<option value = "L">L</option>
										<option value = "XL">XL</option>
									</select>
								</div>
								<div class = "qty">
									<label for = "quantity">quantity</label>
									<input type = "number" min = "1" id = "quantity" value = "1">
								</div>
							</div>
							<span class = "sprite cart_item_del">Delete cart item</span>
						</li>
						<li>
							<img src= "resources/img/cart_item_03.jpg" alt="cart_item_03">
							<div class = "cart_list_info">
								<h4>LONG DRESS WITH SLITS</h4>
								<h5 class = "unit_price">$ 85.00</h5>
								<div class = "size">
									<label for = "size">Size</label>
									<select name = "size" id = "size">
										<option value = "XS">XS</option>
										<option value = "S">S</option>
										<option value = "M">M</option>
										<option value = "L">L</option>
										<option value = "XL">XL</option>
									</select>
								</div>
								<div class = "qty">
									<label for = "quantity">quantity</label>
									<input type = "number" min = "1" id = "quantity" value = "1">
								</div>
							</div>
							<span class = "sprite cart_item_del">Delete cart item</span>
						</li>
						<li>
							<img src= "resources/img/cart_item_04.jpg" alt="cart_item_04">
							<div class = "cart_list_info">
								<h4>LONG DRESS WITH SLITS</h4>
								<h5 class = "unit_price">$ 80.00</h5>
								<div class = "size">
									<label for = "size">Size</label>
									<select name = "size" id = "size">
										<option value = "XS">XS</option>
										<option value = "S">S</option>
										<option value = "M">M</option>
										<option value = "L">L</option>
										<option value = "XL">XL</option>
									</select>
								</div>
								<div class = "qty">
									<label for = "quantity">quantity</label>
									<input type = "number" min = "1" id = "quantity" value = "1">
								</div>
							</div>
							<span class = "sprite cart_item_del">Delete cart item</span>
						</li>
					</ul>
				</div>
				<div class = "cart_total">
					<div class = "shipping">
						<h6>Shipping cost</h6>
						<span class = "price">$ 59.00</span>
					</div>
					<div class = "total_price">
						<h6>TOTAL Price</h6>
						<span class = "price">$ 899.00</span>
					</div>
				</div>
				<button class = "btn big">check out</button>
			</form>
		</div>
	</main>
	
<script>
	if($('.cart_list').length){
		var cartList = $('.cart_list li');
		var targetTotal = $('.total_price .price');
		var shippingCost = parseInt($('.shipping .price').text().replace('$ ',''));
		var totalprice = 0;
		var itemDelBtn = cartList.find('.cart_item_del');
		
		// 열리자마자 합계 계산
		calTotal();
		
		// 수량이 바뀌면 계산
		$('.qty input').change(calTotal);
		
		// x눌르면 합계다시 계산
		itemDelBtn.click(function(){
			var userAction = confirm("정말로 지우시겠습니까?");
			if(userAction){
				$(this).parent().remove();
				calTotal();
			}
		});
		
		// 합계구하기 함수
		function calTotal(){
			
			cartList = $('.cart_list li');
			console.log(cartList.length);
			totalprice = 0;
			if(cartList.length > 0){
				cartList.each(function(){
					var unitPrice = parseInt($(this).find('.unit_price').text().replace('$ ',''));
					var unitCount = $(this).find('input').val();
					
					
					totalprice += unitPrice * unitCount;
					var subtotal = (totalprice + shippingCost).toLocaleString("en");
					var grandTotal = '$ ' + subtotal;

					targetTotal.text(grandTotal);
				});
			}else{
				targetTotal.text(0);
			}

		} //calTotal
		
	} // 장바구니 합계구하기 끝
	
	// 히스토리 뒤로가기
	$('.close').click(function(e){
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
