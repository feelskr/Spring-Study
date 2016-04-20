package com.oraclejava.test01;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JsonController {

	@RequestMapping(value = "/ajax/jsonOut", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<UserInfoDto> jsonOut(@RequestParam String cd) {

		if (cd == null || cd == "") {
			return new ArrayList<UserInfoDto>();
		}

		List<UserInfoDto> user = new ArrayList<UserInfoDto>();
		if ("영업부".equals(cd)) {
			user.add(new UserInfoDto("영업부", "욱1"));
			user.add(new UserInfoDto("영업부", "욱2"));
			user.add(new UserInfoDto("영업부", "욱3"));
			user.add(new UserInfoDto("영업부", "욱4"));
		} else if ("개발부".equals(cd)) {
			user.add(new UserInfoDto("개발부", "김1"));
			user.add(new UserInfoDto("개발부", "김2"));
			user.add(new UserInfoDto("개발부", "김3"));
			user.add(new UserInfoDto("개발부", "김4"));
		} else if ("인사부".equals(cd)) {
			user.add(new UserInfoDto("인사부", "이1"));
			user.add(new UserInfoDto("인사부", "이2"));
			user.add(new UserInfoDto("인사부", "이3"));
			user.add(new UserInfoDto("인사부", "이4"));
		}

		return user;
	}
	
	/* spring 3.1 */
	@RequestMapping(value = "/ajax/jsonIn", consumes="application/json")
	/* spring 3.0 */
	//@RequestMapping(value = "/ajax/jsonIn", headers="Contetn-type=application/json")
	public ModelAndView showSawon(@RequestBody UserInfoDto dto ) {
		ModelAndView mav = new ModelAndView("/showSawonView");
		mav.addObject("model", dto);
		return mav;
		
	}
}
