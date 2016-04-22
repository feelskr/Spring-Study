package com.oraclejava.restaurant.web;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import com.oraclejava.restaurant.dto.Restaurant;
import com.oraclejava.restaurant.dto.Review;
import com.oraclejava.restaurant.service.RestaurantService;
import com.oraclejava.restaurant.service.ReviewService;

@Controller
@RequestMapping("/rest")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private ReviewService reviewService;	
	
	private int pageCount = 15;
	private final static int MAX_BUFFER_SIZE = 1024;
	
	@ModelAttribute("restaurant")
	public Restaurant initRestaurant() {
		Restaurant restaurant = new Restaurant();
		return restaurant;
	}
	
	@ModelAttribute("review")
	public Review initReview() {
		Review review = new Review();
		return review;
	}	

	@RequestMapping("/list")
	public String list(@RequestParam(value="page",  defaultValue = "1") Integer page, Model model) {
		int count = restaurantService.GetCount();
		List<Restaurant> list = restaurantService.GetRestaurantList(page, 5);
		int allPage = (int)Math.ceil((double)count/5);
		model.addAttribute("list", list);
		model.addAttribute("page", page);
		model.addAttribute("allpage", allPage);
		return "/rest/list";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam(value="id", required=true) Integer id) throws IOException {
		restaurantService.DeleteRest(id);
		return "redirect:/rest/list";
	}
	
	/*@RequestMapping(value="/update/{id}", method=RequestMethod.GET)
	public String upadte(Model model, @PathVariable int id) {
		//수정
		Restaurant restaurant =restaurantService.GetRestaurantById(id);
		model.addAttribute("restaurant", restaurant);	
		return "/rest/update";
	}
	
	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public ModelAndView upadte(@ModelAttribute("restaurant") Restaurant restaurant,
			@PathVariable int id,
			BindingResult result, MultipartFile imageFile)
					throws IOException {
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView();
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		if(!imageFile.getOriginalFilename().isEmpty() && !imageFile.isEmpty()) {
			File uploadFile = new File("D:\\Dev\\upload\\", imageFile.getOriginalFilename());
			restaurant.setImage(imageFile.getBytes());
			imageFile.transferTo(uploadFile);
		}
		
		restaurantService.UpdateRest(restaurant);
		ModelAndView mav = new ModelAndView("/rest/result");
		mav.addObject("restaurant", restaurant);
		mav.addObject("mode", "update");
		return mav;
	
	}*/
	
	@RequestMapping(value={"/regist", "/update"}, method=RequestMethod.GET)
	public String regist(@RequestParam(value="id", required=false) Integer id,
			Model model, HttpServletRequest req) {
		String uri = req.getRequestURI();
		if(uri.endsWith("regist")) {
			//등록
			Restaurant restaurant = initRestaurant();
			model.addAttribute("restaurant", restaurant);
			model.addAttribute("mode", "regist");
		}
		else {
			//수정
			Restaurant restaurant =restaurantService.GetRestaurantById(id);
			model.addAttribute("restaurant", restaurant);
			model.addAttribute("mode", "update");			
		}	
		return "/rest/regist";
	}
	
	/*@RequestMapping(value="/regist", method=RequestMethod.GET)
	public String regist(Model model) {
		//등록
		Restaurant restaurant = initRestaurant();
		model.addAttribute("restaurant", restaurant);

		return "/rest/regist";
	}*/
	
	
	/*@RequestMapping(value={"/regist", "/update/{id}"}, method=RequestMethod.GET)
	public String regist(Model model, @PathVariable(value="id" ) int id, HttpServletRequest req) {
		
		String uri = req.getRequestURI();
		if(uri.endsWith("regist")) {
			//등록
			Restaurant restaurant = initRestaurant();
			model.addAttribute("restaurant", restaurant);
			return "/rest/regist";
		}
		else {
			//수정
			Restaurant restaurant =restaurantService.GetRestaurantById(id);
			model.addAttribute("restaurant", restaurant);
			return "/rest/update";			
		}
	}*/
	
	@RequestMapping(value={"/regist", "/update"}, method=RequestMethod.POST)
	public ModelAndView regist(@RequestParam(value="id", required=false) Integer id, 
			@ModelAttribute("restaurant") Restaurant restaurant,
			BindingResult result, MultipartFile imageFile, HttpServletRequest req)
					throws IllegalStateException, IOException {
		
		String uri = req.getRequestURI();
		
		if(!result.hasFieldErrors("restaurantName")) { //기존에 바인드된 에러메시지
			if(restaurant.getRestaurantName() == null || restaurant.getRestaurantName().length() == 0) {
				result.rejectValue("restaurantName", "error.required");
			}
		}
		if(!result.hasFieldErrors("lat")) {
			if(restaurant.getLat() < -90 || restaurant.getLat() > 90) {
				result.rejectValue("lat", "error.lat");
			}
		}
		
		if(!result.hasFieldErrors("lon")) {
			if(restaurant.getLon() < 0 || restaurant.getLon() > 360) {
				result.rejectValue("lon", "error.lon");
			}
		}
		
		if(result.hasErrors()) {
			ModelAndView mav = new ModelAndView("/rest/regist");
			mav.getModel().putAll(result.getModel());
			if(uri.endsWith("regist")) {
				mav.addObject("mode", "regist");
			}
			else {
				mav.addObject("mode", "update");
			}
			return mav;
		}
	
		if(!imageFile.getOriginalFilename().isEmpty() && !imageFile.isEmpty()) {
			File uploadFile = new File("D:\\Dev\\upload\\", imageFile.getOriginalFilename());
			restaurant.setImage(imageFile.getBytes());
			imageFile.transferTo(uploadFile);
		}
		
		ModelAndView mav = new ModelAndView("/rest/result");
		mav.addObject("restaurant", restaurant);
		
		
		
		if(uri.endsWith("regist")) {
			restaurantService.InsertRest(restaurant);
			mav.addObject("mode", "regist");			
		}
		else {
			restaurant.setRestaurantId(id);
			restaurantService.UpdateRest(restaurant);
			mav.addObject("mode", "update");			
		}
		return mav;
	}
	
	@RequestMapping("/getImage")
	@ResponseBody
	public byte[] getImage(@RequestParam(value="id", defaultValue="1") Integer restaurantId, 
			HttpServletResponse resp) throws IOException {
		Restaurant restaurant = restaurantService.GetRestaurantById(restaurantId);
		
		byte[] bytes = restaurant.getImage();
		if(bytes == null ) {
			File file = new File("D:\\Dev\\upload\\iu.jpg");
			return Files.readAllBytes(file.toPath());
		}else {
			resp.setContentLength(bytes.length);
			resp.setContentType("image/png");
		}
		
		return bytes;
	}
	
	@RequestMapping(value="/review", method=RequestMethod.POST)
	public String review(@ModelAttribute("review") Review review,
			BindingResult result) {
		
		reviewService.CreateReview(review);
		
		
		return "redirect:/rest/review/"+review.getRid();
	}
	
	//review
	@RequestMapping(value="/review/{rid}")
	public String reviewList(@PathVariable Integer rid, Model model) {
		Restaurant restaurant = restaurantService.GetRestaurantById(rid);
		Double avg = (Double) reviewService.GetAverageById(restaurant.getRestaurantId());
		List<Review> reviewList = reviewService.GetReviewList(restaurant.getRestaurantId());
		model.addAttribute("rest", restaurant);
		int avg2 = (int)((avg == null) ? 0 : avg);

		//등록
		Review review = initReview();
		model.addAttribute("restaurant", restaurant);		
		model.addAttribute("reviewAvg", avg);
		model.addAttribute("review", review);		
		model.addAttribute("reviewList", reviewList);
		model.addAttribute("starList", startList());		
		return "/rest/review";
	}
	
	@RequestMapping(value="/review_del/{id}/{uid}/{rid}")
	public String delete(@PathVariable Integer id, @PathVariable String uid, @PathVariable String rid) throws IOException {
		reviewService.DeleteReview(id, uid);
		return "redirect:/rest/review/"+rid;	
	}
	
	protected Map startList() {
		Map<String, String> starMap = new LinkedHashMap<String, String>();
		starMap.put("5", "★★★★★");
		starMap.put("4", "★★★★");
		starMap.put("3", "★★★");
		starMap.put("2", "★★");
		starMap.put("1", "★");
		return starMap;
	}
}
