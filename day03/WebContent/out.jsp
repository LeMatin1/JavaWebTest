<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="0kb" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	aaaaaaaaaaaaaaaaaaaaa
	
	<%
		int i = 10;
		out.write("bbbbbbbbbbbbbbbbb");
		response.getWriter().write("ccccccccccccccccccccc");
	%>
	<%="ddddddddddddddddddddddddd" %>
	
	<%
		System.out.print(i);
	%>
</body>
</html>