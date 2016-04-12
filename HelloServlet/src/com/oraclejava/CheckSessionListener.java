package com.oraclejava;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class CheckSessionListener implements HttpSessionListener {
	
	private static int sesCount = 0;
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		sesCount++;
		System.out.println("현재 접속자수 : " + sesCount);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		sesCount--;
		System.out.println("현재 접속자수 : " + sesCount);
	}

}
