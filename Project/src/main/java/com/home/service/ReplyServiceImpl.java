package com.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mapper.ReplyMapper;
import com.home.model.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyMapper replyMapper;
	
	/* 댓글등록 */
	@Override
	public int enrollReply(ReplyDTO dto) {
		
		int result = replyMapper.enrollReply(dto);
		
		return result;
	}
}
