<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>查看购物车</h1><h3><a href="/day07/session/demo2/invalidate.jsp">清空购物车</a></h3>
<!-- 购物车信息保存 session中 Map<String,Integer> -->
<%
	Map<String,Integer> cart = (Map<String,Integer>)request.getSession().getAttribute("cart");
	if(cart ==null){
		out.println("无购物信息");
	}else{
		for(String productName: cart.keySet()){
			out.println("<h3>商品名称："+productName+" ，数量："+cart.get(productName)+" </h3>");
		}
	}
%>
<hr/>
<!-- 通过JSTL+EL 编写Map集合 -->
<c:if test="${empty sessionScope.cart}">
	无购物信息
</c:if>
<c:if test="${not empty sessionScope.cart}">
	<!-- 遍历 Map 每一个元素都是 key-value -->
	<c:forEach items="${sessionScope.cart}" var="entry">
		<h3>商品名称： ${entry.key }，数量： ${entry.value }</h3>
	</c:forEach>
</c:if>
</body>
</html>