package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Commodity;
import server.ComServerImp;
import server.CommodityServer;


@WebServlet("/add")
public class AddCom extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(html);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	String html ="<form action=\"/WebWork01/addServer\" method=\"post\">"
			+ "������<input type=text  name=\"id\"><br/>���ܹ���<select name=\"man\">"
			+ "<option>201</option><option>202</option><option>203</option></select><br />"
			+ "��Ʒ����<input type=text  name=\"name\"><br />��Ʒ�۸�<input type=text  name=\"price\">"
			+ "<br />��������<input type=text  name=\"stockId\"><br />"
			+ "������<input type=text  name=\"vaild\"><br /><input type=submit value=\"�ύ\"></form>";

}
