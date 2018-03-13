<%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/2/27
  Time: 下午3:55
  To change this template use File | Settings | File Templates.
--%>
<%--会员信息：个人信息查看及修改，会员积分兑换，等级查看，注销会员--%>
<%@ page import="model.Vip" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>VIPBasic</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>

<%
    Vip vip=(Vip) request.getAttribute("vip");
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
            <a href="showCourse.action" class="navbar-brand" style="margin-left: -50px">Training</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="showCourse.action">首页</a></li>
                <li><a href="vipBasicInfo.action">个人信息</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/jsp/insRegister.jsp">机构注册</a></li>
            </ul>
            <div id="memberDiv"
                 style="position: absolute;top: 15px;left: 950px;width: 150px;height: 30px;color: black">
                <label>欢迎您, </label>
                <p id="name" style="position:absolute;top:0px;left:50px;width:70px;height:20px"><%=vip.getVipName()%></p>
            </div>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation" class="active"><a href="vipBasicInfo.action"><h5 style="padding-left: 15px">会员信息</h5></a></li>
        <li role="presentation"><a href="showMyClasses.action"><h5 style="padding-left: 15px">我的课程</h5></a></li>
        <li role="presentation"><a href=""><h5 style="padding-left: 15px">购买统计</h5></a></li>
    </ul>
</div>



<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>会员信息</legend>
    <a href="#" onclick="modify()"
       style="color: #1ab7ea; float: right; margin-right: 10px;"><b>修改资料</b></a>

    <form action="modifyVIP" method="post" class="form-horizontal">
        <%--<div class="form-group">--%>
            <%--<label for="f-vipId" class="col-sm-3 control-label">会员编号:</label>--%>
            <%--<div class="col-sm-4">--%>
                <%--<label class="form-control" id="f-vipId" style="border: none"><%=vip.getVipId()%></label>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="form-group">
            <label for="f-vipName" class="col-sm-3 control-label">会员名:</label>
            <div class="col-sm-4">
                <span id="f-vipName" class="form-control" style="border: none"><%=vip.getVipName()%></span>
                <input id="name_input" name="vipName" value="<%=vip.getVipName()%>"
                       style="position: absolute; left: 20px;margin-top: -30px; width: 250px; visibility: hidden;">
            </div>
        </div>

        <div class="form-group">
            <label for="f-vipMailbox" class="col-sm-3 control-label">邮箱:</label>
            <div class="col-sm-4">
                <label class="form-control" id="f-vipMailbox" style="border: none"><%=vip.getMailbox()%></label>
            </div>
        </div>

        <div class="form-group">
            <label for="f-vipBankcard" class="col-sm-3 control-label">银行卡号:</label>
            <div class="col-sm-4">
                <span id="f-vipBankcard" class="form-control" style="border: none"><%=vip.getVip_bankCardId()%></span>
                <input id="bankCard_input" name="bankCardId" value="<%=vip.getVip_bankCardId()%>"
                       style="position: absolute; left: 20px;margin-top: -30px; width: 250px; visibility: hidden;">
            </div>
        </div>

        <div class="form-group">
            <label for="f-vipGrade" class="col-sm-3 control-label">会员等级:</label>
            <div class="col-sm-4">
                <label class="form-control" id="f-vipGrade" style="border: none">
                    <%--<%if(vip.getVipLevel().equals("CROWN"))%>--%>
                    <%--皇冠会员--%>
                        <%=vip.getVipLevel()%>会员
                </label>
            </div>
        </div>

        <div class="form-group">
            <label for="f-vipPoint" class="col-sm-3 control-label">会员积分:</label>
            <div class="col-sm-4">
                <label class="form-control" id="f-vipPoint" style="border: none">
                    <%=vip.getVipPoint()%>
                </label>
            </div>
            <button type="button" class="btn btn-info btn-sm" onclick="convert()">兑换优惠券</button>
        </div>

            <div class="form-group">
                <label for="f-vipSub" class="col-sm-3 control-label">优惠券 :</label>
                <div class="col-sm-4">
                    <label class="form-control" id="f-vipSub" style="border: none"><%=vip.getVipSubMoney()%></label>
                </div>
            </div>

        <div class="form-group">
            <button id="cancel_vip" style="margin-left: 16%" type="button" class="btn btn-danger">注销会员</button>
        </div>
        <button type="submit" id="save" style="margin-left: 45%;margin-top: -45px;visibility: hidden" class="btn btn-default btn-primary btn-sm">保存</button>

    </form>
</fieldset>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
<script>
    function modify(){
//        document.getElementById("f-vipName").style.visibility = "hidden";
        document.getElementById("f-vipBankcard").style.visibility = "hidden";
//        document.getElementById("name_input").style.visibility = "";
        document.getElementById("bankCard_input").style.visibility = "";
        document.getElementById("save").style.visibility = "";
    }
    function convert() {
        $.ajax({
            type:"post",
            url:"converttheVIP",
            async:false,
            success:function(){
                swal("恭喜您","优惠券10元","success");
                location.reload();
            },
        });
    }
    document.getElementById("cancel_vip").onclick=function(){
        swal({
            title: "确定注销？",
            text: "您将无法恢复此会员！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false
        }, function() {
            $.ajax({
                type:"post",
                url : "canceltheVIP",
                async : false,
                success : function() {
                    swal("删除", "已注销！", "success");
                    window.location.href="/jsp/main.jsp";
                },
            });


        })
    };
</script>
</body>
</html>