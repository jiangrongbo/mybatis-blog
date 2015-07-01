<%@ page language="java" contentType="text/html; utf-8"  pageEncoding="utf-8"%>
<%@ taglib prefix ="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>登录页面</title>
<style>
#login
{
width:480px;
height:300px;
border:1px solid #ccc;
margin: 10px auto auto auto;
}
#login h1{
background:#ccc;
font-size:18px;
text-align: center;
margin-top:0px;
}
#login ul{
list-style-type: none;
}
</style>
</head>
<body>
	<div id="login">
		<h1>登录</h1>
		<form action="userLogin.do" method="post">
		<ul>
			<li>用户名：<input type="text" name="username"></li>
			<li>密　码：<input type="text" name="password"></li>
			<li id="btn"><input type="submit" value="登录">&nbsp;<input type="reset" value="重置"></li>
		</ul>
		<span><s:fielderror cssStyle="color:red"><s:param>ErrorInfo </s:param></s:fielderror></span>
		</form>
	</div>
</body>
</html>