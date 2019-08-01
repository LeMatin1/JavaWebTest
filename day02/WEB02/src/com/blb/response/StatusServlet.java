package com.blb.response;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/statusServlet")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setStatus(404);//手动设置http响应行中的状态码
		Date date = new Date();
		//设置响应头
		response.addHeader("name", "zhangsan");
		response.addIntHeader("age", 18);
		//response.addDateHeader("birthday", date.getTime());
		
		response.addHeader("name", "lisi");
		
		
		response.setHeader("age", "28");
		response.setHeader("age", "58");
		
		response.setHeader("refresh", "5;url=http://www.baidu.com");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
