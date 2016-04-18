package com.oraclejava;

public class Person {
	private String name;
	private SmartPhone phone;
	private SmartPhone[] phones;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPhone(SmartPhone phone) {
		this.phone = phone;
	}
	
	public void setPhones(SmartPhone[] phones) {
		this.phones = phones;
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
}
