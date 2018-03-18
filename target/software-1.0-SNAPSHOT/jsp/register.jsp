<%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/2/27
  Time: 下午3:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>会员注册</title>
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
                    <!--<li data-toggle="modal" data-target="#login"><a href="#">登录/注册</a></li>-->
                    <li><a href="/jsp/insRegister.jsp">机构注册</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="col-md-4 row" style="margin-top:12%;margin-left:50%;background-color: rgba(0,0,0,0.4);">
    <h4 class="modal-title" style="align-items: center;padding-left: 35%;padding-top: 6%;color: whitesmoke">注册会员</h4>
    <div class="modal-body">
        <form action="register" method="post" onsubmit="return toRegister()">
            <div class="form-group">
                <input type="name" id="r_name" name="r_name" class="form-control" placeholder="取一个会员名">
            </div>
            <div class="form-group">
                <input type="password" id="r_password" name="r_password" class="form-control" placeholder="输入密码">
            </div>
            <div class="form-group">
                <input type="password" id="r_confirmPass" name="r_confirmPass" class="form-control" placeholder="确认密码">
            </div>
            <div class="form-group">
                <input type="number" id="r_bankcardId" name="r_bankcardId" class="form-control" placeholder="请输入要绑定的银行卡号码">
            </div>
            <div class="form-group">
                <input type="email" id="r_mailbox" name="r_mailbox" class="form-control" placeholder="输入电子邮箱以验证">
            </div>
            <%--<div class="row">--%>
                <%--<div class="col-xs-6">--%>
                    <%--<input type="number" id="r_validate" name="r_validate" placeholder="验证码">--%>
                <%--</div>--%>
                <%--<div class="col-xs-6">--%>
                    <%--<a href="send_valid.action">点按以发送验证码</a>--%>
                    <%--&lt;%&ndash;<button id="valid_btn" style="margin-left: -40px;" type="button" class="btn btn-sm" onclick="">点按以发送验证码</button>&ndash;%&gt;--%>
                <%--</div>--%>
            <%--</div>--%>
            <br>
            <div class="row">
                <div class="col-xs-8">
                    <a href="main.action">已有账号，去登录吧~</a>
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/register.js"></script>
</html>