package com.blb.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blb.pojo.User;
import com.blb.service.UserService;
import com.blb.service.impl.UserServiceImpl;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opType = request.getParameter("opType");
		if("login".equals(opType)){
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = new User(username,password);
			String result = login(user,request);
			request.getRequestDispatcher(result).forward(request, response);
		}
	}
	
	public String login(User user,HttpServletRequest request){
		UserService us = new UserServiceImpl();
		User loginuser = us.login(user);
		if(loginuser != null){
			HttpSession session = request.getSession();
			session.setAttribute("user", loginuser);
			return "emp?opType=empList";
		}else{
			request.setAttribute("errorMgs", "’À∫≈ªÚ’ﬂ√‹¬Î¥Ì£°");
			return "login.jsp";
		}
		
	}
}
