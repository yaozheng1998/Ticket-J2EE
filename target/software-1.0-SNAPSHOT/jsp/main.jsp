<%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/2/25
  Time: 下午10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Training</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-image: url(../img/training.jpg);background-size: cover">
<div>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand">Training</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="main.action">首页</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <%--<li data-toggle="modal" data-target="#login"><a href="#">登录/注册</a></li>--%>
                    <li><a href="/jsp/insRegister.jsp">机构注册</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="col-md-4 row" style="margin-top:15%;margin-left:50%;background-color: rgba(0,0,0,0.4);">
    <h4 class="modal-title" style="align-items: center;padding-left: 35%;padding-top: 6%;color: whitesmoke">欢迎登录</h4>
    <div class="modal-body">
        <form action="login" method="post" onsubmit="return toLogin()">
            <div class="form-group">
                <input type="name" id="name" name="name" class="form-control" placeholder="请输入会员名或邮箱/场馆注册码/经理码">
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <a href="showRegister.action">注册成为新会员</a>
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/login.js"></script>
</html>
