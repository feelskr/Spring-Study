package com.oraclejava.test01;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/helloview");
		mav.addObject("message1", "<strong>Spring mvc</strong>");
		mav.getModelMap().put("message2", "한글 테스트");
		mav.addObject("currentDate", new Date());
		
		return mav;
	}
	
}
