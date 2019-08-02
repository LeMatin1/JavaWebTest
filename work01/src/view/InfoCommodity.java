package view;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Commodity;
import server.ComServerImp;
import server.CommodityServer;

@WebServlet("/info")
public class InfoCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		Writer wr =  response.getWriter();
		int id = Integer.parseInt(request.getQueryString());
		System.out.println(id);
		
		CommodityServer cs = new ComServerImp();
		Commodity com =  cs.getCommodity(id);
		String[] vars = com.getAllVar();
		String sendbody = htmlbody.substring(0);
		
		for(int i =0;i<vars.length;i++){
			sendbody = sendbody.replace("replace"+i, vars[i]);
		}
		wr.write(sendbody);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	String htmlbody = "<table border=1><tr><th>������</th><td>replace0</td></tr>"
			+ "<tr><th>���ܹ���</th><td>replace1</td></tr><tr><th>��Ʒ����</th>"
			+ "<td>replace2</td></tr><tr><th>��Ʒ�۸�</th><td>replace3</td></tr>"
			+ "<tr><th>��������</th><td>replace4</td></tr><tr><th>����ʱ��</th><td>replace5</td></tr>"
			+ "<tr><td colspan=\"2\"><a href=\"/WebWork01/allcom\">����</a></td></tr>";

}
