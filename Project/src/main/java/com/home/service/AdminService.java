package com.home.service;

import java.util.List;

import com.home.model.CateVO;
import com.home.model.ClothesVO;
import com.home.model.Criteria;

public interface AdminService {

	// 상품등록
	public void clothesEnroll(ClothesVO clothes);
	
	// 카테고리 리스트
	public List<CateVO> cateList();
	
	/* 상품 리스트 */
	public List<ClothesVO> goodsGetList(Criteria cri);
	
	/* 상품 총 개수 */
	public int goodsGetTotal(Criteria cri);	
	
	/* 상품 조회 페이지 */
	public ClothesVO goodsGetDetail(int clothesId);
	
	/* 상품 수정 */
	public int goodsModify(ClothesVO vo);
	
	/* 상품 삭제 */
	public int goodsDelete(int clothesId);
}
