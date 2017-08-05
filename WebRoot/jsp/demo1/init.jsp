<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- JSP语法 脚本元素三种 -->
<h1>JSP 脚本</h1>
<!-- 第一种  JSP脚本声明 -->
<%!
	int a = 10;
	public void print(){}
	class A {}
%>
<!-- 第二种  脚本表达式 输出内容到页面 -->
<%= "abcd" %>
<% out.print("abcd"); %>
<!-- 第三种 代码块 编写任何java程序 -->
<%
	for(int i=0;i<10;i++){
		out.print(i);
	}
%>

<%
	for(int i=0;i<10;i++){
		//out.print("<h1>Hello</h1>");
%>
     <h1>代码块中间 可以编写html</h1>
<%
	}
%>
</body>
</html>