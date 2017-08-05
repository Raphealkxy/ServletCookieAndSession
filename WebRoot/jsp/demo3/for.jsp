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
<h1>通过 % 编写传统 foreach循环</h1>
<%
	int[] arr = {1,2,3,4,5,6};
	for(int i : arr){
%>
		i的值是 ：<%=i %> <br/>
<%		
	}
%>
<h1>通过 jstl中 c:foreach 替代上面循环</h1>
<%
	request.setAttribute("arr",new int[]{7,8,9,10,11,12});
%>
<!-- item编译目标集合 -->
<c:forEach items="${requestScope.arr}" var="i">
	i的值是 ：${i } <br/>
</c:forEach>
</body>
</html>