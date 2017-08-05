<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function change(){
		//切换验证码
		document.getElementById("myimg").src="/day07/checkcode?"+new Date().getTime();
	}
</script>
</head>
<body>
<h1>登陆页面</h1>
<h3 style="color:red;">${requestScope.msg }</h3>
<form action="/day07/login" method="post">
	用户名 <input type="text" name="username" /><br/>
	密码 <input type="password" name="password" /><br/>
	请输入验证码 <input type="text" name="checkcode" /><img id="myimg" src="/day07/checkcode" style="cursor:pointer; " onclick="change();"/><br/>
	<input type="submit" value="登陆" />
</form>
</body>
</html>