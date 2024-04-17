package com.home.trade;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.model.CartDTO;
import com.home.model.MemberVO;
import com.home.service.CartService;

import util.Common;

@Controller
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	/* 장바구니 요청 */
	@PostMapping("/cart/add")
	@ResponseBody
	public String addCartPOST(CartDTO cart, HttpServletRequest request) {
		// 로그인 체크
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		if(mvo == null) {
			return "5";
		}
		
		// 카트 등록
		
		int result = cartService.addCart(cart);
		
		return result + "";
	}
	
	@GetMapping("/cart/{memberId}")
	public String cartPageGET(@PathVariable("memberId") String memberId, Model model) {
		List<CartDTO> cartInfo = cartService.getCartList(memberId);
		model.addAttribute("cartInfo", cartInfo);
		//model.addAttribute("cartInfo", cartService.getCartList(memberId));
	    return Common.VIEW_PATH +"cart.jsp";
	}

}
