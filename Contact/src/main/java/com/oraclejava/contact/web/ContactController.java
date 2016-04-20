package com.oraclejava.contact.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oraclejava.contact.dto.Contact;
import com.oraclejava.contact.service.ContactService;

@Controller
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	private ContactService contactService;

	@ModelAttribute("contact")
	public Contact initContact() {
		Contact contact = new Contact();
		return contact;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String index(Model model) {
		List<Contact> list = contactService.GetAllContacts();
		model.addAttribute("list", list);
		return "/contact/list";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String addContact(Model model) {
		Contact contact = initContact();
		contact.setLastName("홍");
		contact.setFirstName("길동");
		model.addAttribute("contact", contact);	
		return "/contact/add";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {

		if(!result.hasErrors()) {
			contactService.InsertContact(contact);
		}
		
		ModelAndView mav = new ModelAndView("/contact/result");
		mav.addObject("conatct", contact);
		return mav;
	}		
	
}
