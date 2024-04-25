package com.home.service;

import java.util.List;

import com.home.model.OrderDTO;
import com.home.model.OrderPageItemDTO;

public interface OrderService {
	/* 주문 정보 */
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders);
	
	/* 주문 */
	public void  order(OrderDTO orw);
}
