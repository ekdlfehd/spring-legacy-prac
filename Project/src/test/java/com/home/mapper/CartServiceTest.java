package com.home.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.CartDTO;
import com.home.service.CartService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CartServiceTest {
	@Autowired
	private CartService cartService;
	
	//등록 테스트
//		@Test
//		public void addCartTest() {
//			//given
//				String memberId = "adminCk2";
//				int clothesId = 622;
//				int count = 5;
//				
//				CartDTO dto = new CartDTO(); 
//				dto.setMemberId(memberId);
//				dto.setClothesId(clothesId);
//				dto.setClothesCount(count);
//			
//			//when
//				int result = cartService.addCart(dto);
//			
//			//then
//				System.out.println("** result : " + result);
//			
//			
//		}
	
//	public List<CartDTO> getCartList(String memberId);
	/* 장바구니 정보 리스트 */
	@Test
	public void getCartListTest() {
	    String memberId = "adminCk2";


	    CartDTO dto = new CartDTO();
	    dto.setMemberId(memberId);

	    List<CartDTO> result = cartService.getCartList(memberId);
	    System.out.println(result);
	}

	

}
