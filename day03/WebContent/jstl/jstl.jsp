<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setAttribute("count", 10);
		for(int i = 0;i<5;i++){
		 	System.out.println(i);
		}
	%>
	<!-- jstl和el经常会配合使用 -->
	<!-- test代表的返回boolean的表达式 -->
	<c:if test="${count==9 }">
		xxxxx
	</c:if>
	
	<!-- foreach模拟
		for(int i = 0;i<5;i++){
		 	System.out.println(i);
		}
	 -->
	 <c:forEach begin="0" end="4" var="i">
	 	${i }<br/>
	 </c:forEach>
	 <!-- foreach模拟 productList---List<Product>
		for(Product product:productList){
			System.out.println(product.getName())
		}
		items:集合或者数组   var:代表集合中的某一个元素
	 
	 <c:forEach items="${productList }" var="product">
	 	${product.name }
	 </c:forEach>
	 -->
</body>
</html>