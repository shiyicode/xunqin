<%--
  Created by IntelliJ IDEA.
  User: shiyi
  Date: 2016/12/19
  Time: 下午6:18
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

<!-- 顶部导航 -->
<%@include file="normal_nav.jsp"%>

<!-- 移动设备导航栏 -->
<%@include file="mobile_nav.jsp"%>

<%
    Calendar cal = Calendar.getInstance();
    int year = cal.get(Calendar.YEAR);
    Lostmess lostmess = (Lostmess)request.getAttribute("lostmess");

    String find_type = lostmess.getFind_type() == 0 ? "家寻宝贝" : "宝贝寻家";

    String sex;
    if(lostmess.getSex() == 0)
        sex = "男";
    else if(lostmess.getSex() == 1)
        sex = "女";
    else
        sex = "未知";

    String years = lostmess.getBirthday().substring(0,4);
    int birthyear = Integer.parseInt(years);
    int age = year - birthyear;

    String bolld_type;
    switch(lostmess.getBlood_type())
    {
        case 0: bolld_type = "A"; break;
        case 1: bolld_type = "B"; break;
        case 2: bolld_type = "AB"; break;
        case 3: bolld_type = "O"; break;
        case 4: bolld_type = "其他"; break;
    }

    String[] pictureList = lostmess.getPicture_list().split(";");
    String firstPicture = "/images/4.jpg";
    if(pictureList.length > 0)
        firstPicture = pictureList[0];

    String data = lostmess.getLost_date();
    if(data == null)
        data = "";

    if(data.length() > 10)
        data.substring(0, 10);
%>


<div class="container" style="background:#f7f7f7;padding:0;margin:0;width:100%;">
    <div class="all-mess">
        <div class="kuang">
            <div class="name"><font style="margin-left:10%;"><%=lostmess.getName()%></font></div>
            <div style="margin-top:10px;margin-left:5%;">
                <div>
                    <a class="btn btn-color-font" style="border-right:#718CA1 solid 1px">类别：<font color="#fff"><%=find_type%></font></a>
                    <a href="#" style="margin-left:45%"><img class="img-circle" style="width:50px; height:50px;" src="/images/11.jpg" title="发布者"></a>
                </div>
            </div>
        </div>

        <div class="row" style="margin:20px 0;">
            <div class="col-md-7-border">

                <div class="carousel-border">
                    <div id="ad-carousel" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#ad-carousel" data-slide-to="0" class="active"></li>
                            <%
                                int j = 1;
                                while(j < pictureList.length)
                                {
                            %>
                            <li data-target="#ad-carousel" data-slide-to="<%=j+1%>"></li>
                            <%
                                    j++;
                                }
                            %>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="<%=firstPicture%>" alt="1 slide" >
                            </div>
                            <%
                                int i = 1;
                                while(i < pictureList.length)
                                {
                            %>
                            <div class="item">
                                <img src="<%=pictureList[i]%>" alt="<%=i+1%> slide">
                            </div>
                            <%
                                    i++;
                                }
                            %>
                        </div>
                        <a class="left carousel-control" href="#ad-carousel" data-slide="prev"><span
                                class="glyphicon glyphicon-chevron-left"></span></a>
                        <a class="right carousel-control" href="#ad-carousel" data-slide="next"><span
                                class="glyphicon glyphicon-chevron-right"></span></a>
                    </div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">姓名：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getName()%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">性别：</div>
                    <div class="col-md-9 mess-content"><%=sex%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">生日：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getBirthday().substring(0, 10)%>（现年<%=age%>岁）</div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">籍贯：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getNative_place()%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">身高：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getHeight()%>cm</div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">失踪日期：</div>
                    <div class="col-md-9 mess-content"><%=data%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">失踪地点：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getLost_place()%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">特征：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getFeature()%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">其他信息：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getOther_message()%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">联系电话：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getPhone()%></div>
                </div>
                <div class="row row-offset">
                    <div class="col-md-2 mess-font-color">联系邮箱：</div>
                    <div class="col-md-9 mess-content"><%=lostmess.getEmail()%></div>
                </div>

            </div>
        </div>
    </div>

</div>

<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

<script type="text/javascript">
    $(function () {
        $('#ad-carousel').carousel();

    });
</script>

</body>
</html>
