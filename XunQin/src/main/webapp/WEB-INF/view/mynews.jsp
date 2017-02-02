<%--
  Created by IntelliJ IDEA.
  User: 塞上江南果
  Date: 2017/1/19
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.web.entity.Usermess" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.web.entity.Letter" %>

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
            <a href="/u/${userid}/lostrecord" class="btn btn-link btn-link-move" style="text-decoration:none;">我的发布</a>
            <a href="/u/${userid}/letter" class="btn btn-link btn-link-move" style="text-decoration:none;" id="self">我的留言<span class="badge">3</span></a>
            <a href="/user/setprofile" class="btn btn-link btn-link-move" style="text-decoration:none;">基本信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">账户信息</a>
            <a href="#" class="btn btn-link btn-link-move" style="text-decoration:none;">实名认证</a>
        </div>
        <div class="write-letter">
            <div class="leave-it">发表你的留言</div>
            <textarea rows="4" type="text" class="form-control mess" id="write-mess" name="write-mess"
                      autofocus placeholder="写下你的留言吧……" style="width:100%">
            </textarea>
            <input type="button" class="btn btn-sm btn-primary" value="发表" onclick="test()">
        </div>
        <hr>
        <ul class="media-list" style="margin-top:40px;" id="list">
            <% List<Usermess> usermesses = (ArrayList<Usermess>)request.getAttribute("Usermess");
                List<Letter> letters = (ArrayList<Letter>)request.getAttribute("Letter");
                for (int i = 0; i < usermesses.size(); i++)
                {
            %>
            <li class="media">
            <a class="pull-left" href="#">
                <img class="media-object" src="/images/<%=usermesses.get(i).getPicture()%>" style="width:50px; height:50px">
            </a>
            <div class="media-body">
                <div  id="<%=letters.get(i).getFromuser_id()%>body">
                    <h4 class="media-heading" style="color:#1b435d"><%=usermesses.get(i).getUsername()%></h4>
                    <div><%=letters.get(i).getContent()%></div>
                    <div style="margin-top:40px;"><span><%=letters.get(i).getCreatedate()%></span>&nbsp;&nbsp;&nbsp;<span style="color:#1b435d;" onclick="reply('<%=usermesses.get(i).getUsername()%>')">回复</span></div>
                </div>
                <div style="display:none" id="<%=letters.get(i).getFromuser_id()%>">
                        <textarea rows="3" type="text" class="form-control mess" id="me<%=letters.get(i).getFromuser_id()%>" name="me">

                        </textarea>
                    <input type="button" class="btn btn-sm btn-primary" value="提交" onclick="insert('<%=letters.get(i).getFromuser_id()%>body','me<%=letters.get(i).getFromuser_id()%>')">
                    <input type="button" class="btn btn-sm btn-default" value="取消" onclick="cancel('<%=letters.get(i).getFromuser_id()%>')">
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
                    <li><a href="/u/${userid}/letter?nowpage=1">首页</a></li>
                    <li><a href="/u/${userid}/letter?nowpage=${NowPage-1>=1?NowPage-1:1}">上一页</a></li>
                    <li><a href="/u/${userid}/letter?nowpage=${NowPage+1<=MaxPage?NowPage+1:MaxPage}">
                        下一页</a></li>
                    <li><a href="/u/${userid}/letter?nowpage=${MaxPage}">末页</a></li>
                </ul>
            </nav>
        </div>

    </div>

</div>





<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/usermess.js"></script>

<script>
    function reply(username)
    {
        document.getElementById("write-mess").value='@'+username+':';
    }

    function test()
    {
        var req=null;
        if (window.XMLHttpRequest){
            req = new XMLHttpRequest();
        }else{
            req = new ActiveXObject("Microsoft.XMLHTTP");
        }
        if(req!=null){
            req.open('post','/u/${userid}/addLetter',true);
            req.setRequestHeader("Content-Type",
                    "application/x-www-form-urlencoded");
            req.onreadystatechange = function () {
                if(req.readyState==4){
                    var result = req.responseText;
                    alert(result);
                }
            }
            var mess=document.getElementById("write-mess").value;
            req.send('text='+mess);
        }
    }
</script>

</body>
</html>

