package com.blb.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blb.pojo.Emp;
import com.blb.service.EmpService;
import com.blb.service.impl.EmpServiceImpl;


@WebServlet("/emp")
public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opType = request.getParameter("opType");
		String result = "";
		if("empList".equals(opType)){
			result = getEmpPageList(request);
		}else if("toAddEmp".equals(opType)){
			result = getAllDept(request);
			
		}else if("addEmp".equals(opType)){
			
		}else if("deleteEmp".equals(opType)){
			
		}
		request.getRequestDispatcher(result).forward(request, response);
	}

	//查询所有员工信息
	public String getEmpPageList(HttpServletRequest request){
		EmpService es = new EmpServiceImpl();
		//获取请求中的当前第几页，如果获取不到则默认第一页
		int currentPage = 1;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr !=null){
			currentPage = Integer.parseInt(currentPageStr);
		}
		//获取请求中的每页显示的笔数，如果获取不到则默认每页5条
		int pageSize = 5;
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		//获取总条数
		int count = es.getEmpCount();
		//获取分页数据
		List<Emp> empList = es.getEmpPageList(currentPage,pageSize);
		//获取总页数：如果总条数除以每页条数  除得尽则：则总页数=总条数/每页条数    否则：总页数=总条数/每页条数 + 1
		int pageCount = count % pageSize!=0?count/pageSize+1:count/pageSize;
		
		//System.out.println("pageCount:"+pageCount);
		//保存当前页数、每页笔数、查询的结果
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("empList", empList);
		
		return "empList.jsp";
	}
	
	public String getAllDept(HttpServletRequest request){
		return "addEmp.jsp";
	}
}
