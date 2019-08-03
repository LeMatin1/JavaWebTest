<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" session="true" isErrorPage="true"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP</title>
</head>
<body>
	<!-- HTML注释 -->
	xxxxxxxxxxxxxxxxxxx
	<h1>JSP</h1>
	<%@ include file="/error.jsp" %>
	<%
		//单行 
		/*
			多行 
		*/
		int i = 0;
		System.out.print(i);
		List<String> list = new ArrayList<String>();
		//int x = 1 / 0;
	%>
	<%-- jsp注释 --%>
	<%=i %>
	<%=1+1 %>
	
	<%!
		String str = "angle";
	
		public void fn(){
			
		}
	%>
	<%=str %>
</body>
</html>