package com.oraclejava.restaurant.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraclejava.restaurant.dto.Restaurant;
import com.oraclejava.restaurant.dto.Review;
import com.oraclejava.restaurant.mapper.RestaurantMapper;
import com.oraclejava.restaurant.mapper.ReviewMapper;
import com.oraclejava.restaurant.service.RestaurantService;

@Service("restaurantService")
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	private RestaurantMapper restaurantMapper;
	
	@Autowired
	private ReviewMapper reviewMapper;
	
	
	@Override
	public List<Restaurant> GetRestaurantList(int page, int pageCount) {
		if(page <= 0) page = 1;
		int startIdx = (page -1) * pageCount;
		return restaurantMapper.GetRestaurantList(startIdx, pageCount);
	}

	@Override
	public int GetCount() {
		return restaurantMapper.GetCount();
	}

	@Override
	public void InsertRest(Restaurant restaurant) {
		restaurantMapper.InsertRest(restaurant);
	}

	@Override
	public void UpdateRest(Restaurant restaurant) {
		restaurantMapper.UpdateRest(restaurant);
	}

	@Override
	public void DeleteRest(int restaurantId) {
		restaurantMapper.DeleteRest(restaurantId);
	}

	@Override
	public Restaurant GetRestaurantById(int id) {	
		return restaurantMapper.GetRestaurantById(id);
	}

}
