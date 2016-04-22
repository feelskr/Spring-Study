package com.oraclejava.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraclejava.restaurant.dto.Review;
import com.oraclejava.restaurant.mapper.ReviewMapper;
import com.oraclejava.restaurant.service.ReviewService;


@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {
	
	@Autowired
	private ReviewMapper reviewMapper;
			
	//리뷰내용
	@Override
	public Review GetReviewById(int review_id) {
		return reviewMapper.GetReviewById(review_id);
	}

	@Override
	public List<Review> GetReviewList(int rid) {
		return reviewMapper.GetReviewList(rid);
	}

	@Override
	public void CreateReview(Review review) {
		reviewMapper.CreateReview(review);		
	}

	@Override
	public void DeleteReview(int reviewId, String uid) {
		reviewMapper.DeleteReview(reviewId, uid);
	}

	@Override
	public Double GetAverageById(int rid) {
		return reviewMapper.GetAverageById(rid);
	}

}
