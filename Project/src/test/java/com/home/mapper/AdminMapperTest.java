package com.home.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.AttachImageVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AdminMapperTest {

    @Autowired
    private AdminMapper mapper;

//    @Test
//    public void ClothesnrollTest() throws Exception {
//
//        ClothesVO clothes = new ClothesVO();
//
//        clothes.setClothesName("mapper 테스트2");
//        clothes.setCateCode("101001");
//        clothes.setClothesPrice(20000);
//        clothes.setClothesStock(300);
//        clothes.setClothesDiscount(0.23);
//        clothes.setClothesIntro("의류 소개2");
//        System.out.println("Before ClothesVO :" + clothes);
//
//        mapper.clothesEnroll(clothes);
//        System.out.println("After ClothesVO :" + clothes);
//    }

//    @Test
//    public void cateListTest() throws Exception {
//        System.out.println("cateList()......." + mapper.cateList());
//    }
//
//    @Test
//    public void goodsGetListTest() {
//
//        Criteria cri = new Criteria();
//
//        int result = mapper.goodsGetTotal(cri);
//        System.out.println("resutl..........:" + result);
//
//    }
//
//    @Test
//    public void goodsGetDetailTest() {
//
//        int clothesId = 150;
//
//        ClothesVO result = mapper.goodsGetDetail(clothesId);
//
//        System.out.println("상품 조회 데이터 : " + result);
//
//    }
//
//    @Test
//    public void goodsModifyTest() {
//
//        ClothesVO clothes = new ClothesVO();
//
//        clothes.setClothesId(95);
//        clothes.setClothesName("mapper 테스트");
//        clothes.setCateCode("103002");
//        clothes.setClothesPrice(20000);
//        clothes.setClothesStock(300);
//        clothes.setClothesDiscount(0.23);
//        clothes.setClothesIntro("의류 소개 ");
//        mapper.goodsModify(clothes);
//
//    }
//
//    @Test
//    public void goodsDeleteTest() {
//
//        int clothesId = 155;
//
//        int result = mapper.goodsDelete(clothesId);
//
//        if (result == 1) {
//            System.out.println("삭제성공");
//        }
//
//    }
//
//    @Test
//    public void imageEnrollTest() {
//
//        AttachImageVO vo = new AttachImageVO();
//
//        vo.setClothesId(133);
//        vo.setFileName("test112341234132412341");
//        vo.setUploadPath("test11234123412341234");
//        vo.setUuid("test211234123412341235");
//
//        mapper.imageEnroll(vo);
//
//    }
    /* 지정 상품 이미지 정보 얻기 */
	@Test
	public void getAttachInfoTest() {
		
		int clothesId = 598;
		
		List<AttachImageVO> list = mapper.getAttachInfo(clothesId);
		
		System.out.println("list : " + list);
		
	}
}
