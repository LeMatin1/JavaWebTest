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
	欢迎您,${sessionScope.user.username }<p>
	<a href="emp?opType=toAddEmp">新增员工</a>
	<table border="1" width="800px" cellpadding="1" cellspacing="0">
		<tr align="center">
			<td width="5%"></td>
			<td width="10%">员工编号</td>
			<td width="10%">员工姓名</td>
			<td width="15%">工作岗位</td>
			<td width="15%">员工工资</td>
			<td width="10%">部门编号</td>
			<td width="15%">部门名称</td>
			<td width="20%">操作</td>
		</tr>
		<c:forEach var="emp" items="${empList }" varStatus="status">
			<tr>
				<td>${status.count }</td>
				<td>${emp.empno }</td>
				<td>${emp.empname }</td>
				<td>${emp.empjob }</td>
				<td>${emp.empsal }</td>
				<td>${emp.dept.deptno }</td>
				<td>${emp.dept.deptname }</td>
				<td>
					<a href="emp?opType=toUpdateEmp&empno=${emp.empno }">修改</a>
					<a href="emp?opType=deleteEmp&empno=${emp.empno }">删除</a>
				</td>
			</tr>
		</c:forEach>
		<a href="emp?opType=empList&currentPage=1">首页</a>&nbsp;
		<c:if test="${(currentPage-1)>0 }">
			<a href="emp?opType=empList&currentPage=${currentPage-1 }">上一页</a>
		</c:if>
		<c:if test="${currentPage<pageCount }">
			<a href="emp?opType=empList&currentPage=${currentPage+1 }">下一页</a>
		</c:if>
		<a href="emp?opType=empList&currentPage=${pageCount}">尾页</a>
		当前第${currentPage}/${pageCount}页

	</table>
</body>
</html>