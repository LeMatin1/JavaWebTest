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

@WebServlet("/addServer")
public class AddServer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String cid = request.getParameter("id");
		String man = request.getParameter("man");
		String name = request.getParameter("name");
		String pri = request.getParameter("price");
		String stockid = request.getParameter("stockId");
		String vaild = request.getParameter("vaild");
		
		System.out.println(name);
		
		Commodity com = new Commodity(Integer.parseInt(cid), Integer.parseInt(man), name,Integer.parseInt(pri), Integer.parseInt(stockid), vaild);
		CommodityServer cs = new ComServerImp(); 
		int re = cs.addCommodity(com);
		
		response.setContentType("text/html;charset=utf-8");
		if(re>0){
			response.getWriter().write("添加成功，即将返回首页");
		}else{
			response.getWriter().write("添加失败，即将返回首页");			
		}
		response.addHeader("refresh", "3;/WebWork01/allcom");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
