package com.blb.response;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/textServlet")
public class TextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.设置response查询的码表
		//response.setCharacterEncoding("utf-8");
		//2.通过一个头Content-Type 告知客户端使用何种码表
		//response.setHeader("Content-Type", "text/html;charset=UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		response.getWriter().write("你好");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
