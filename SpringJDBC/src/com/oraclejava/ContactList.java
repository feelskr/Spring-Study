package com.oraclejava;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContactList {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ContactsDao contactDao = (ContactsDao) context.getBean("contactsDao2");
		List<Contact> contactList = contactDao.GetContactsList();
		for (Contact contact : contactList) {
			System.out.printf("%d. %s %s\n", contact.getContactId(), contact.getLastName(), contact.getFirstName());
		}
	}
}
