package com.home.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.CartDTO;
import com.home.service.ClothesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ClothesMapperTest {
	@Autowired
	private ClothesMapper clothesMapper;
	@Autowired
	private ClothesService clothesService;
	@Autowired
	private CartMapper cartMapper;
	
//	@Test
//	public void getGoodsListTest() {
//		
//		Criteria cri = new Criteria();
//		//테스트키워드
//		//cri.setKeyword("test");
//		System.out.println("cri : " + cri);
//		
//		List<ClothesVO> list = clothesMapper.getGoodsList(cri);
//		System.out.println("list : " +list);
//		
//		System.out.println("==========");
//		int goodsTotal = clothesMapper.goodsGetTotal(cri);
//		System.out.println("totla : " + goodsTotal);
//	}
//	@Test
//	public void getClothesName() {
//		String keyword = "테";
//		
//		String[] list = clothesMapper.getClothesNameList(keyword);
//		
//		System.out.println("결과 : " + list.toString());
//		
//		for(String id : list) {
//			System.out.println("개별 결과 : " + id);
//		}
//	}
	
	/* 검색 (동적 쿼리 적용) - 의류이름*/
//	@Test
//	public void getGoodsListTest1() {
//		Criteria cri = new Criteria();
//		String type = "";
//		String keyword = "사진";
//		String catecode = "";
//		
//		cri.setType(type);
//		cri.setKeyword(keyword);
//		cri.setCateCode(catecode);
//		
//		List<ClothesVO> list = clothesMapper.getGoodsList(cri);
//		
//		System.out.println("cri 의류 :" + cri);
//		System.out.println("list 의류: " + list);
//	}
	/* 검색 (동적 쿼리 적용) - 카테고리*/
//	@Test
//	public void getGoodsListTest2() {
//		Criteria cri = new Criteria();
//		String type = "C";
//		String keyword = "";
//		String catecode = "101001";
//		
//		cri.setType(type);
//		cri.setKeyword(keyword);
//		cri.setCateCode(catecode);
//		
//		List<ClothesVO> list = clothesMapper.getGoodsList(cri);
//		
//		System.out.println("cri 카테:" + cri);
//		System.out.println("list 카테: " + list);
//	}
	/* 검색 (동적 쿼리 적용) - 카테고리+의류이름 */
//	@Test
//	public void getGoodsListTest3() {
//		Criteria cri = new Criteria();
//		String type = "C";
//		String keyword = "사진";
//		String catecode = "후드티셔츠";
//		
//		cri.setType(type);
//		cri.setKeyword(keyword);
//		cri.setCateCode(catecode);
//		
//		List<ClothesVO> list = clothesMapper.getGoodsList(cri);
//		
//		System.out.println("cri 의류카테:" + cri);
//		System.out.println("list 의류카테: " + list);
//	}
	/* 상품 정보 */
//	@Test
//	public void getGoodsInfo() {
//		int clothesId = 624;
//		ClothesVO goodsInfo = clothesMapper.getGoodsInfo(clothesId);
//		System.out.println("===========================");
//		System.out.println(goodsInfo);
//		System.out.println("===========================");
//		
//	}
	/*상품 상세 정보*/
//	@Test
//	public void getGoodsInfoTest() {
//		
//		int clothesId = 600;
//		
//		ClothesVO goodsInfo = clothesService.getGoodsInfo(clothesId);
//		
//		System.out.println("==결과==");
//		System.out.println("전체 : " + goodsInfo);
//		System.out.println("clothesId : " + goodsInfo.getClothesId() );
//		System.out.println("이미지 정보 : " + goodsInfo.getImageList().isEmpty());
//		
//		
//	}
	/* 상품 정보 */
//	@Test
//	public void getGoodsInfo() {
//		int clothesId = 26;
//		ClothesVO goodsInfo = clothesMapper.getGoodsInfo(clothesId);
//		System.out.println("===========================");
//		System.out.println(goodsInfo);
//		System.out.println("===========================");
//		
//	}
	/*상품 상세 정보*/
//	@Test
//	public void addCart() {
//		String memberId = "adminCk";
//		int clothesId = 622;
//		int count = 2;
//		
//		CartDTO cart = new CartDTO();
//		cart.setMemberId(memberId);
//		cart.setClothesId(clothesId);
//		cart.setClothesCount(count);
//		
//		int result = 0;
//		result = cartMapper.addCart(cart);
//		 
//		System.out.println("결과 : " + result);
//		
//	}
	
	/* 카트 삭제 */

//	@Test
//	public void deleteCartTest() {
//		int cartId = 3;
//		
//		cartMapper.deleteCart(cartId);
//
//	
//
//	}
	/* 카트 수량 수정 */

//	@Test
//	public void modifyCartTest() {
//		int cartId = 6;
//		int count = 5;
//		
//		CartDTO cart = new CartDTO();
//		cart.setCartId(cartId);
//		cart.setClothesCount(count);
//		
//		cartMapper.modifyCount(cart);
//		
//	}
	@Test
	public void getCartTest() {
		String memberId = "adminCk";
		
		
		List<CartDTO> list = cartMapper.getCart(memberId);
		for(CartDTO cart : list) {
			System.out.println(cart);
			cart.initSaleTotal();
			System.out.println("init cart : " + cart);
		}
		
		
	
	}
}
