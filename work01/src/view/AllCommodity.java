package view;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pojo.Commodity;
import server.ComServerImp;
import server.CommodityServer;

@WebServlet("/allcom")
public class AllCommodity extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder stb = new StringBuilder();
	
		response.setContentType("text/html;charset=UTF-8");
		Writer wr = response.getWriter();
		
		
		getList(stb);
		
		wr.write(tableHead);
		wr.write(stb.toString());
		wr.write(tableEnd);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	
	void getList(StringBuilder stb){
		
		CommodityServer cs = new ComServerImp(); 
		List<Commodity> list = cs.getAll();
		Iterator<Commodity> it =list.iterator();
		while(it.hasNext()){
			Commodity com = it.next();
			String[] vars = com.getAllVar();
			String newbody = tableBody.substring(0);
			
			for(int i=0;i<vars.length;i++){
				newbody = newbody.replace("replace"+i, vars[i]);
			}
			stb.append(newbody);
		}
	}
	
	String tableHead = "<table border=\"1\"><tr><th>条形码</th><th>主管工号</th><th>商品名称</th><th>商品价格</th><th>进货单号</th><th>保质时间</th><th>编辑</th></tr>";
	String tableBody = "<tr><td>replace0</td><td>replace1</td><td><a href=\"/WebWork01/info?replace0\">replace2</a></td><td>replace3</td><td>replace4</td>"
			+ "<td>replace5</td><td><a href=\"/WebWork01/update?replace0\">修改 </a>"
			+ "<a href=\"/WebWork01/delete?replace0\" onclick=\"if(confirm('确定删除?')==flase)return false;\"> 删除</a></td></tr>";
	String tableEnd = "</table><a href=\"/WebWork01/add\">添加商品</a>";
}
