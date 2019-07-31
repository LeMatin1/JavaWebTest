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
		//获取SerlvetContext对象
		ServletContext context = getServletContext();
		//1.获取初始化参数
		String initP = context.getInitParameter("driver");
		System.out.println(initP);
		//2.获取a b c d.txt的绝对路径(参照物WEB01---web应用名)
		//2.1获取a.txt
		String realPath_A= context.getRealPath("a.txt");
		System.out.println(realPath_A);
		//2.2获取b.txt
		String realPath_B= context.getRealPath("WEB-INF/b.txt");
		System.out.println(realPath_B);
		//2.3获取c.txt
		String realPath_C= context.getRealPath("WEB-INF/classes/c.txt");
		System.out.println(realPath_C);
		
		//在读取src(classes)下的资源是可以同类加载器---专门加载classes下的文件
		//getResource()参数是一个相对地址，相对参考物是classes
		String Path = ContextServlet.class.getClassLoader().getResource("c.txt").getPath();
		System.out.println(Path);
		
		//3.域对象---向servletcontext中存数据
		context.setAttribute("name", "zhangsan");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
