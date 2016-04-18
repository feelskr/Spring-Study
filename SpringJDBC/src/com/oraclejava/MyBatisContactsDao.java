package com.oraclejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.oraclejava.mapper.ContactsMapper;

public class MyBatisContactsDao implements ContactsDao {

	@Autowired
	private ContactsMapper contactsMapper;
	
	/*public void setContactsMapper(ContactsMapper contactsMapper) {
		this.contactsMapper = contactsMapper;
	}*/
	
	@Override
	public List<Contact> GetContactsList() {
		return contactsMapper.GetAllContacts();
	}
}
