package com.home.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.ClothesVO;
import com.home.service.ClothesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ClothesMapperTest {
	@Autowired
	private ClothesMapper clothesMapper;
	@Autowired
	private ClothesService clothesService;
	
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
	@Test
	public void getGoodsInfoTest() {
		
		int clothesId = 600;
		
		ClothesVO goodsInfo = clothesService.getGoodsInfo(clothesId);
		
		System.out.println("==결과==");
		System.out.println("전체 : " + goodsInfo);
		System.out.println("clothesId : " + goodsInfo.getClothesId() );
		System.out.println("이미지 정보 : " + goodsInfo.getImageList().isEmpty());
		
		
	}
}
