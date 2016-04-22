package com.oraclejava.restaurant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oraclejava.restaurant.dto.Review;

public interface ReviewMapper {

	//리뷰 내용
	public Review GetReviewById(int review_id);

	//리뷰 목록
	public List<Review> GetReviewList(int rid);

	//리뷰작성
	public void CreateReview(Review review);

	//리뷰삭제
	public void DeleteReview(@Param("reviewId") int reviewId, @Param("uid") String uid);
	
	//평균 평점
	public Double GetAverageById(int rid);
}
