<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.itcast.utils.CookieUtils"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 页面由两部分组成 -->
<h1>商品列表</h1>
<a href="/day07/producthistory?id=1">冰箱</a><br/>
<a href="/day07/producthistory?id=2">洗衣机</a><br/>
<a href="/day07/producthistory?id=3">笔记本电脑</a><br/>
<a href="/day07/producthistory?id=4">手机</a><br/>
<a href="/day07/producthistory?id=5">空调</a><br/>
<a href="/day07/producthistory?id=6">热水器</a><br/>
<a href="/day07/producthistory?id=7">微波炉</a><br/>
<a href="/day07/producthistory?id=8">电风扇</a><br/>

<h1>商品浏览记录</h1><h3><a href="/day07/cleanhistory">清空浏览记录</a></h3>
<%
	/*
	Cookie[] cookies =request.getCookies();
	if(cookies==null){
		out.println("无浏览记录！");
	}else{
		// 遍历cookie ---- 找到history
		for(Cookie c:cookies){
			if(c.getName().equals("history")){
				String id = c.getValue();
				String[] arr = { "冰箱", "洗衣机", "笔记本电脑", "手机", "空调", "热水器", "微波炉", "电风扇" };
				out.println(arr[Integer.parseInt(id)-1]);
			}
		}
	}
	*/
	Cookie cookie = CookieUtils.findCookie(request.getCookies(),"history");
	if(cookie==null){
		out.println("无浏览记录！");
	}else{
		String ids = cookie.getValue(); // 1,2,3,4,5
		String[] idArray = ids.split(",");
		String[] arr = { "冰箱", "洗衣机", "笔记本电脑", "手机", "空调", "热水器", "微波炉", "电风扇" };
		for(String id : idArray){
			out.println(arr[Integer.parseInt(id)-1]+"<br/>");
		}
	}
%>
</body>
</html>