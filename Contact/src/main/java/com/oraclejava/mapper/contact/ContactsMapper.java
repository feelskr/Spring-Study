package com.oraclejava.mapper.contact;

import java.util.List;

import com.oraclejava.contact.dto.Contact;

public interface ContactsMapper {
	List<Contact> GetAllContacts();

	void InsertContact(Contact contact);
}
