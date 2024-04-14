package com.home.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.AttachImageVO;
import com.home.model.ClothesVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminServicerTest {
	
	@Autowired
	private AdminService service;
	
	/* 상품 등록 & 상품 이미지 등록 테스트 */
	@Test
	public void clothesEnrollTEsts() {
		ClothesVO clothes = new ClothesVO();

		// 상품명 설정
		clothes.setClothesName("테스트 상품");

		// 카테고리 코드 설정
		clothes.setCateCode("101001");

		// 할인율 설정 (예: 10% 할인)
		clothes.setClothesDiscount(05);

		// 상품 소개 설정
		clothes.setClothesIntro("이 상품은 테스트 상품입니다.");

		// 상품 가격 설정
		clothes.setClothesPrice(50000); // 50,000원

		// 상품 재고 설정
		clothes.setClothesStock(100); // 100개
		
		// 이미지 정보
		List<AttachImageVO> imageList = new ArrayList<AttachImageVO>(); 
		
		AttachImageVO image1 = new AttachImageVO();
		AttachImageVO image2 = new AttachImageVO();
		
		image1.setFileName("121");
		image1.setUploadPath("121");
		image1.setUuid("12");
		
		image2.setFileName("12");
		image2.setUploadPath("12");
		image2.setUuid("12");
		
		imageList.add(image1);
		imageList.add(image2);
		
		clothes.setImageList(imageList);        
		
		// clothesEnroll() 메서드 호출
		service.clothesEnroll(clothes);
		
		System.out.println("등록된 VO : " + clothes);
		
		
	}
}
	

