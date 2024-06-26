package com.home.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AttachMapperTest {
	@Autowired
	private AttachMapper attachmapper;
	
	/* 이미지 정보 반환*/
	@Test
	public void getAttachListTest() {
		int clothesId = 598;
		System.out.println("이미지정보 : " + attachmapper.getAttachList(clothesId));
	}
}
