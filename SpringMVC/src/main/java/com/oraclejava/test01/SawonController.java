package com.oraclejava.test01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/sawon")
public class SawonController {
	
	@RequestMapping(method=RequestMethod.GET)
	public String index() {
		return "/sawonView";
	}
}
