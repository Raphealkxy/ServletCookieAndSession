<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 清空购物车 -->
<%
	// 销毁Session
	request.getSession().invalidate();
	response.sendRedirect("/day07/session/demo2/cart.jsp");

%>