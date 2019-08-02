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


@WebServlet("/update")
public class UpdateCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html;charset=UTF-8");
		Writer wr = response.getWriter();
		String id = request.getQueryString();
		int idN = Integer.parseInt(id);
		
		CommodityServer cs = new ComServerImp();
		Commodity com =  cs.getCommodity(idN);
		String[] vars = com.getAllVar();
		String sendbody = table.substring(0);
		
		for(int i =0;i<vars.length;i++){
			sendbody = sendbody.replace("replace"+i, vars[i]);
		}
		wr.write(sendbody);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	String table = "<form action=\"/WebWork01/updateServer\" method=\"post\">������<input type=\"text\" value=replace0 name=\"id\" readonly=\"readonly\">"
			+ "<br/>���ܹ���<select name=\"man\"><option>201</option><option>202</option><option>203</option>"
			+ "</select><br />��Ʒ����<input type=\"text\" value=replace2 name=\"name\"><br />��Ʒ�۸�<input type=\"text\""
			+ " value=replace3 name=\"price\"><br />��������<input type=\"text\" value=replace4 name=\"stockId\"><br />������<input type=\"text\""
			+ "value=replace5 name=\"vaild\"><br /><input type=\"submit\" value=\"�ύ\"/></form>";

}
