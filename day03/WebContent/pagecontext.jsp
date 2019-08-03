<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//使用pagecontext向request域存数据 
		request.setAttribute("name", "zhangsan");
		//pageContext.setAttribute("name", "sunba");
		//pageContext.setAttribute("name", "lisi", pageContext.REQUEST_SCOPE);
		pageContext.setAttribute("name", "qianwu", pageContext.SESSION_SCOPE);
		pageContext.setAttribute("name", "zhaoliu", pageContext.APPLICATION_SCOPE);
	%>
	
	<%=request.getAttribute("name") %>
	<%=pageContext.getAttribute("name",pageContext.REQUEST_SCOPE ) %>
	
	<!-- findAttribute会从小到大搜索域的范围 -->
	<!-- pageContext域<request域<session<application -->
	<%=pageContext.findAttribute("name") %>
	
	<%
		pageContext.getRequest();
		pageContext.getOut();
		/*
			method(request,response,out,session,pageContext)
			method(pageContext)
		*/
	%>
</body>
</html>