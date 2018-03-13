<%@ page import="model.Institution" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/13
  Time: 下午6:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>InsBasic</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%
    Institution institution=(Institution) session.getAttribute("insInfo");
%>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" style="margin-left: -50px">Training机构版</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <!--<ul class="nav navbar-nav">-->
            <!--<li><a href="../jsp/main.jsp">首页</a></li>-->
            <!--</ul>-->
            <div id="memberDiv"
                 style="position: absolute;top: 15px;left: 950px;width: 150px;height: 30px;color: black">
                <label>欢迎您, </label>
                <p id="name" style="position:absolute;top:0px;left:50px;width:70px;height:20px"><%=institution.getIns_name()%></p>
            </div>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation" class="active"><a href="showInsBasicInfo"><h5 style="padding-left: 15px">基本信息</h5></a></li>
        <li role="presentation"><a href="showAllClasses"><h5 style="padding-left: 15px">机构计划</h5></a></li>
        <li role="presentation"><a href=""><h5 style="padding-left: 15px">学员登记</h5></a></li>
        <li role="presentation"><a href=""><h5 style="padding-left: 15px">机构统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>基本信息</legend>
    <a href="#" onclick="modify()"
       style="color: #1ab7ea; float: right; margin-right: 10px;"><b>修改信息</b></a>
    <form action="modifyIns" method="post" class="form-horizontal">
        <div class="form-group">
            <label for="f-insId" class="col-sm-3 control-label">机构编号:</label>
            <div class="col-sm-4">
                <span id="f-insId" class="form-control" style="border: none"><%=institution.getIns_id()%></span>
            </div>
        </div>

        <div class="form-group">
            <label for="f-insname" class="col-sm-3 control-label">机构名:</label>
            <div class="col-sm-4">
                <label class="form-control" id="f-insname" style="border: none"><%=institution.getIns_name()%></label>
                <input id="name_input" name="insName" value="<%=institution.getIns_name()%>"
                       style="position: absolute; left: 20px;margin-top: -30px; width: 250px; visibility: hidden;">
            </div>
        </div>

        <div class="form-group">
            <label for="f-insloc" class="col-sm-3 control-label">机构地点:</label>
            <div class="col-sm-4">
                <span id="f-insloc" class="form-control" style="border: none"><%=institution.getLocation()%></span>
                <input id="loc_input" name="insLocation" value="<%=institution.getLocation()%>"
                       style="position: absolute; left: 20px;margin-top: -30px; width: 250px; visibility: hidden;">
            </div>
        </div>

        <div class="form-group">
            <label for="f-num" class="col-sm-3 control-label">班级数目:</label>
            <div class="col-sm-4">
                <label class="form-control" id="f-num" style="border: none"><%=institution.getClassrooms()%>
                </label>
                <input id="num_input" name="insNum" value="<%=institution.getClassrooms()%>"
                       style="position: absolute; left: 20px;margin-top: -30px; width: 250px; visibility: hidden;">
            </div>
        </div>
        <button type="submit" id="save" style="margin-left: 45%;margin-top: 25px;visibility: hidden" class="btn btn-default btn-primary btn-sm">保存</button>
    </form>
</fieldset>
</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script>
    function modify(){
        document.getElementById("f-insname").style.visibility = "hidden";
        document.getElementById("f-insloc").style.visibility = "hidden";
        document.getElementById("f-num").style.visibility = "hidden";
        document.getElementById("name_input").style.visibility = "";
        document.getElementById("loc_input").style.visibility = "";
        document.getElementById("num_input").style.visibility = "";
        document.getElementById("save").style.visibility = "";
    }
</script>
</html>