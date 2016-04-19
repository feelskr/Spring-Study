package com.oraclejava.test01;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.InternalResourceView;

public class BaseballView extends InternalResourceView {
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setCharacterEncoding("UTF-8");
		String dispatcherPath = prepareForRendering(request, response);
		request.setAttribute("partial", dispatcherPath.substring(dispatcherPath.lastIndexOf("/") + 1));
		request.setAttribute("model", model);
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/baseball/template.jsp");

		rd.include(request, response);
		//super.renderMergedOutputModel(model, request, response);
	}
}
