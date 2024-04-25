package com.home.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.home.model.OrderPageDTO;
import com.home.service.MemberService;
import com.home.service.OrderService;

import util.Common;

@Controller
public class OrderController {
	@Autowired
	private OrderService orderService;
	@Autowired
	private MemberService memberService;
		
	
	@GetMapping("/order/{memberId}")
	public String orderPgaeGET(@PathVariable("memberId") String memberId, OrderPageDTO opd, Model model) {
		model.addAttribute("orderList", orderService.getGoodsInfo(opd.getOrders()));
		model.addAttribute("memberInfo", memberService.getMemberInfo(memberId));
		
		return Common.VIEW_PATH+ "order.jsp";
	}

}
