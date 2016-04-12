package com.oraclejava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReqServ extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 응답 한글처리
		resp.setContentType("text/html; charset=euc-kr");

		// 요청 한글처리
		req.setCharacterEncoding("euc-kr");

		String name = req.getParameter("name1");
		String[] props = req.getParameterValues("property");

		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(name + "<br />");
		
		for (int i=0; i < props.length; i++) {
			out.println(props[i] + "<br />");
		}
		
		/*헤더 정보 구하기*/
		Enumeration<String> headers = req.getHeaderNames();
		out.println("---헤더 정보 구하기----<br />");
		while(headers.hasMoreElements()) {
			String s1 = headers.nextElement();
			out.println(s1+" : ");
			out.println(req.getHeader(s1) + "<br />");
		}
		
		out.println(req.getRemoteAddr());
		out.println("</body>");
		out.println("</html>");
		
		/* request, response 요청이 사라진다 */
		/*
		 * foward
		 * ServletContext sc = getServletContext();
		 * RequestDispatcher : 요청관리자 
		 * RequestDispatcher rd = sc.getRequestDispatcher("/HelloWorld"); //요청을 처리할 서블릿 컨텍스트를 얻는다
		 * RequestDispatcher rd = req.getRequestDispatcher("/HelloWorld");
		 * rd.forward(req, resp);
		*/
		
		/*session scope*/
		HttpSession session = req.getSession();
		session.setAttribute("userid", "oraclejava");
		
		/*application scope*/
		ServletContext sc = getServletContext();
		sc.setAttribute("userid", "oraclejava_app1");
		
		RequestDispatcher rd = req.getRequestDispatcher("/HelloWorld");
		req.setAttribute("userid", "test2");
		//resp.sendRedirect("http://www.naver.com");
		rd.forward(req, resp);
	}

}
