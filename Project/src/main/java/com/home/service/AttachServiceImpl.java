package com.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mapper.AttachMapper;
import com.home.model.AttachImageVO;

@Service
public class AttachServiceImpl  implements AttachService {
	@Autowired
	private AttachMapper attachMapper;
	
	/* 이미지 정보 반환 */
	@Override
	public List<AttachImageVO> getAttachList(int clothesId){
		
		return attachMapper.getAttachList(clothesId);
	}
}
