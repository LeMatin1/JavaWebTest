package com.blb.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/infoServlet")
public class InfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取请求方式
		String method = request.getMethod();
		System.out.println(method);
		//2.获取请求资源相关内容
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("URI:"+requestURI);
		System.out.println("URL:"+requestURL);
		//3.获得WEB应用的名称
		String contextPath = request.getContextPath();
		System.out.println("WEB应用："+contextPath);
		//4.地址后的参数字符串
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//获取客户机的信息--获取IP地址
		String remoteAddr = request.getRemoteAddr();
		System.out.println("IP:"+remoteAddr);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
