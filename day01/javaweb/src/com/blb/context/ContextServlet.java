package com.blb.context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/context1")
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡSerlvetContext����
		ServletContext context = getServletContext();
		//1.��ȡ��ʼ������
		String initP = context.getInitParameter("driver");
		System.out.println(initP);
		//2.��ȡa b c d.txt�ľ���·��(������WEB01---webӦ����)
		//2.1��ȡa.txt
		String realPath_A= context.getRealPath("a.txt");
		System.out.println(realPath_A);
		//2.2��ȡb.txt
		String realPath_B= context.getRealPath("WEB-INF/b.txt");
		System.out.println(realPath_B);
		//2.3��ȡc.txt
		String realPath_C= context.getRealPath("WEB-INF/classes/c.txt");
		System.out.println(realPath_C);
		
		//�ڶ�ȡsrc(classes)�µ���Դ�ǿ���ͬ�������---ר�ż���classes�µ��ļ�
		//getResource()������һ����Ե�ַ����Բο�����classes
		String Path = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
		System.out.println(Path);
		
		//3.�����---��servletcontext�д�����
		context.setAttribute("name", "zhangsan");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
