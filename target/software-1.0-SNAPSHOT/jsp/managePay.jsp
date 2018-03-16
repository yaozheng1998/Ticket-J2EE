<%@ page import="java.util.List" %>
<%@ page import="util.SumPayVO" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/16
  Time: 上午12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pay</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/manage.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%
    List<SumPayVO> list= (List<SumPayVO>) request.getAttribute("sumpay");
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
            <a class="navbar-brand" style="margin-left: -50px">Training经理版</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <div id="memberDiv"
                 style="position: absolute;top: 15px;left: 950px;width: 150px;height: 30px;color: black">
                <label>欢迎您, </label>
                <p id="name" style="position:absolute;top:0px;left:50px;width:70px;height:20px">Manager</p>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="main.action">会员版</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation"><a href="showApp"><h5 style="padding-left: 15px">机构审批</h5></a></li>
        <li role="presentation" class="active"><a href="sump"><h5 style="padding-left: 15px">支付结算</h5></a></li>
        <li role="presentation"><a href="manageSta"><h5 style="padding-left: 15px">网站统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>支付结算</legend>
    <div class="write_form">
        <table id="regist" class="table table-bordered" style="margin-left:42px;width: 900px;border-width: 1;margin-top: 10px;text-align: center">
            <thead>
            <th>机构编号</th>
            <th>机构名</th>
            <th>机构地点</th>
            <th>总销售额</th>
            <th></th>
            </thead>
            <tbody>
            <%
                for(int i=0;i<list.size();i++){
                    SumPayVO vo=list.get(i);
            %>
            <tr>
                <td><%=vo.getIns_id()%></td>
                <td><%=vo.getIns_name()%></td>
                <td><%=vo.getIns_loc()%></td>
                <td><%=vo.getSum()%></td>
                <td><button id="<%=vo.getIns_id()%>" class="btn minus_btn" onclick="pay(this)">
                    结算
                </button>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</fieldset>

<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
<script>
    function pay(obj){
        swal({
            title: "确定支付？",
            text: "支付七成收入给机构",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: false
        }, function() {
            $.ajax({
                type:"post",
                url : "seven",
                async : false,
                data:{
                  ins_id:obj.getAttribute("id"),
                },
                success : function() {
                    swal("成功", "已结算！", "success");
                    setTimeout(function () {
                        window.location.reload();
                    },2000);
                },
            });
        })
    }
</script>
</body>
</html>
