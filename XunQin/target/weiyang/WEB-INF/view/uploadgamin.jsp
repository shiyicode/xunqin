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
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>寻亲网——发布寻亲信息</title>
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/home.css" rel="stylesheet">
    <link href="/css/filllostmess.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="/js/html5shiv.js"></script>
    <script src="/js/respond.min.js"></script>
    <![endif]-->


    <script type="text/javascript">

        var path;
        var data={};

        function  test(){

            var fileObj = document.getElementById("gaminpicture").files[0];
            var form = new FormData();
            form.append("picture_list", fileObj);
            var link = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
            link.open("post"," /gaminmess/upload",true);
            link.onreadystatechange = function(){
                if(link.readyState == 4 && link.status == 200){

                    alert("图片上传成功！");
                    path = link.responseText;
                }
            };
            link.send(form);

        }

        function test2(){


            var age = document.getElementById("gaminage").value;
            if(age == "" || age == null){

                data.age = "0";
            }else{

                data.age = age;
            }

            var sexs = document.getElementsByName("gaminsex");
            var j = 0;
            for (var i = 0; i < sexs.length; i++) {

                if (sexs[i].checked) {

                        data.sex = sexs[i].value;
                        break;
                }else{

                    j++;
                }
            }
            if(j == sexs.length){

                data.sex = "-1";
            }

            var height = document.getElementById("gaminheight").value;
            if(height == "" || height == null){

                data.height = "0";
            }else{

                data.height = height;
            }


            var find_place = document.getElementById("lostaddress").value;
            if(find_place == "" || find_place == null){

                data.find_place = "无";
            }else{

                data.find_place = find_place;
            }

            var find_time = document.getElementById("gamindate").value;
            if(find_time == "" || find_time == null){

                data.find_time = "null";
            }else{

                data.find_time = find_time;
            }

            if(document.getElementById("gaminfeature").value == "" || document.getElementById("gaminfeature").value == null ){

                data.feature = "无";
            }else{

                data.feature = document.getElementById("gaminfeature").value;
            }

            if(document.getElementById("gaminothermess").value == "" || document.getElementById("gaminothermess").value == null){

                data.other_message = "无";
            }else{

                data.other_message = document.getElementById("gaminothermess").value;
            }

            if(path == null || path == ""){

                data.picture_list = "null";
            }else {
                data.picture_list = path;
            }
            return data;

        }



        function testall(){

            var link = window.XMLHttpRequest?new XMLHttpRequest():new ActiveXObject("Microsoft.XMLHttp");
            link.open("post","/gaminmess/add ",true);
            link.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            link.onreadystatechange=function(){
                if(link.readyState == 4 && link.status == 200){

                    alert("上传成功！");
                }
            };
            var datas = test2();
            link.send("data="+JSON.stringify(datas));

        }
    </script>


</head>

<body>
<!-- 顶部导航 -->
<%@include file="normal_nav.jsp"%>

<!-- 移动设备导航栏 -->
<%@include file="mobile_nav.jsp"%>

<!--主要内容-->

<div class="container" style="margin-top:30px;margin-left:0;margin-right:0">
    <h1 class="h1-header">填写流浪人信息</h1>
    <form class="form-horizontal" role="form" action="" method="post" style="margin-top:30px">

    <div class="form-group" id="input-name">
        <label for="gaminage" class="col-sm-3 control-label">年龄:</label>
        <div class="col-sm-9">
            <input type="text" class="form-control mess" id="gaminage" name="gaminage" autofocus>
        </div>
    </div>

    &nbsp;
    &nbsp;

    <div class="form-group" id="input-sex">
        <label class="col-sm-3 control-label">性别:</label>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <label class="radio-inline">
            <input type="radio"  value="0" name="gaminsex">男&nbsp;&nbsp;&nbsp;
        </label>
        <label class="radio-inline">
            <input type="radio"  value="1" name="gaminsex">女
        </label>
    </div>
    <div class="form-group" id="input-picture">
        <label for="gaminpicture" class="col-sm-3 control-label">照片:</label>
        <div class="col-sm-9">
            <div class="file-style col-md-3">
                <input type="file" onChange="add_files(this.files)" style="width:200px;
			height:250px;opacity:0;cursor:pointer" id="gaminpicture" name="gaminpicture">
            </div>
            <div class="col-md-3 pic-style">
                <img src="" id="pic" style="width:200px; height:250px;">
            </div>
            <div class="col-sm-3">
                <button type="button" class="btn btn-primary" onclick="test();" style="margin-left: 50px;
                    margin-top:200px;">确认图片</button>
            </div>
        </div>
    </div>
    &nbsp;
    &nbsp;
    <div class="form-group" id="input-height">

        <label for="gaminheight" class="col-sm-3 control-label">身高:</label>
        <div class="col-sm-9">
            <input type="text" class="form-control mess" id="gaminheight" name="gaminheight">
        </div>
    </div>
    &nbsp;
    &nbsp;

    <div class="form-group" id="input-date">
        <label for="gamindate" class="col-sm-3 control-label">发现日期:</label>
        <div class="col-sm-9">
            <input type="date" class="form-control mess" id="gamindate" name="gamindate">
        </div>
    </div>
    &nbsp;
    &nbsp;
    <div class="form-group" id="a-address">
        <label for="lostaddress" class="col-sm-3 control-label">发现地址:</label>
        <div class="col-sm-9">
            <div class="col-sm-3">
                <select class="form-control" id="s_province" name="s_province"></select>
            </div>
            <div class="col-sm-3">
                <select class="form-control" id="s_city" name="s_city"></select> 
            </div>
            <div class="col-sm-3">
                <select class="form-control" id="s_county" name="s_county" onChange="showArea()">
                </select>
            </div>
            <div id="show"></div>
        </div>
    </div>
    <div class="form-group" id="b-address">
        <label for="lostaddress" class="col-sm-3 control-label">详细发现地址:</label>
        <div class="col-sm-9">
            <input type="text" class="form-control mess" id="lostaddress" name="lostaddress">
        </div>
    </div>
    &nbsp;
    &nbsp;
    <div class="form-group" id="input-feature">
        <label for="gaminfeature" class="col-sm-3 control-label">特征描述:</label>
        <div class="col-sm-9">
            <textarea rows="4" type="text" class="form-control mess" id="gaminfeature" name="gaminfeature"></textarea>
        </div>
    </div>
    &nbsp;
    &nbsp;
    <div class="form-group" id="input-othermess">
        <label for="gaminothermess" class="col-sm-3 control-label">其他备注信息:</label>
        <div class="col-sm-9">
            <textarea rows="4" type="text" class="form-control mess" id="gaminothermess" name="gaminothermess"></textarea>
        </div>
    </div>
    <br><br>
    <div class="form-group">
        <div class="col-sm-offset-6 col-sm-9">
            <button type="button" class="btn btn-primary" onclick="testall();">提交</button>
            <input type="reset" class="btn btn-primary" style="margin-left:50px" />
            <span id="myDiv" style="display:none; color: red;">必填项不能为空！</span>
        </div>
    </div>
</form>


</div>



<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/filllostmess.js"></script>
<script src="/js/area.js" type="text/javascript"></script>

<script type="text/javascript">
    _init_area();
    _init_place();


</script>

</body>
</html>
