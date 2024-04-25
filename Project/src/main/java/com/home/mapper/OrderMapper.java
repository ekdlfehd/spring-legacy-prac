package com.home.mapper;

import com.home.model.OrderPageItemDTO;

public interface OrderMapper {
	/* 주문 상품 정보 */	
	public OrderPageItemDTO getGoodsInfo(int clothesId);
}
