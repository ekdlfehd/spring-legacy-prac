package com.home.service;


import java.util.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.mapper.AttachMapper;
import com.home.mapper.CartMapper;
import com.home.mapper.ClothesMapper;
import com.home.mapper.MemberMapper;
import com.home.mapper.OrderMapper;
import com.home.model.AttachImageVO;
import com.home.model.CartDTO;
import com.home.model.ClothesVO;
import com.home.model.MemberVO;
import com.home.model.OrderDTO;
import com.home.model.OrderItemDTO;
import com.home.model.OrderPageItemDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private AttachMapper attachMapper;
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private CartMapper cartMapper;
	
	@Autowired
	private ClothesMapper clothesMapper;
	
	@Override
	public List<OrderPageItemDTO> getGoodsInfo(List<OrderPageItemDTO> orders) {
		
		List<OrderPageItemDTO> result = new ArrayList<OrderPageItemDTO>();
		
		for(OrderPageItemDTO ord : orders) {
			
			OrderPageItemDTO goodsInfo = orderMapper.getGoodsInfo(ord.getClothesId());
			goodsInfo.setClothesCount(ord.getClothesCount());
			goodsInfo.initSaleTotal();
			
			List<AttachImageVO> imageList = attachMapper.getAttachList(goodsInfo.getClothesId());
			
			goodsInfo.setImageList(imageList);
			result.add(goodsInfo);	
		}
		return result;
	}
	
	@Override
	@Transactional
	public void order(OrderDTO ord) {
		/* 사용할 데이터가져오기 */
		/* 회원 정보 */
		MemberVO member = memberMapper.getMemberInfo(ord.getMemberId());
		/* 주문 정보 */
		List<OrderItemDTO> ords = new ArrayList<>();
		for(OrderItemDTO oit : ord.getOrders()) {
			OrderItemDTO orderItem = orderMapper.getOrderInfo(oit.getClothesId());
			// 수량 셋팅
			orderItem.setClothesCount(oit.getClothesCount());
			// 기본정보 셋팅
			orderItem.initSaleTotal();
			//List객체 추가
			ords.add(orderItem);
		}
		/* OrderDTO 셋팅 */
		ord.setOrders(ords);
		ord.getOrderPriceInfo();
		
	/*DB 주문,주문상품(,배송정보) 넣기*/
		
		/* orderId만들기 및 OrderDTO객체 orderId에 저장 */
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("_yyyyMMddmm");
		String orderId = member.getMemberId() + format.format(date);
		ord.setOrderId(orderId);
		
		/* db넣기 */
		orderMapper.enrollOrder(ord);		//vam_order 등록
		for(OrderItemDTO oit : ord.getOrders()) {		//vam_orderItem 등록
			oit.setOrderId(orderId);
			orderMapper.enrollOrderItem(oit);			
		}

	/* 비용 포인트 변동 적용 */
		
		/* 비용 차감 & 변동 돈(money) Member객체 적용 */
		int calMoney = member.getMoney();
		calMoney -= ord.getOrderFinalSalePrice();
		member.setMoney(calMoney);
		
		/* 포인트 차감, 포인트 증가 & 변동 포인트(point) Member객체 적용 */
		int calPoint = member.getPoint();
		calPoint = calPoint - ord.getUsePoint() + ord.getOrderSavePoint();	// 기존 포인트 - 사용 포인트 + 획득 포인트
		member.setPoint(calPoint);
			
		/* 변동 돈, 포인트 DB 적용 */
		orderMapper.deductMoney(member);
		
	/* 재고 변동 적용 */
		for(OrderItemDTO oit : ord.getOrders()) {
			/* 변동 재고 값 구하기 */
			ClothesVO clothes = clothesMapper.getGoodsInfo(oit.getClothesId());
			clothes.setClothesStock(clothes.getClothesStock() - oit.getClothesCount());
			/* 변동 값 DB 적용 */
			orderMapper.deductStock(clothes);
		}			
		
	/* 장바구니 제거 */
		for(OrderItemDTO oit : ord.getOrders()) {
			CartDTO dto = new CartDTO();
			dto.setMemberId(ord.getMemberId());
			dto.setClothesId(oit.getClothesId());
			
			orderMapper.deleteOrderCart(dto);
		}
		
	}
}
