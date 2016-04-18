package com.oraclejava;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
	private String name;
	private SmartPhone phone;
	private SmartPhone[] phones;
	private Set<SmartPhone> phoneSet;
	private Map<String, SmartPhone> phoneMap;	
	private Properties phoneProps;		
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(SmartPhone phone) {
		this.phone = phone;
	}
	
	public void setPhones(SmartPhone[] phones) {
		this.phones = phones;
	}
	
	public void setPhoneSet(Set<SmartPhone> phoneSet) {
		this.phoneSet = phoneSet;
	}

	public void setPhoneMap(Map<String, SmartPhone> phoneMap) {
		this.phoneMap = phoneMap;
	}	
	
	public void setPhoneProps(Properties phoneProps) {
		this.phoneProps = phoneProps;
	}	
	
	public void result() {
		System.out.println("이름 : " + name);
		System.out.println("폰 : " + phone.getName());
		System.out.println("가격 : " + phone.getPrice());
	}
	
	public void result2() {
		System.out.println("이름 : " + name);
		for(SmartPhone phone : phones) {
			System.out.printf("폰이름 %s, 가격:%s\n", phone.getName(), phone.getPrice());
		}
	}
	
	public void result3() {
		System.out.println("이름 : " + name);
		for(SmartPhone phone : phoneSet) {
			System.out.printf("폰이름 %s, 가격:%s\n", phone.getName(), phone.getPrice());
		}
	}	
	
	public void result4() {
		System.out.println("이름 : " + name);
		for(String key : phoneMap.keySet()) {
			SmartPhone phone = phoneMap.get(key);
			System.out.printf("폰이름 %s, 가격:%s\n", phone.getName(), phone.getPrice());
		}
	}
	
	public void result5() {
		for(String key : phoneProps.keySet().toArray(new String[0])) {
			String phone = phoneProps.getProperty(key);
			System.out.printf("폰이름 :  %s\n", phone);
		}
	}
	
}
