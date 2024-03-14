package com.home.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.ClothesVO;
import com.home.model.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTest {

	@Autowired
	private AdminMapper mapper;

	/*
	 * 상품 등록
	 * 
	 * @Test public void ClothesnrollTest() throws Exception{
	 * 
	 * ClothesVO clothes = new ClothesVO();
	 * 
	 * clothes.setClothesName("mapper 테스트2"); clothes.setCateCode("02312");
	 * clothes.setClothesPrice(20000); clothes.setClothesStock(300);
	 * clothes.setClothesDiscount(0.23); clothes.setClothesIntro("의류 소개2");
	 * 
	 * mapper.clothesEnroll(clothes); }
	 */

	/* 카테고리 리스트 */
	/*
	 * @Test public void cateListTest() throws Exception{
	 * System.out.println("cateList()......." + mapper.cateList()); }
	 */

	/* 상품 리스트 & 상품 총 갯수 */
	/*
	 * @Test public void goodsGetListTest() {
	 * 
	 * Criteria cri = new Criteria();
	 * 
	 * 
	 * 상품 총 갯수 int result = mapper.goodsGetTotal(cri);
	 * System.out.println("resutl..........:" + result);
	 * 
	 * 
	 * }
	 */
	/* 상품 조회 페이지 */
	/*
	 * @Test public void goodsGetDetailTest() {
	 * 
	 * int clothesId = 150;
	 * 
	 * ClothesVO result = mapper.goodsGetDetail(clothesId);
	 * 
	 * System.out.println("상품 조회 데이터 : " + result);
	 * 
	 * 
	 * }
	 */
	/* 상품 정보 수정 */
	/*
	 * @Test public void goodsModifyTest() {
	 * 
	 * ClothesVO clothes = new ClothesVO();
	 * 
	 * clothes.setClothesId(95); clothes.setClothesName("mapper 테스트");
	 * clothes.setCateCode("103002"); clothes.setClothesPrice(20000);
	 * clothes.setClothesStock(300); clothes.setClothesDiscount(0.23);
	 * clothes.setClothesIntro("의류 소개 "); mapper.goodsModify(clothes);
	 * 
	 * }
	 */
	
	/* 상품 삭제 */
	@Test
	public void goodsDeleteTest() {
		
		int clothesId = 155;
		
		int result = mapper.goodsDelete(clothesId);
		
		if(result == 1) {
			System.out.println("삭제성공");
		}
		
	}
}
