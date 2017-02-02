<%--
Created by IntelliJ IDEA.
User: shiyi
Date: 2016/12/20
Time: 下午4:15
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.web.entity.Usermess" %>
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
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->

    <script type="text/javascript">

        var path;
        function  test(){

            var fileObj = document.getElementById("idfrontpic").files[0];
            var form = new FormData();
            form.append("picture_list", fileObj);
            var link = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
            link.open("post"," /user/upload",true);
            link.onreadystatechange = function(){
                if(link.readyState == 4 && link.status == 200){

                    alert("图片上传成功！");
                    path = link.responseText;
                }
            };
            link.send(form);

        }
    </script>

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
            <div class="col-md-2" style="padding:5%;"><img src="/images/${Usermess.picture}" style="width:100px; height:100px;"></div>
            <div class="col-md-5" style="padding:5%;">
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
            <a href="/u/${userid}/lostrecord" class="btn btn-link btn-link-move" style="text-decoration:none;">我的发布</a>
            <a href="/u/${userid}/letter" class="btn btn-link btn-link-move" style="text-decoration:none;">我的留言<span class="badge">3</span></a>
            <a href="/user/setprofile" class="btn btn-link btn-link-move" style="text-decoration:none;" id="self">基本信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">账户信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">实名认证</a>
        </div>
        <form class="form-horizontal" role="form" action="/user/setprofile" method="post" style="margin-top:40px">
            <%
                Usermess usermess = (Usermess)request.getAttribute("Usermess");
            %>
            <div class="form-group" id="input-name">
                <label id="lostname" class="col-sm-3 control-label">昵称:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control mess" value="${Usermess.username}" id="username" name="username" autofocus placeholder="请输入你的昵称">
                </div>
            </div>
            <div class="form-group" id="input-sex">
                <label id="lostsex" class="col-sm-3 control-label">性别:</label>
                <%
                    if (usermess.getSex() == 0)
                    {
                %>
                <label class="radio-inline">
                    <input type="radio"  value="1" name="usersex" style="margin-left:10px">男
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="0" name="usersex"  checked>女
                </label>
                <%
                    }
                    else
                    {
                %>
                <label class="radio-inline">
                    <input type="radio"  value="1" name="usersex" style="margin-left:10px" checked>男
                </label>
                <label class="radio-inline">
                    <input type="radio"  value="0" name="usersex">女
                </label>
                <%
                    }
                %>

            </div>
            <div class="form-group" id="input-picture">
                <label id="lostpicture" class="col-sm-3 control-label">图像:</label>
                <div class="col-sm-9">
                    <div class="file-style col-md-3" id="pic1" align="center">
                        <font style="font-size:80px" id="plus1">+</font><br>
                        <font id="front">修改图像</font>
                        <input type="file" onChange="add_files(this.files)" style="width:100%;
                height:230px; opacity:0;cursor:pointer;z-index:999;margin-top:-138px" id="idfrontpic" name="idfrontpic">
                    </div>
                    <div class="col-sm-3 pic-style">
                        <img src="/images/<%=usermess.getPicture()%>" id="pic" style="width:220px; height:230px;">
                    </div>
                    <div class="col-sm-3">
                        <button type="button" class="btn btn-primary" onclick="test();" style="margin-left: 50px;
                    margin-top:200px;">确认图片</button>
                    </div>
                </div>
            </div>
            <div class="form-group" id="input-birthday">
                <label id="lostbirthday" class="col-sm-3 control-label">年龄:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control mess" value="<%=usermess.getAge()%>" id="userage" name="userage" placeholder="输入你的年龄">
                </div>
            </div>
            <div class="form-group" id="input-address">
                <label id="lostaddress" class="col-sm-3 control-label">籍贯:</label>
                <div class="col-sm-9">
                    <div class="col-sm-3 address-padding">
                        <select class="form-control" id="s_province" name="s_province"></select>
                    </div>
                    <div class="col-sm-3 address-padding" id="city">
                        <select class="form-control" id="s_city" name="s_city"></select> 
                    </div>
                    <div class="col-sm-3 address-padding">
                        <select class="form-control" id="s_county" name="s_county" onChange="showArea()">
                        </select>
                    </div>
                    <div id="show"></div>
                </div>
            </div>
            <div class="form-group" id="input-fulladdress">
                <label for="lostaddress" class="col-sm-3 control-label">详细地址:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control mess" value="陕西省西安市长安区" id="useraddress" name="useraddress" placeholder="输入你的详细地址">
                </div>
            </div>

            <div class="form-group" id="input-balance">
                <label for="lostaddress" class="col-sm-3 control-label">账户余额:</label>
                <div class="col-sm-9">
                    <input type="text" class="form-control mess" value="<%=usermess.getAccount_balance()%>元" id="userbalance" name="userbalance" disabled>
                </div>
            </div>

            <br><br>
            <div class="form-group">
                <div class="col-sm-9">
                    <button type="submit" class="btn btn-primary btn-margin-left">提交</button>
                    <button type="reset" class="btn btn-primary" style="margin-left:10%">重置
                    </button>
                </div>
            </div>

        </form>
    </div>

</div>



<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/usermess.js"></script>
<script src="/js/area.js" type="text/javascript"></script>

<script type="text/javascript">
    _init_area();
    _init_place();

    function showArea(){
        var province = document.getElementById("s_province").value;
        var city = document.getElementById("s_city").value;
        var country = "";
        var sel = document.getElementById("s_county");
        country = sel.options[sel.selectedIndex].value;
        document.getElementById("useraddress").value = province + city + country;
    }

</script>

</body>
</html>
