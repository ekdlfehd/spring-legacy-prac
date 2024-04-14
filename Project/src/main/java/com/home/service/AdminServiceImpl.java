package com.home.service;

import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.home.mapper.AdminMapper;
import com.home.model.AttachImageVO;
import com.home.model.CateVO;
import com.home.model.ClothesVO;
import com.home.model.Criteria;



@Service
public class AdminServiceImpl implements AdminService { 
	
	@Autowired
	private AdminMapper adminMapper;
	
	/* 상품 등록 */
	@Override
	public void clothesEnroll(final ClothesVO clothes) {
		
		adminMapper.clothesEnroll(clothes);
		
		if(clothes.getImageList() == null || clothes.getImageList().size() <= 0) {
			return;
			}
		clothes.getImageList().forEach(new Consumer<AttachImageVO>() {
			@Override
			public void accept(AttachImageVO attach) {
				
				attach.setClothesId(clothes.getClothesId());
				adminMapper.imageEnroll(attach);
				
			}
		});

		
	}
	// 카테고리 리스트
	@Override
	public List<CateVO> cateList() {
		return adminMapper.cateList();
	}
	
	// 상품리스트
	@Override
	public List<ClothesVO> goodsGetList(Criteria cri) {
		
		return adminMapper.goodsGetList(cri);
	}
	
	
	// 상품 총 갯수
	@Override
	public int goodsGetTotal(Criteria cri) {
		
		return adminMapper.goodsGetTotal(cri);
	}
	
	// 상품 조회
	@Override
	public ClothesVO goodsGetDetail(int clothesId) {

		return adminMapper.goodsGetDetail(clothesId);
	}
	
	// 상품 수정
	@Override
	public int goodsModify(ClothesVO vo) {
		
		return adminMapper.goodsModify(vo);
	}
	
	// 상품 삭제
	@Override
	@Transactional
	public int goodsDelete(int clothesId) {
		adminMapper.deleteImageAll(clothesId);
		return adminMapper.goodsDelete(clothesId);
	}
	
	
	/* 지정 상품 이미지 정보 얻기 */
	@Override
	public List<AttachImageVO> getAttachInfo(int clothesId) {
		
		return adminMapper.getAttachInfo(clothesId);
	}

	@Override
	public int deleteImageAll(int clothesId) {
		// TODO Auto-generated method stub
		return 0;
	}
}
