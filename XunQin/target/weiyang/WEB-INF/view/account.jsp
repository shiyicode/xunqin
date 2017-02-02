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
    <title>寻亲网——个人信息</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/usermess.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->

    <style>

       
    </style>

</head>

<body>
<!-- 顶部导航 -->
<%@include file="normal_nav.jsp"%>

<!-- 移动设备导航栏 -->
<%@include file="mobile_nav.jsp"%>

<!--主要内容-->
<div class="container main-container">
    <div class="header-container">
        <div class="row">
            <div class="col-md-2" style="padding:5%"><img src="/images/11.jpg" style="width:100px; height:100px;"></div>
            <div class="col-md-5" style="padding:5%">
                <div><h1>塞上江南果</h1></div>
                <div>爱心值：
                    <span>
                        <img src="/images/love.jpg" style="width:20px; height:20px; ">
                        <img src="/images/love.jpg" style="width:20px; height:20px; ">
                        <img src="/images/love.jpg" style="width:20px; height:20px; ">
                    </span>
                </div>
                
            </div>
        </div>
    </div>
    <div class="container second-container">
        <div class="row" style="border-bottom:1px #ccc solid;">
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">我的发布</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">我的留言<span class="badge">3</span></a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">基本信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;" id="self">账户信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">实名认证</a>
        </div>
        <div class="row" style="margin-top:20px">
            <div class="col-md-3" >
                <font class="third-title">邮箱</font>
                <font class="binding">&nbsp;未绑定</font><br>
                <font class="description">可用邮箱加密码登录寻亲网</font>
            </div>
            <div class="col-md-2  col-md-offset-7">
                <div class="btn btn-primary">立即绑定</div>
            </div>
        </div>
        <hr>
        <div class="row"  style="color:#000;font-weight:900">
            <div class="col-md-3">
                <font class="third-title">手机</font>
                <font class="binding">&nbsp;未绑定</font><br>
                <font class="description">可用手机加密码登录寻亲网</font>
            </div>
            <div class="col-md-2 col-md-offset-7">
                <div class="btn btn-primary">立即绑定</div>
            </div>
        </div>
        <hr>
        <div class="row"  style="color:#000;font-weight:900">
            <div class="col-md-3">
                <font class="third-title">密码</font>
                <font class="binding">&nbsp;已设置</font></div>
            <div class="col-md-2  col-md-offset-7">
                <div class="btn btn-primary">修改</div>
            </div>
        </div>
        <hr>
        <div class="row"  style="color:#000;font-weight:900">
            <div class="col-md-3">
                <font class="third-title">社交帐号</font><br>
                <font class="description">第三方可直接登录</font>
            </div>
        </div>
        <br>
        <div class="row" align="center">
            <div class="col-md-4">
                <div class="third-col">
                    <img src="/images/qq.png">
                    <a class="btn btn-primary" style="margin:20%">立即绑定</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="third-col">
                    <img src="/images/weixin.png">
                    <a class="btn btn-primary" style="margin:20%">立即绑定</a>
                </div>
            </div>
            <div class="col-md-4">
                <div class="third-col">
                    <img src="/images/weibo.png">
                    <a class="btn btn-primary" style="margin:20%">立即绑定</a>
                </div>
            </div>
            
        </div>
        
     </div>
            
</div>



<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/usermess.js"></script>

<script type="text/javascript">


</script>

</body>
</html>
