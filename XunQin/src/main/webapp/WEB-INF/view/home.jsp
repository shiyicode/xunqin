<%--
  Created by IntelliJ IDEA.
  User: shiyi
  Date: 2016/12/19
  Time: 下午6:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.web.entity.Lostmess" %>
<%@ page import="java.util.List" %>
<%@ page import="com.web.entity.Usermess" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/xunqin.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->

    <style>
        .navbar-collapse > ul>li>a:hover,
        .navbar-collapse > ul>li>a:focus
        {
            background:rgba(255,225,225,0);
            color:#fff;
        }

        .num-size
        {
            font-size:36px;
            color:#70a3c4;
        }
        .beforeground
        {
            width:100%;
            position:absolute;
            height:500px;
            opacity: 0.4;
            background:#004a7c;
            z-index:9;
        }



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
                        Integer userid = (Integer) session.getAttribute("userid");
                        if(userid != null){
                    %>
                    <li><a href="/user/setprofile"><img src="/images/${Usermess.picture}" class="img-circle" style="height:50px;width:50px"></a></li>
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

<!-- 广告轮播 -->
<div id="ad-carousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
        <li data-target="#ad-carousel" data-slide-to="1"></li>
        <li data-target="#ad-carousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
        <div class="item active">
            <div class="beforeground"></div>
            <img src="/images/66.jpg" alt="1 slide">
            <div class="container">
                <div class="carousel-caption" style="z-index:999">
                    <p style="margin-top:-250px;font-size:36px">基于云技术的公益寻人平台</p>
                    <a href="/lostmess/uploads" class="btn btn-primary">发布寻人信息</a>
                    <a href="/lostmess/list" class="btn btn-primary">查看寻人信息库</a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="beforeground"></div>
            <img src="/images/55.jpg" alt="2 slide">

            <div class="container">
                <div class="carousel-caption" style="z-index:999">
                    <p style="margin-top:-250px;font-size:36px">动动手指就有可能，帮一个流浪小孩找到妈妈</p>
                    <a class="btn btn-primary" href="/gaminmess/uploads">添加流浪人群信息</a>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="beforeground"></div>
            <img src="/images/44.jpg" alt="3 slide">

            <div class="container">
                <div class="carousel-caption" style="z-index:999">
                    <p style="margin-top:-250px;font-size:36px">如果你正在找人，进来就会多一份希望</p>
                    <a class="btn btn-primary">我要找人</a>
                </div>
            </div>
        </div>

    </div>
    <a class="left carousel-control" href="#ad-carousel" data-slide="prev" style="z-index:999"><span
            class="glyphicon glyphicon-chevron-left"></span></a>
    <a class="right carousel-control" href="#ad-carousel" data-slide="next" style="z-index:999"><span
            class="glyphicon glyphicon-chevron-right"></span></a>
</div>

<!-- 顶部导航 -->
<div class="navbar nav-style" role="navigation" id="menu-nav">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/home/" class="nav-font-color">寻亲网</a>
        </div>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/lostmess/list" class="nav-font-color">寻亲库</a></li>
                <li><a href="#" class="nav-font-color">流浪库</a></li>
                <li><a href="#" class="nav-font-color">论坛</a></li>
                <li><a href="#" class="nav-font-color">关于</a></li>
                <%
                    Integer hh_userid = (Integer) session.getAttribute("userid");
                    if(hh_userid != null){
                %>
                <li style="margin-left:600px;"><a href="/user/setprofile"><img class="img-circle" src="/images/${Usermess.picture}" style="width:40px; height:40px"></a></li>
                <%
                }
                else{
                %>
                <li style="margin-left:600px;">
                    <a href="/goto/login" class="nav-font-color">登录</a>
                </li>
                <li><a href="/goto/register" class="nav-font-color">注册</a></li>
                <%
                    }
                %>

            </ul>
        </div>
    </div>
</div>

<%
    int lostNum = (Integer) request.getAttribute("lostMessCount");
    int dataNum = (Integer)request.getAttribute("gaminMessCount");
    int pageViewNum = (Integer)request.getAttribute("pageViewCount");
%>

<div class="container">

    <div class="row" style="text-align:center">
        <div class="col-md-4">
            <div><font class="num-size"><%=pageViewNum%></font></div>
            <div class="word-color">累计访问量</div>
        </div>

        <div class="col-md-4">
            <div><font class="num-size"><%=lostNum%></font></div>
            <div class="word-color">寻人启事数量</div>
        </div>

        <div class="col-md-4">
            <div><font class="num-size"><%=dataNum%></font></div>
            <div class="word-color">资料库数量</div>
        </div>
    </div>

</div>
<hr>

<!-- 主要内容 -->
<div class="container summary">
    <!-- 简介 -->
    <div class="row" name="summary-container">
        <div class="col-md-5">
            <h1>发布寻亲启事</h1>

            <p class="word-color">发布你要找亲人详细信息，借助网络的力量，让更多人看到！</p>

            <p><a class="btn btn-link" href="/lostmess/uploads" role="button">点击发布</a></p>
        </div>
        <div class="col-md-7">
            <img class="img-circle img-size" src="/images/44.jpg" alt="request">
        </div>
    </div>
    <hr>

    <div class="row" name="summary-container">
        <div class="col-md-7">
            <img class="img-circle img-size" src="/images/44.jpg" alt="find">
        </div>
        <div class="col-md-5">
            <h1>上传流浪人信息</h1>

            <p class="word-color">上传你看到的流浪人的信息，为一个家庭的团圆贡献您的力量！</p>

            <p><a class="btn btn-link" href="/gaminmess/uploads" role="button">点击上传</a></p>
        </div>
    </div>
    <hr>

    <div class="row" name="summary-container">
        <div class="col-md-5">
            <h1>爱心论坛</h1>

            <p class="word-color">希望遇到无数次的失望是一件可怕的事情，当您觉得自己坚持不下去的时候，来论坛聊聊，大家互相鼓舞，奇迹总是会发生的</p>

            <p><a class="btn btn-link" href="#" role="button">进入讨论</a></p>
        </div>
        <div class="col-md-7">
            <img class="img-circle img-size" src="/images/44.jpg" alt="talking">
        </div>
    </div>
    <hr>

</div>

<div class="container" align="center" style="background:#e7e8f5;magrin:0px;padding-bottom:40px">
    <h1>成功案例</h1>
    <div class="row">
        <div class="col-md-4">
            <div class="success-div">
                <p align="left">暂无</p>
                <img class="img-circle" src="/images/44.jpg" style="width:40px; height:40px"><br>
                <font>师毅</font>
            </div>
        </div>

        <div class="col-md-4">
            <div class="success-div">
                <p align="left">暂无</p>
                <img class="img-circle" src="/images/44.jpg" style="width:40px; height:40px"><br>
                <font>师毅</font>
            </div>
        </div>

        <div class="col-md-4">
            <div class="success-div">
                <p align="left">暂无</p>
                <img class="img-circle" src="/images/44.jpg" style="width:40px; height:40px"><br>
                <font>师毅</font>
            </div>
        </div>
    </div>

</div>

<div class="container" style="background:#1f6cb0;height:200px;padding-top:50px" align="center">
    <h1>我们每时每刻都在寻找，上传你的资料吧</h1>
    <a class="btn btn-primary">发布寻人信息</a>
</div>




<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script>
    $(function () {
        $('#ad-carousel').carousel();

    });
</script>
</body>
</html>
