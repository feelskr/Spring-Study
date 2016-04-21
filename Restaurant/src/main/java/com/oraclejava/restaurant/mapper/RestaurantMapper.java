package com.oraclejava.restaurant.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.oraclejava.restaurant.dto.Restaurant;

public interface RestaurantMapper {
	
	//리스트
	public List<Restaurant> GetRestaurantList(@Param("startIdx") int startIdx, @Param("pageCount") int pageCount);

	public Restaurant GetRestaurantById(int id);
	//갯수
	public int GetCount();
	
	//등록
	public void InsertRest(Restaurant restaurant);

	//수정
	public void UpdateRest(Restaurant restaurant);

	//삭제
	public void DeleteRest(@Param("restaurantId") int restaurantId);
}
