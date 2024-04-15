package com.home.service;

import java.util.List;

import com.home.model.ClothesVO;
import com.home.model.Criteria;

public interface ClothesService {
	
	/* 상품검색 */
	public List<ClothesVO> getGoodsList(Criteria cri);
	/* 상품 총 갯수 */
	public int goodsGetTotal(Criteria cri);
	/* 상품 정보 */
	public ClothesVO getGoodsInfo(int clothesId);
	/* 상품 id 이름 */
	public ClothesVO getClothesIdName(int clothesId);
	
	
}
