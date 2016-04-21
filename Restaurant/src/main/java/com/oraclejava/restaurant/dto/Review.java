package com.oraclejava.restaurant.dto;

import java.util.Date;

public class Review {

	//리뷰ID
	private int reviewId;
	//평점
	private int rate;
	//리뷰
	private String body;
	//리뷰 작성일
	private Date uDate;
	//레스토랑 아이디
	private int rid;
	//리뷰작성자 아이디
	private String uid;

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getuDate() {
		return uDate;
	}

	public void setuDate(Date uDate) {
		this.uDate = uDate;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
