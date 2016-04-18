package com.oraclejava;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonApp {

	public static void main(String[] args) {
		String[] config = {"beans.xml", "beans2.xml"};
		ApplicationContext context = new ClassPathXmlApplicationContext(config);
		Person obj = (Person) context.getBean("hkim");
		System.out.println("result : ");
		obj.result();
		System.out.println("\nresult2 : ");		
		obj.result2();
		System.out.println("\nresult3 : ");		
		obj.result3();
		System.out.println("\nresult4 : ");		
		obj.result4();		
		System.out.println("\nresult5 : ");		
		obj.result5();				
	}

}
