package com.oraclejava;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloWorld extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req,
			HttpServletResponse res)
					throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		ServletContext sc = getServletContext();
		String ssname = (String)sc.getAttribute("userid");
		ServletConfig sc2 = getServletConfig();
		String msg = sc2.getInitParameter("msg2");
		String cMsg = sc.getInitParameter("msg");
		String cMsg2 = sc.getInitParameter("msg2");
		String cMsg3 = (String)sc.getAttribute("msg3");

		
		//out.println("<html>");
		//out.println("<body>");
		String name = req.getParameter("name1");
		String sname = (String)req.getSession().getAttribute("userid");
		String userid = (String)req.getAttribute("userid");
		out.println("<h1>Hello "+userid+" : "+ name +" : "+ sname +":"+ssname+":"+msg+":"+cMsg+":"+cMsg2+"</h1><br />");
		out.println("<h1>"+cMsg3+"</h1>");
		//out.println("</body>");
		//out.println("</html>");

	}

}
