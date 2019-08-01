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
		//1.��ȡ����ʽ
		String method = request.getMethod();
		System.out.println(method);
		//2.��ȡ������Դ�������
		String requestURI = request.getRequestURI();
		StringBuffer requestURL = request.getRequestURL();
		System.out.println("URI:"+requestURI);
		System.out.println("URL:"+requestURL);
		//3.���WEBӦ�õ�����
		String contextPath = request.getContextPath();
		System.out.println("WEBӦ�ã�"+contextPath);
		//4.��ַ��Ĳ����ַ���
		String queryString = request.getQueryString();
		System.out.println(queryString);
		//��ȡ�ͻ�������Ϣ--��ȡIP��ַ
		String remoteAddr = request.getRemoteAddr();
		System.out.println("IP:"+remoteAddr);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
