package com.oraclejava.contact.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oraclejava.contact.dto.Contact;
import com.oraclejava.contact.service.ContactService;
import com.oraclejava.mapper.contact.ContactsMapper;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactsMapper contactsMapper;
	
	@Override
	public List<Contact> GetAllContacts() {
		return contactsMapper.GetAllContacts();
	}
	
	@Override
	public void InsertContact(Contact contact) {
		contactsMapper.InsertContact(contact);
	}
}
