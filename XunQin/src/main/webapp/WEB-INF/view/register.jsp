<%--
  Created by IntelliJ IDEA.
  User: 塞上江南果
  Date: 2016/12/31
  Time: 0:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网——注册</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/register.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->



</head>


<body onload="checkSucceed()">

<!-- 顶部导航 -->
<%@include file="normal_nav.jsp"%>

<!-- 移动设备导航栏 -->
<%@include file="mobile_nav.jsp"%>

<!--主要内容-->

<div class="container container-plus">
	<%--<div class="shadow"></div>--%>
   	<form style="margin-left: 26%" class="form-horizontal form-plus" role="form" onsubmit="return checkAll()" action="/goto/register" method="post" onSubmit="checkAll()" style="z-index:999;">
    	<h1>账号注册</h1>
        <div class="form-group" id="input-email">
        	<div class="col-sm-10 col-sm-offset-1">
            	<input type="email" class="form-control input-size" style="height: 50px;" id="useremail" name="useremail" placeholder="邮箱" onBlur="checkEmail()"><span class="error" id="emailspan"></span>
        	</div>
    	</div>
        <div class="form-group" id="input-pass">
        	<div class="col-sm-10 col-sm-offset-1">
            	<input type="password" class="form-control input-size" style="height: 50px;" id="userpass" name="userpass" placeholder="密码" onBlur="checkPass()"><span class="error" id="passspan"></span>
        	</div>
    	</div>
        <div class="form-group" id="input-repass">
        	<div class="col-sm-10 col-sm-offset-1">
            	<input type="password" class="form-control input-size" style="height: 50px;" id="userrepass" name="userrepass" placeholder="确认密码" onBlur="checkRepass()"><span class="error" id="repassspan"></span>
        	</div>
    	</div>
        <div class="form-group">
        	<div class="col-sm-10 col-sm-offset-1">
            	<input type="submit" class="btn btn-lg btn-submit" id="submit" value="注册" style="cursor:not-allowed;">
        	</div>
    	</div>

    </form>

</div>

<div class="first" id="showWelcome" style="display: none">
    <p class="p-model" id="value">欢迎您成为第${num}个加入寻亲网这个大家庭的成员！</p>
    <hr>
    <a class="btn btn-primary" id="tourl" href="/goto/login" style="margin-left:80%;">确认</a>
</div>

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/register.js"></script>

<script type="text/javascript">
    function checkSucceed()
    {
        if(!${empty mess}){
            if(${mess == true})
            {

                document.getElementById("showWelcome").style.display = "block";

            }
            else if(${mess == false})
            {
                document.getElementById("value").innerHTML = "注册失败";
                document.getElementById("showWelcome").style.display = "block";
                document.getElementById("tourl").href = "/goto/register";
            }
        }
    }

</script>

</body>
</html>
