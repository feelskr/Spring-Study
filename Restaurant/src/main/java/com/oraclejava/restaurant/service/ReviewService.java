package com.oraclejava.restaurant.service;

import java.util.List;
import com.oraclejava.restaurant.dto.Review;

public interface ReviewService {
		
	//리뷰 내용
	public Review GetReviewById(int review_id);

	//리뷰 목록
	public List<Review> GetReviewList(int rid);

	//리뷰작성
	public void CreateReview(Review review);

	//리뷰삭제
	public void DeleteReview(int reviewId, String uid);
	
	//평균 평점
	public Double GetAverageById(int rid);
	
}
