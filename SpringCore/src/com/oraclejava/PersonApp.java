package com.oraclejava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonApp {

	public static void main(String[] args) {
		String[] config = {"beans.xml", "beans2.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		Person obj = (Person) context.getBean("hkim");
		obj.result2();
	}

}
