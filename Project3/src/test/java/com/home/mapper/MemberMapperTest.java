package com.home.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.home.model.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MemberMapperTest {

	@Autowired
	private MemberMapper membermapper;			//MemberMapper.java 인터페이스 의존성 주입
	
	//회원가입 쿼리 테스트 메서드
	/*
	 * @Test public void memberJoin() throws Exception{ MemberVO member = new
	 * MemberVO();
	 * 
	 * member.setMemberId("test4"); //회원 id member.setMemberPw("test4"); //회원 비밀번호
	 * member.setMemberName("test4"); //회원 이름 member.setMemberMail("test4"); //회원 메일
	 * member.setMemberAddr1("test4"); //회원 우편번호 member.setMemberAddr2("test4");
	 * //회원 주소 member.setMemberAddr3("test4"); //회원 상세주소
	 * member.setMemberNumber("test4"); //회원 전화번호
	 * 
	 * membermapper.memberJoin(member); //쿼리 메서드 실행
	 * 
	 * }
	 */
	/*
	 * @Test public void memberIdChk() throws Exception{ String id = "admin"; String
	 * id2 = "soant"; membermapper.idCheck(id); membermapper.idCheck(id2); }
	 */
	
	// 로그인 쿼리 mapper 메서드 테스트
    /* 로그인 쿼리 mapper 메서드 테스트 */
    @Test
    public void memberLogin() throws Exception{
        
        MemberVO member = new MemberVO();    // MemberVO 변수 선언 및 초기화
        
        /* 올바른 아이디 비번 입력경우 */
        //member.setMemberId("soant");
       // member.setMemberPw("1234");
        
        /* 올바른 않은 아이디 비번 입력경우 */
        member.setMemberId("test1123");
        member.setMemberPw("test1321321");
        
        membermapper.memberLogin(member);
        System.out.println("결과 값 : " + membermapper.memberLogin(member));
        
    }
	
}