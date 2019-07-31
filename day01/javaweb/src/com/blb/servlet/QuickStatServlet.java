package com.blb.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class QuickStatServlet implements Servlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init running....");
		//1.��ȡservlet��name��<servlet-name>abc</servlet-name>
		String servletname = config.getServletName();
		System.out.println(servletname);
		//2.��ȡservlet��ʼ�������������ò��ϣ�
		String initP = config.getInitParameter("url");
		System.out.println(initP);
		//3.��ȡservletContext����
		ServletContext cont = config.getServletContext();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("service running....");
		
	}
	@Override
	public void destroy() {
		System.out.println("destroy running....");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
