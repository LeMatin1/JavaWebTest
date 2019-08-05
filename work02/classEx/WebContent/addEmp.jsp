<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="emp" method="post">
		员工姓名:<input type="text" name="empName"><p>
		岗位名称:<input type="text" name="empJob"><p>
		员工工资:<input type="text" name="empSal"><p>
		部门名称：
		<select name="deptNo">
			<c:forEach var="dept" items="${deptList }" varStatus="status">
				<option value="${dept.deptNo }">${dept.deptName }</option>
			</c:forEach>
		</select><p>
		<input type="submit" value="提交"><p>
		<input type="hidden" name="opType" value="addEmp">
	</form>
</body>
</html>