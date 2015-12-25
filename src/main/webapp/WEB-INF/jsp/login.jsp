<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录界面</title>
<meta http-equiv="pragma" content="no-cache"/>
<meta http-equiv="cache-control" content="no-cache"/>
<meta http-equiv="expires" content="0"/>

<link rel="stylesheet" type="text/css" href="<%=path %>/images/style.css" />

</head>

<body>
	<div id="content" class="outFrame">
		
		<div class="bj_3">
			<div class="login_box">
				<form id="form-login" method="post" onSubmit="return check();" action="<%=path %>/user/login">
				
				<div class="input1">
				<input type="text" id="loginName" name="username" class="inputer"/>
				</div>
				<div class="input2">
					<input type="password" id="password" name="password" class="inputer"/>
				</div>
				<div class="go"><input type="image" name="image"  src="<%=path %>/images/go.png" value="" alt="单击此处登录"/></div>
				
				<div class="clear"></div>
				<div class="err"><span id="error" style="color:red;width:150px;font-family:'方正准圆简体';"></span></div>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>
