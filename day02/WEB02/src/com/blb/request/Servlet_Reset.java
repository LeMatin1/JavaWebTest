package com.blb.request;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/servlet_Reset")
public class Servlet_Reset extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��request���д洢����
		request.setAttribute("name", "lisi");
		//servlet1������ת����servlet2
		//RequestDispatcher dispatcher = request.getRequestDispatcher("servlet_Reset2");
		//ִ��ת���ķ���
		//dispatcher.forward(request, response);
		request.getRequestDispatcher("servlet_Reset2").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
