package com.oraclejava.test01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseballController {
	//포워드 방식(request 유지)
	@RequestMapping("/baseball")	
	public String index() {
		return "forward:/baseball2";
	}
	
	//리다이렉트 방식(URL 변경)
	@RequestMapping("/baseball2")
	public String index2() {
		return "redirect:/baseball3";
	}

	@RequestMapping("/baseball3")
	public String index3() {
		return "/baseball/index3";
	}
}
