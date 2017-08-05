<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>系统主页</h1>
<%
	// 因为session会保存登陆用户信息，如果session中没有该信息 说明用户未登录
	if(request.getSession().getAttribute("username")==null){
		//未登录
		out.println("你还没有登陆，<a href='/day07/session/demo3/login.jsp'>去登陆</a>");
	}else{
		// 已经登陆
		out.println("欢迎你，"+request.getSession().getAttribute("username"));
	}
%>
</body>
</html>