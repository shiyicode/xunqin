<%--
  Created by IntelliJ IDEA.
  User: 塞上江南果
  Date: 2017/1/19
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.web.entity.Lostrecord" %>
<%@ page import="com.web.entity.Lostmess" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网——个人主页</title>
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
            <div class="col-md-2" style="padding:5%"><img src="/images/${UserMess.picture}" style="width:100px; height:100px;"></div>
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
            <a href="/u/${userid}/lostrecord" class="btn btn-link btn-link-move" style="text-decoration:none;" id="self">我的发布</a>
            <a href="/u/${userid}/letter" class="btn btn-link btn-link-move" style="text-decoration:none;">我的留言<span class="badge">3</span></a>
            <a href="/user/setprofile" class="btn btn-link btn-link-move" style="text-decoration:none;">基本信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">账户信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">实名认证</a>
        </div>
        <ul class="media-list" style="margin-top:40px;">
            <%
                List<Lostrecord> lostrecords = (ArrayList<Lostrecord>)request.getAttribute("Lostrecord");
                List<Lostmess> lostmesses = (ArrayList<Lostmess>)request.getAttribute("Lostmess");
                for (int i = 0; i < lostrecords.size(); i++)
                {
            %>
            <li class="media">
                <a class="pull-left" href="#">
                    <img class="media-object lost-img" src="<%=lostmesses.get(i).getPicture_list()%>">
                </a>
                <div class="media-body">
                    <div style="padding:30px;">
                        <h4 class="media-heading"><a href="#"><%=lostmesses.get(i).getName()%></a>
                            &nbsp;&nbsp;&nbsp;<span><%=lostmesses.get(i).getBirthday()%></span>
                        </h4>
                        <div>失踪地址：<span><%=lostmesses.get(i).getLost_place()%></span></div>
                        <div style="margin-top:40px;">发布日期：<span><%=lostrecords.get(i).getPubdate()%></span></div>
                    </div>
                </div>
            </li>
            <hr>
            <%
                }
            %>
        </ul>
        <div class="text-center">
            <nav>
                <ul class="pagination">
                    <li><a href="/u/${userid}/lostrecord?nowpage=1">首页</a></li>
                    <li><a href="/u/${userid}/lostrecord?nowpage=${NowPage-1>=1?NowPage-1:1}">上一页</a></li>
                    <li><a href="/u/${userid}/lostrecord?nowpage=${NowPage+1<=MaxPage?NowPage+1:MaxPage}">
                        下一页</a></li>
                    <li><a href="/u/${userid}/lostrecord?nowpage=${MaxPage}">末页</a></li>
                </ul>
            </nav>
        </div>
    </div>

</div>





<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/usermess.js"></script>

<script>

</script>

</body>
</html>

