<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- EL 可以获得 Servlet 数据域对象值 -->
<%
	// 向ServletContext 保存一个数据
	getServletContext().setAttribute("name","itcast");
	// 向Request保存一个数据
	request.setAttribute("address","春生泰克");
%>
<h1>取得ServletContext和request中数据</h1>
<%=getServletContext().getAttribute("name") %>
<%=request.getAttribute("address") %>

<h1>通过EL 取得 ServletContext和request中数据 </h1>
${applicationScope.name }
${requestScope.address }

</body>
</html>