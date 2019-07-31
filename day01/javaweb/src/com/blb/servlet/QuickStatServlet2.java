package com.blb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blb.pojo.User;
import com.blb.utils.DBUtils;

@WebServlet("/quickStatServlet2")
public class QuickStatServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		int count = 0;
		this.getServletContext().setAttribute("count", count);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		PrintWriter pw =response.getWriter();
		pw.write("hello servlet~!");*/
		//response.getWriter().write("<html>");
		
		//1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//2.从数据库中获取用户是否存在
		User user = null;
		ResultSet rs = null;
		try{
			DBUtils.openConnection();
			String sql = "select * from t_user where name = ? and password = ?";
			rs = DBUtils.executeQuery(sql, username,password);
			if(rs.next()){
				user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtils.closeConnection();
		}
		
		if(user != null){
			//从servletContext中取出count++
			ServletContext context = this.getServletContext();
			int count = (int)context.getAttribute("count");
			count++;
			response.getWriter().write(user.toString()+"login count:"+count);
			context.setAttribute("count", count);
		}else{
			response.getWriter().write("login faile");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
