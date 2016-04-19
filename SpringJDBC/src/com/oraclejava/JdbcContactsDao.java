package com.oraclejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component("contactsDao")
public class JdbcContactsDao implements ContactsDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Contact> GetContactsList() {
		String sql = "SELECT contact_id, first_name, last_name FROM contacts";
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList(sql);
		List<Contact> contactList = new ArrayList<Contact>();
		for(Map<String, Object> map : list) {
			Contact contact = new Contact();
			contact.setContactId((int)map.get("contact_id"));
			contact.setFirstName((String)map.get("first_name"));
			contact.setLastName((String)map.get("last_name"));
			contactList.add(contact);
		}
		return contactList;
	}

}
