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
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;



import com.oraclejava.restaurant.dto.Restaurant;
import com.oraclejava.restaurant.service.RestaurantService;

@Controller
@RequestMapping("/rest")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	private int pageCount = 15;
	private final static int MAX_BUFFER_SIZE = 1024;
	
	@ModelAttribute("restaurant")
	public Restaurant initRestaurant() {
		Restaurant restaurant = new Restaurant();
		return restaurant;
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
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam(value="id",  defaultValue = "1") int id, HttpServletResponse resp) throws IOException {
		restaurantService.DeleteRest(id);
		return "redirect:/rest/list";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String upadte(@RequestParam(value="id", defaultValue="1") int id, Model model) {
		Restaurant restaurant =restaurantService.GetRestaurantById(id);
		model.addAttribute("restaurant", restaurant);
		return "/rest/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public ModelAndView upadte(@ModelAttribute("restaurant") Restaurant restaurant,
			MultipartFile imageFile,
			BindingResult result) throws IOException {
		
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
		return mav;
	
	}
	
	
	@RequestMapping(value="/regist", method=RequestMethod.GET)
	public void regist(Model model) {
		Restaurant restaurant = initRestaurant();
		model.addAttribute("restaurant", restaurant);	
	}
	
	@RequestMapping(value="/regist", method=RequestMethod.POST)
	public ModelAndView regist(@ModelAttribute("restaurant") Restaurant restaurant,
			MultipartFile imageFile,
			BindingResult result) throws IllegalStateException, IOException {
						
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
			
		restaurantService.InsertRest(restaurant);
		
		ModelAndView mav = new ModelAndView("/rest/result");
		mav.addObject("restaurant", restaurant);
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
}
