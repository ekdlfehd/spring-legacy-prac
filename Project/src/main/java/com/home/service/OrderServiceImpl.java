package com.home.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mapper.AttachMapper;
import com.home.mapper.OrderMapper;
import com.home.model.AttachImageVO;
import com.home.model.OrderPageItemDTO;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private AttachMapper attachMapper;
	
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
}
