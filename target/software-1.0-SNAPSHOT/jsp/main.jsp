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
    <title>Ticket</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-image: url(../img/ticket.jpg);background-size: cover">
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
                <a class="navbar-brand">Ticket</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="main.action">首页</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li data-toggle="modal" data-target="#login"><a href="#">登录/注册</a></li>
                    <li><a href="#">场馆版</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div class="col-md-4 row" style="margin-top:15%;margin-left:10%;background-color: rgba(0,0,0,0.4);">
    <h4 class="modal-title" style="align-items: center;padding-left: 35%;padding-top: 6%;color: whitesmoke">欢迎登录</h4>
    <div class="modal-body">
        <form action="" method="post" onsubmit="return toLogin()">
            <div class="form-group">
                <input type="name" id="name" name="name" class="form-control" placeholder="请输入会员名或邮箱">
            </div>
            <div class="form-group">
                <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <a data-toggle="modal" data-target="#vip-register" data-dismiss="modal" class="text-center">注册成为新会员</a>
                </div>
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal fade" tabindex="-1" role="dialog" id="vip-register" style="margin-top: 10%">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" style="align-items: center;padding-left: 3%">注册新会员</h4>
            </div>
            <div class="modal-body">
                <form action="" method="post" onsubmit="return toRegister()">
                    <div class="form-group">
                        <input type="text" name="vipName" id="vipName" class="form-control" placeholder="请输入会员名">
                    </div>
                    <div class="form-group">
                        <input type="password" name="passwd" id="pwd" class="form-control" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <input type="password" name="confirmpwd" id="cpwd" class="form-control" placeholder="请再次输入密码">
                    </div>
                    <div class="form-group">
                        <input type="number" name="bandCardId" id="bankCardId" class="form-control"
                               placeholder="请输入银行卡号">
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <a data-toggle="modal" data-target="#login" data-dismiss="modal"
                               class="text-center">已经是会员了</a>
                        </div>
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</div>
</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</html>
