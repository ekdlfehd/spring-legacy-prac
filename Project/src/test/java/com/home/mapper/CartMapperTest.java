package com.home.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.CartDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class CartMapperTest {
	
	@Autowired
	private CartMapper cartMapper;
//	@Test
//	public void addCart() {
//		String memberId = "a123512341235";
//		int clothesId = 622;
//		int count = 1;
//		
//		CartDTO cart = new CartDTO();
//		cart.setMemberId(memberId);
//		cart.setCartId(clothesId);
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
//		int cartId = 1;
//		
//		cartMapper.deleteCart(cartId);
//	}
//	
	/* 카트 수량 수정 */

//	@Test
//	public void modifyCartTest() {
//		int cartId = 17;
//		int count = 5;
//		
//		CartDTO cart = new CartDTO();
//		cart.setCartId(cartId);
//		cart.setClothesCount(count);
//		
//		cartMapper.modifyCount(cart);
//		
//	}
 
	
	/* 카트 목록 */ 

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
			
	/* 카트 확인 */
//
//	@Test
//	public void checkCartTest() {
//		
//		String memberId = "adminCk2";
//		int clothesId = 6232;
//		
//		CartDTO cart = new CartDTO();
//		cart.setMemberId(memberId);
//		cart.setClothesId(clothesId);
//		
//		CartDTO resutlCart = cartMapper.checkCart(cart);
//		System.out.println("결과 : " + resutlCart);
//		
//	}
//	

}
