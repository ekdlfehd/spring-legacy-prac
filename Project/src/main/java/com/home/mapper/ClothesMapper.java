package com.home.mapper;

import java.util.List;

import com.home.model.ClothesVO;
import com.home.model.Criteria;

public interface ClothesMapper {
	/* 상품검색 */
	public List<ClothesVO> getGoodsList(Criteria cri);
	
	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);
	
	/* 의류 이름 리스트*/
	public String[] getClothesNameList(String keyword);
	

}
