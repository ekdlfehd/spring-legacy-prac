package com.home.trade;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.home.model.MemberVO;
import com.home.service.MemberService;

import util.Common;

@Controller
public class TradeController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	private MemberService memberservice;
	
	@Autowired
    private BCryptPasswordEncoder pwEncoder;

	// 메인홈페이지 이동
	@RequestMapping(value = { "/", "main_list2.do" })
	public String main() {
		return Common.VIEW_PATH + "main_list2.jsp";
	}

	// 로그인페이지로 이동
	@RequestMapping("login.do")
	public String login_page() {
		return Common.VIEW_PATH + "login.jsp";
	}
	
	// 로그인후 홈페이지로 이동
	@RequestMapping("home.do")
	public String home_page() {
		return Common.VIEW_PATH + "home.jsp";
	}

	// 회원가입페이지로 이동
	@RequestMapping("signup.do")
	public String signup_page() {
		return Common.VIEW_PATH + "signup.jsp";
	}
	
	// 상품정보페이지 이동
	@RequestMapping("detail1_list.do")
	public String detail1_list() {
		return Common.VIEW_PATH + "detail1.jsp";
	}

	// 장바구니페이지 이동
	@RequestMapping("cart_list.do")
	public String cart_list() {
		return Common.VIEW_PATH + "cart.jsp";
	}

	// 체크아웃 페이지로 이동
	@RequestMapping("check_out.do")
	public String check_out() {
		return Common.VIEW_PATH + "check_out.jsp";
	}
	
	
	
	

	// 회원가입
	@RequestMapping("signup_insert.do")
	public String insert(MemberVO member) throws Exception {
		String rawPw = "";            // 인코딩 전 비밀번호
        String encodePw = "";        // 인코딩 후 비밀번호
        
        rawPw = member.getMemberPw();            // 비밀번호 데이터 얻음
        encodePw = pwEncoder.encode(rawPw);        // 비밀번호 인코딩"redirect:login.jsp"
        member.setMemberPw(encodePw);            // 인코딩된 비밀번호 member객체에 다시 저장
		
        /* 회원가입 쿼리 실행 */
        memberservice.memberJoin(member);
        
		return "redirect:main_list2.do";
	}

	
	
	
	
	
	// 회원 로그인
	@RequestMapping("login_start.do")
	public String login(HttpServletRequest request, MemberVO member, RedirectAttributes rttr) throws Exception {

        HttpSession session = request.getSession();
        String rawPw = "";
        String encodePw = "";
    
        MemberVO lvo = memberservice.memberLogin(member);    // 제출한아이디와 일치하는 아이디 있는지 
        
        if(lvo != null) {            // 일치하는 아이디 존재시
            
            rawPw = member.getMemberPw();        // 사용자가 제출한 비밀번호
            encodePw = lvo.getMemberPw();        // 데이터베이스에 저장한 인코딩된 비밀번호
            
            if(true == pwEncoder.matches(rawPw, encodePw)) {        // 비밀번호 일치여부 판단
                
                lvo.setMemberPw("");                    // 인코딩된 비밀번호 정보 지움
                session.setAttribute("member", lvo);     // session에 사용자의 정보 저장
                return "redirect:home.do";        // 메인페이지 이동
                
                
            } else {
 
                rttr.addFlashAttribute("result", 0);            
                return "redirect:login.do";    // 로그인 페이지로 이동
                
            }
            
        } else {                    // 일치하는 아이디가 존재하지 않을 시 (로그인 실패)
            
            rttr.addFlashAttribute("result", 0);            
            return "redirect:login.do";    // 로그인 페이지로 이동
            
        }
		
	}
	
	
	// 홈페이지 로그아웃
	@RequestMapping(value = "logout.do",method = RequestMethod.GET)
	public String logoutMainGET(HttpServletRequest request)throws Exception{
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		return "redirect:main_list2.do";
	}
	
	
	// 아이디 중복검사
	@RequestMapping(value = "/memberIdChk", method = RequestMethod.POST)
	@ResponseBody public String memberIdChk(String memberId) throws Exception{
	int result = memberservice.idCheck(memberId);
	  
	if(result != 0) { return "fail"; 
		}else
    { return "success"; }
	  	}
	  
	  
	@GetMapping("/display")
	public ResponseEntity<byte[]> getImage(String fileName){
		
		File file = new File("c:\\upload\\" + fileName);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			
			HttpHeaders header = new HttpHeaders();
			
			header.add("Content-type", Files.probeContentType(file.toPath()));
			
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), header, HttpStatus.OK);
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
		
		
	}
}
