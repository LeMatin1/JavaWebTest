package view;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import server.ComServerImp;
import server.CommodityServer;


@WebServlet("/delete")
public class DeleteCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getQueryString();
		int nId = Integer.parseInt(id);
		
		CommodityServer cs = new ComServerImp(); 
		int re = cs.deleteCommodity(nId);
		
		response.setContentType("text/html;charset=utf-8");
		if(re>0){
			response.getWriter().write("ɾ���ɹ�������������ҳ");
		}else{
			response.getWriter().write("ɾ��ʧ�ܣ�����������ҳ");			
		}
		response.addHeader("refresh", "3;/WebWork01/allcom");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
