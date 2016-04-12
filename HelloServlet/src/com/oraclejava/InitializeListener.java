package com.oraclejava;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class InitializeListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext sc =  event.getServletContext();
		sc.setAttribute("msg3", "Good night");
		String msg2 = sc.getInitParameter("msg2");
		System.out.println("msg2 = " + msg2);
	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {

	}

}
