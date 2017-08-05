<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>在页面内 编写if条件判断</h1>
<%
	int a = 10;
    if(a>8){
%> 
	a的值大于8
<%    	
    }
%>
<h1>使用 c:if替换上面 if判断</h1>
<%
	request.setAttribute("b",10);
%>
<!-- b在request 通过EL -->
<c:if test="${requestScope.b>8}">
	b的值大于8
</c:if>
</body>
</html>