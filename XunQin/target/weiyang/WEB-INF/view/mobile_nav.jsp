<%--
  Created by IntelliJ IDEA.
  User: 塞上江南果
  Date: 2017/1/11
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网——寻人信息</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/lostmess.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->

    <style>



    </style>

</head>

<body>
<!--备选导航栏，移动设备显示-->
<div class="container" id="navmenu">
    <div class="navbar navbar-fixed-top" role="navigation" style="background:#1b435d">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar" style="background:#fff"></span>
                    <span class="icon-bar" style="background:#fff"></span>
                    <span class="icon-bar" style="background:#fff"></span>
                </button>
                <a class="navbar-brand" href="/home/"><font style="font-size:36px">寻亲网</font></a>
            </div>

            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="/lostmess/list">寻亲库</a></li>
                    <li><a href="#">资料库</a></li>
                    <li><a href="#">论坛</a></li>
                    <li><a href="#">关于</a></li>
                    <%
                        Integer m_userid = (Integer) session.getAttribute("userid");
                        if(m_userid != null){
                    %>
                    <li><a href="/user/setprofile"><img src="/images/${UserMess.picture}" class="img-circle" style="height:50px;width:50px"></a></li>
                    <%
                        }
                        else{
                    %>
                    <li><a href="/goto/login">登录</a></li>
                    <li><a href="/goto/register">注册</a></li>
                    <%
                        }
                    %>
                </ul>
            </div>
        </div>
    </div>
</div>

</body>
</html>
