package com.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.mapper.ReplyMapper;
import com.home.model.Criteria;
import com.home.model.PageDTO;
import com.home.model.ReplyDTO;
import com.home.model.ReplyPageDTO;

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
	
	/* 댓글 존재 체크 */ 
	@Override
	public String checkReply(ReplyDTO dto) {
		
		Integer result = replyMapper.checkReply(dto);
		
		if(result == null) {
			return "0";
		} else {
			return "1";
		}
	}
	
	/* 댓글 페이징 */
	@Override
	public ReplyPageDTO replyList(Criteria cri) {
		ReplyPageDTO dto = new ReplyPageDTO();
		
		dto.setList(replyMapper.getReplyList(cri));
		dto.setPageInfo(new PageDTO(cri, replyMapper.getReplyTotal(cri.getClothesId())));
		
		return dto;
	}
	
	/* 댓글 수정 */
	@Override
	public int updateReply(ReplyDTO dto) {
			int result = replyMapper.updateReply(dto);
		return result;
	}
	
	/* 댓글 수정 원래글찾기*/
	@Override
	public ReplyDTO getUpdateReply(int replyId) {
		
		return replyMapper.getUpdateReply(replyId);
	}
	
	/* 댓글 삭제 */
	@Override
	public int deleteReply(ReplyDTO dto) {
		
		int result = replyMapper.deleteReply(dto.getReplyId()); 
		
		return result;
	} 
}
  