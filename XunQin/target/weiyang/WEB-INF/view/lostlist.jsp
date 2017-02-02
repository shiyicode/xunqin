<%--
  Created by IntelliJ IDEA.
  User: hjh
  Date: 16-12-18
  Time: 下午3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.web.entity.Lostmess" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网——寻人库</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/xunqin.css" rel="stylesheet">
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

        .container
        {
            margin:0px auto;
            padding:0px;
            width:100%;
        }

        .beforeground
        {
            width:100%;
            position:absolute;
            height:380px;
            opacity: 0.4;
            background:#004a7c;
            z-index:9
        }

        * {
            box-sizing: border-box;
        }

        .containers {
            padding: 1rem;
            margin: 3rem auto;
            border-radius: 0.2rem;
            text-align: center;
            margin-top: 80px;
        }

        .containers ul {
            width: 100%;
        }


        .large {
            width: 50rem;
        }

        .containers ul, li {
            list-style: none;
            display: inline;
            padding-left: 0px;
            font-family: "Droid Sans","Helvetica Neue", Helvetica, Arial, sans-serif;
        }

        .containers li:hover a {
            color: #fdfdfd;
            background-color: #1d1f20;
            border: solid 1px #1d1f20;
        }
        .containers li.active a {
            color: #fdfdfd;
            background-color: #1d1f20;
            border: solid 1px #1d1f20;
        }
        .containers li:first-child {
            float: left;
        }

        .containers li:last-child {
            float: right;
        }

        .containers li a {
            border: solid 1px #d6d6d6;
            border-radius: 0.2rem;
            color: #7d7d7d;
            text-decoration: none;
            text-transform: uppercase;
            display: inline-block;
            text-align: center;
            padding: 0.5rem 0.9rem;
        }


        .dispare{

            border-radius: 0.2rem;
            color: #7d7d7d;
            text-decoration: none;
            text-transform: uppercase;
            display: inline-block;
            text-align: center;
            padding: 0.5rem 0.9rem;

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
                    <li><a href="#"><img src="/images/4.jpg" class="img-circle" style="height:50px;width:50px"></a></li>
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

<!--背景-->
<div class="carousel slide" style="height:380px">
    <div class="carousel-inner">
        <div class="item active" style="height:380px">
            <div class="beforeground"></div>
            <img src="/images/66.jpg" alt="背景">
            <div class="container">
                <div class="carousel-caption" style="z-index:999">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-8 ad">
                                <div class="row">
                                    <div class="col-md-3" style="margin-top:50px">
                                        <font class="help-word">已帮助人发布寻人信息</font>
                                    </div>
                                    <div class="col-md-9">
                                        <%
                                            int lostNum = (Integer) request.getAttribute("lostMessCount");
                                        %>

                                        <font class="font-num"><%=lostNum/10000%10%></font>
                                        <font class="font-num"><%=lostNum/1000%10%></font>
                                        <font class="font-num"><%=lostNum/100%10%></font>
                                        <font class="font-num"><%=lostNum/10%10%></font>
                                        <font class="font-num"><%=lostNum%10%></font>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="row sure">
                                    <font>发布寻亲启事</font>
                                    <a href="/lostmess/uploads" class="btn btn-primary">发布信息</a>
                                </div>
                                <div class="row sure" style="margin-top:20px">
                                    <font>信息还不全？</font>
                                    <div class="btn btn-primary">完善信息</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 顶部导航 -->
<div class="navbar nav-style" role="navigation" style="margin-top:-380px">
    <div class="container">
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="/home/" class="nav-font-color">寻亲网</a></li>
                <li class="active"><a href="#" class="nav-font-color">寻亲库</a></li>
                <li><a href="#" class="nav-font-color">资料库</a></li>
                <li><a href="#" class="nav-font-color">论坛</a></li>
                <li><a href="#" class="nav-font-color">关于</a></li>
                <%
                    Integer hh_userid = (Integer) session.getAttribute("userid");
                    if(hh_userid != null){
                %>
                <li style="margin-left:600px;display:none"><a href="#"><img class="img-circle" src="/images/4.jpg" style="width:40px; height:40px"></a></li>
                <%
                    }
                    else{
                %>
                <li style="margin-left:600px;"><a href="/goto/login" class="nav-font-color">登录</a></li>
                <li><a href="/goto/register" class="nav-font-color">注册</a></li>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</div>

<div class="container">
    <div align="center">
        <a class="btn btn-color">全部</a>
        <a class="btn btn-color">宝贝寻家</a>
        <a class="btn btn-color">家寻宝贝</a>
    </div>
</div>


<!--主要内容-->
<div class="container" style="background:#e1eacd;margin-top:20px">
    <div class="row" style="margin:30px 10%">
        <%
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            List<Lostmess> lists = (List<Lostmess>)request.getAttribute("lostList");
            for(Lostmess list : lists)
            {
                String years = list.getBirthday().substring(0,4);
                int birthyear = Integer.parseInt(years);
                int age = year - birthyear;
                int id = list.getId();
                String[] temp = list.getPicture_list().split(";");
                String picture = "/image/4.jpg";
                if(temp.length != 0)
                    picture = temp[0];

                String sex;
                if(list.getSex() == 0)
                    sex = "男";
                else if(list.getSex() == 1)
                    sex = "女";
                else
                    sex = "未知";
        %>
        <div class="col-md-3" style="padding-bottom: 15px;padding-top: 15px">
            <div class="card">
                <a href="/lostmess/<%=id%>" class="before">                </a>

                <img href="" src="<%=picture%>">

                <div class="message" href="/lostmess/<%=id%>">
                    <div>姓名：<font><%=list.getName()%></font></div>
                    <div>年龄：<font><%=age%></font>性别：<font><%=sex%></font></div>
                    <%--<div>籍贯：<font><%=list.getNative_place()%></font></div>--%>
                </div>
            </div>
        </div>
        <%
            }
        %>
    </div>

</div>
    <%
        int pagemax = (Integer) request.getAttribute("pagemax");
        int pagenow = (Integer) request.getAttribute("pagenow");
    %>

    <div class="containers large">
        <ul>
            <%--first--%>
            <% if(pagemax > 1){ %>
            <li><a href="/lostmess/list?thenstart=<%=pagenow - 1%>&type=0">PREVIOUS</a></li>
            <% } %>

            <%--less 10--%>
            <%
                if(pagemax <= 10){
                    for(int i = 1; i < pagenow; i++){
            %>
            <li><a href="/lostmess/list?thenstart=<%=i%>&type=0"><%=i%></a></li>
            <%
                }
            }
            else {
                if(pagenow <= 8){
                    for(int i = 1; i <= 8; i++){
                        if(pagenow == i) {
            %>
            <li class="active"><a href="/lostmess/list?thenstart=<%=i%>&type=0"><%=i%></a></li>
            <%
            }
            else{
            %>
            <li><a href="/lostmess/list?thenstart=<%=i%>&type=0"><%=i%></a></li>
            <%
                    }
                }
            %>
            <li><span class="dispare">...</span></li>
            <li><a href="/lostmess/list?thenstart=<%=pagemax%>&type=0"><%=pagemax%></a></li>
            <%
            }
            else if(pagenow >= pagemax-7){
            %>
            <li><a href="/lostmess/list?thenstart=1&type=0">1</a></li>
            <li><span class="dispare">...</span></li>
            <%
                for(int i = pagemax-7; i <= pagemax; i++){
                    if(pagenow == i) {
            %>
            <li class="active"><a href="/lostmess/list?thenstart=<%=i%>&type=0"><%=i%></a></li>
            <%
            }
            else{
            %>
            <li><a href="/lostmess/list?thenstart=<%=i%>&type=0"><%=i%></a></li>
            <%
                    }
                }
            }
            else {
            %>
            <li><a href="/lostmess/list?thenstart=1&type=0">1</a></li>
            <li><span class="dispare">...</span></li>
            <%
                for(int i=pagenow-2; i<=pagenow+3; i++)
                {
                    if(pagenow == i) {
            %>
            <li class="active"><a href="/lostmess/list?thenstart=<%=i%>&type=0"><%=i%></a></li>
            <%
            }
            else{
            %>
            <li><a href="/lostmess/list?thenstart=<%=i%>&type=0"><%=i%></a></li>
            <%
                    }
                }
            %>
            <li><span class="dispare">...</span></li>
            <li><a href="/lostmess/list?thenstart=<%=pagemax%>&type=0"><%=pagemax%></a></li>

            <%
                    }
                }
            %>


            <%--end--%>
            <%
                if(pagenow < pagemax){
            %>
            <li><a href="/lostmess/list?thenstart=<%=pagenow+1%>&type=0" style="margin-right: -40px;">NEXT</a></li>
            <% } %>

        </ul>
    </div>

</div>


<hr>



<footer>
    <!--第三方账号-->
    <div class="container" style="margin-left:30px">
        <div class="row">
            <a href="#"><img src="/images/qq.png" class="third-img"></a>
            <a href="#"><img src="/images/weixin.png" class="third-img"></a>
            <a href="#"><img src="/images/weibo.png" class="third-img"></a>
        </div>
    </div>


    <div class="navbar" role="navigation">
        <div class="container">
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#">网站首页</a></li>
                    <li><a href="#">联系我们</a></li>
                    <li><a href="#">关于我们</a></li>
                </ul>
            </div>
        </div>
    </div>
    <p class="pull-right"><a href="#top">回到顶部</a></p>
    <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&copy; 2016  &nbsp;寻亲网 </p>
</footer>

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script>

</script>
</body>
</html>
