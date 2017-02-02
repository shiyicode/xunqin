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
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">账户信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;" id="self">实名认证</a>
        </div>
        <form class="form-horizontal" role="form" action="" method="post" style="margin-top:30px;">

            <div class="form-group" id="input-realname">
                <label for="lostname" class="col-sm-3 control-label">真实姓名:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control mess" id="userrealname" name="userrealname" autofocus placeholder="请输入你的真实姓名">
                    </div>
            </div>
            
            <div class="form-group" id="input-realname">
                <label for="lostname" class="col-sm-3 control-label">身份证号:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control mess" id="useridnum" name="useridnum" placeholder="请输入你的身份证号">
                    </div>
            </div>
            
            <div class="form-group" id="input-picture">
                    <label for="lostpicture" class="col-sm-3 control-label">身份证照片:</label>
                    <div class="col-sm-9">
                        <div class="file-style col-md-3" id="pic1" align="center">
                            <font style="font-size:80px" id="plus1">+</font><br>
                            <font id="front">上传身份证正面图片</font>
                            <input type="file" onChange="add_files1(this.files)" style="width:100%;
                height:230px; opacity:0;cursor:pointer;z-index:999;margin-top:-138px" id="idfrontpic" name="idfrontpic">
                        </div>
                         <div class="file-style col-md-3" style="margin-left:6%" align="center" id="pic2">
                            <font style="font-size:80px" id="plus2">+</font><br>
                            <font id="reverse">上传身份证正面图片</font>
                            <input type="file" onChange="add_files2(this.files)" style="width:100%;
                height:230px; opacity:0;cursor:pointer;z-index:999;margin-top:-138px" id="idreversepic" name="idreversepic">
                        </div>
                    </div>
                </div>
            
            <br><br>
            <div class="form-group">
                <div class="col-sm-9">
                    <button type="button" class="btn btn-primary btn-margin-left">提交</button>
                    <button type="submit" class="btn btn-primary" style="margin-left:10%">重置
                    </button>
                </div>
            </div>
                
    </form>
     </div>
            
</div>



<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/usermess.js"></script>

<script>
var pic;
function add_files1(files) 
{
    if (files.length){
        var file = files[0];
        var reader = new FileReader();
        reader.onload = function(e) {
        document.getElementById("pic1").style.backgroundImage = "url("+e.target.result+")";
        document.getElementById("pic1").style.backgroundSize="215px 230px";
        document.getElementById("plus1").style.display = "none";
        document.getElementById("front").style.display = "none";
        pic = e.target.result;
        }
        reader.readAsDataURL(file);
    }
}

function add_files2(files) 
{
    if (files.length){
        var file = files[0];
        var reader = new FileReader();
        reader.onload = function(e) {
        document.getElementById("pic2").style.backgroundImage = "url("+e.target.result+")";
        document.getElementById("pic2").style.backgroundSize="215px 230px";
        document.getElementById("plus2").style.display = "none";
        document.getElementById("reverse").style.display = "none";
        pic = e.target.result;
        }
        reader.readAsDataURL(file);
    }
}

</script> 

</body>
</html>

