package com.blb.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/refererServlet")
public class RefererServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�Ը����ŵ���Դ�����ж�
		String header = request.getHeader("referer");
		response.setContentType("text/html;charset=UTF-8");
		if(header != null && header.startsWith("http://localhost")){
			//�Ǵ����Լ�����վ��ת�����ģ����Կ�����
			response.getWriter().write("�й�ȷʵ�Ѿ����100�����");
		}else{
			response.getWriter().write("���ǵ����ߣ��ɳܣ�");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
