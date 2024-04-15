package com.home.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.home.model.ReplyDTO;
import com.home.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {
	
	@Autowired
	private ReplyService replyService;
	
	/* 댓글 등록 */
	@PostMapping("/enroll")
	public void enrollReplyPOST(ReplyDTO dto) {
		replyService.enrollReply(dto);
	}

}
