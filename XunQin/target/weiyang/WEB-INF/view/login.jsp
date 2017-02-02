<%--
  Created by IntelliJ IDEA.
  User: shiyi
  Date: 2016/12/20
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网——登录</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/register.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->

    <style>

    </style>

</head>

<body onLoad="showError();">
<!-- 顶部导航 -->
<%@include file="normal_nav.jsp"%>

<!-- 移动设备导航栏 -->
<%@include file="mobile_nav.jsp"%>

<!--主要内容-->

<div class="container container-plus">
   	<form style="margin-left: 26%" class="form-horizontal form-plus" role="form" action="/goto/login" method="post" onSubmit="checkAll()" id="loginform">
    	<h1>用户登录</h1>
       	<div class="form-group" id="input-name">
        	<div  class="col-sm-10 col-sm-offset-1">
            	<input type="text" class="form-control input-size" style="height: 50px;" id="username" name="username" autofocus placeholder="用户名" onBlur="checkName()">
                <span class="error" id="namespan"></span>
        	</div>
    	</div>
        <div class="form-group" id="input-pass">
        	<div class="col-sm-10 col-sm-offset-1">
            	<input type="password" class="form-control input-size" style="height: 50px;" id="userpass" name="userpass" placeholder="密码" onBlur="checkPass()"><span class="error" id="passspan"></span>
        	</div>
    	</div>
        <div class="form-group">
        	<%--<input type="checkbox" value="1" name="remember" onclick="rememberPass()">记住密码<font id="space">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>--%>
            <input type="checkbox" value="1" name="remember" onclick="autoLogin()">自动登录
            <a href="#" class="btn btn-link" id="findpass">找回密码</a>
            
        </div>
        <div class="form-group">
        	<div class="col-sm-10 col-sm-offset-1">
            	<input type="submit" class="btn btn-lg btn-submit" value="登录" style="background:#1b435d">
        	</div>
    	</div>
                
    </form>
            
</div>



<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/login.js"></script>

<script type="text/javascript">
	function showWelcome()
	{
		if (${ num > 0 })
			document.getElementById("showWelcome").style.display = "block";
		else
		{
			document.getElementById("showWelcome").style.display = "none";
			document.getElementById("loginform").style.zIndex = 999;
		}
	}

	function showError()
    {
        if(${error != null})
        {
            alert('${error}');
        }
    }

</script>

</body>
</html>
