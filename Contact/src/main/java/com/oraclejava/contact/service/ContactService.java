package com.oraclejava.contact.service;

import java.util.List;

import com.oraclejava.contact.dto.Contact;

public interface ContactService {
	public List<Contact> GetAllContacts();
	
	public void InsertContact(Contact contact);
}
