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
			+ "条形码<input type=text  name=\"id\"><br/>主管工号<select name=\"man\">"
			+ "<option>201</option><option>202</option><option>203</option></select><br />"
			+ "商品名称<input type=text  name=\"name\"><br />商品价格<input type=text  name=\"price\">"
			+ "<br />进货单号<input type=text  name=\"stockId\"><br />"
			+ "保质期<input type=text  name=\"vaild\"><br /><input type=submit value=\"提交\"></form>";

}
