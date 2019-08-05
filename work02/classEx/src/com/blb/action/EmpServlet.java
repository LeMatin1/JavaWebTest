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

	//��ѯ����Ա����Ϣ
	public String getEmpPageList(HttpServletRequest request){
		EmpService es = new EmpServiceImpl();
		//��ȡ�����еĵ�ǰ�ڼ�ҳ�������ȡ������Ĭ�ϵ�һҳ
		int currentPage = 1;
		String currentPageStr = request.getParameter("currentPage");
		if(currentPageStr !=null){
			currentPage = Integer.parseInt(currentPageStr);
		}
		//��ȡ�����е�ÿҳ��ʾ�ı����������ȡ������Ĭ��ÿҳ5��
		int pageSize = 5;
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		//��ȡ������
		int count = es.getEmpCount();
		//��ȡ��ҳ����
		List<Emp> empList = es.getEmpPageList(currentPage,pageSize);
		//��ȡ��ҳ�����������������ÿҳ����  ���þ�������ҳ��=������/ÿҳ����    ������ҳ��=������/ÿҳ���� + 1
		int pageCount = count % pageSize!=0?count/pageSize+1:count/pageSize;
		
		//System.out.println("pageCount:"+pageCount);
		//���浱ǰҳ����ÿҳ��������ѯ�Ľ��
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("empList", empList);
		
		return "empList.jsp";
	}
	
	public String getAllDept(HttpServletRequest request){
		return "addEmp.jsp";
	}
}
