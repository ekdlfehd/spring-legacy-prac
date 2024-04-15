package com.home.model;

import java.sql.Date;

public class ReplyDTO {

	private int replyId;
	
	private int clothesId;
	
	private String memberId;

	private Date regDate;
	
	private String content;
	
	private double rating;

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}



	public int getClothesId() {
		return clothesId;
	}

	public void setClothesId(int clothesId) {
		this.clothesId = clothesId;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "ReplyDTO [replyId=" + replyId + ", clothesId=" + clothesId + ", memberId=" + memberId + ", regDate="
				+ regDate + ", content=" + content + ", rating=" + rating + "]";
	}


	
}
