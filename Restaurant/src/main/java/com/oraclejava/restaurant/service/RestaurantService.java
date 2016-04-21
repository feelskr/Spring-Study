package com.oraclejava.restaurant.service;

import java.util.List;

import com.oraclejava.restaurant.dto.Restaurant;

public interface RestaurantService {
	// 리스트
	public List<Restaurant> GetRestaurantList(int page, int pageCount);
	
	//상세
	public Restaurant GetRestaurantById(int id);
	
	// 갯수
	public int GetCount();

	// 등록
	public void InsertRest(Restaurant restaurant);

	// 수정
	public void UpdateRest(Restaurant restaurant);

	// 삭제
	public void DeleteRest(int restaurantId);
}
