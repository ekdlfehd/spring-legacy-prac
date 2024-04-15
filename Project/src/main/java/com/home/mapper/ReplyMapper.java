package com.home.mapper;

import com.home.model.ReplyDTO;

public interface ReplyMapper {
	
	/* 댓글 등록 */
	public int enrollReply(ReplyDTO dto);
}
