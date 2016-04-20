package com.oraclejava.contact.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oraclejava.contact.dto.Contact;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@ModelAttribute("contact")
	public Contact initContact() {
		Contact contact = new Contact();
		return contact;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addContact(Model model) {
		Contact contact = initContact();
		contact.setFirstName("홍");
		contact.setLastName("길동");
		model.addAttribute("contact", contact);	
		return "/contact/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {
		ModelAndView mav = new ModelAndView("/contact/result");
		mav.addObject("conatct", contact);
		return mav;
	}		
	
}
