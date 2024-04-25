package com.home.mapper;

import com.home.model.CartDTO;
import com.home.model.ClothesVO;
import com.home.model.MemberVO;
import com.home.model.OrderDTO;
import com.home.model.OrderItemDTO;
import com.home.model.OrderPageItemDTO;

public interface OrderMapper {
	/* 주문 상품 정보 */	
	public OrderPageItemDTO getGoodsInfo(int clothesId);
	/* 주문 상품 정보(주문 처리) */	
	public OrderItemDTO getOrderInfo(int clothesId);
	/* 고객 주문정보 테이블 등록 */
	public int enrollOrder(OrderDTO ord);
	/* 주문된 아이템 테이블 등록 */
	public int enrollOrderItem(OrderItemDTO orid);
	/* 주문 금액 차감 */
	public int deductMoney(MemberVO member);
	/* 주문 재고 차감 */
	public int deductStock(ClothesVO clothes);
	/* 카트 제거(주문) */
	public int deleteOrderCart(CartDTO dto);
}
