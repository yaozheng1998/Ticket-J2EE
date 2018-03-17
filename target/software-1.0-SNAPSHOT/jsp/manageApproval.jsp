<%@ page import="model.Institution" %>
<%@ page import="java.util.List" %>
<%@ page import="util.ChangeVO" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/15
  Time: 下午8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ManageApproval</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/manage.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%
    List<Institution> institutionList= (List<Institution>) request.getAttribute("regis");
    List<ChangeVO> changeVOS= (List<ChangeVO>) request.getAttribute("infos");
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
                <li><a href="main.action">登出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation" class="active"><a href="showApp"><h5 style="padding-left: 15px">机构审批</h5></a></li>
        <li role="presentation"><a href="sump"><h5 style="padding-left: 15px">支付结算</h5></a></li>
        <li role="presentation"><a href="manageSta"><h5 style="padding-left: 15px">网站统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>机构审批</legend>
    <div class="tab-wrapper" style="margin-top: 10px;">
        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
        <label for="tab-radio-1" class="tab-handler tab-handler-1">注册申请</label>
        <div class="tab-content tab-content-1">
            <div class="write_form">
                <table id="regist" class="table table-bordered" style="margin-left:-92px;width: 900px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>机构编号</th>
                    <th>机构名</th>
                    <th>机构地点</th>
                    <th>班级数</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                    <%
                        for(int i=0;i<institutionList.size();i++){
                            Institution institution=institutionList.get(i);
                    %>
                    <tr>
                        <td><%=institution.getIns_id()%></td>
                        <td><%=institution.getIns_name()%></td>
                        <td><%=institution.getLocation()%></td>
                        <td><%=institution.getClassrooms()%></td>
                        <td><button id="d+'<%=i%>'" class="btn minus_btn" onclick="disapprove(this)">
                            不通过
                        </button>
                        </td>
                        <td><button id="<%=institution.getIns_id()%>" class="btn blueminus_btn" onclick="approve(this)">
                            通过
                        </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
        <label for="tab-radio-2" class="tab-handler tab-handler-2">信息修改</label>
        <div class="tab-content tab-content-2">
            <div class="write_form">
                <table id="info" class="table table-bordered" style="margin-left:-92px;width: 900px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>机构编号</th>
                    <th>机构名</th>
                    <th>机构地点</th>
                    <th>班级数</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                    <%
                        for(int j=0;j<changeVOS.size();j++){
                            ChangeVO vo=changeVOS.get(j);
                    %>
                    <tr>
                        <td><%=vo.getId()%></td>
                        <td><%=vo.getNameChange()%></td>
                        <td><%=vo.getLocChange()%></td>
                        <td><%=vo.getClassChange()%></td>
                        <td><button id="dd+'<%=j%>'" class="btn minus_btn" onclick="disapproveIn(this)">
                            不通过
                        </button>
                        </td>
                        <td><button id="<%=vo.getId()%>" class="btn blueminus_btn" onclick="approveIn(this)">
                            通过
                        </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</fieldset>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script>
    function disapprove(obj){
//        var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
//        child.parentNode.removeChild(child);
        $.ajax({
            type:"post",
            url:"disappR",
            async:true,
            data:{
                ins_id:obj.getAttribute("id"),
            },
            success:function () {
//                alert("审核通过！");
                window.location.reload();
            }
        });
    }
    function approve(obj){
        $.ajax({
           type:"post",
            url:"appR",
            async:true,
            data:{
               ins_id:obj.getAttribute("id"),
            },
            success:function () {
//                alert("审核通过！");
                window.location.reload();
            }
        });
    }
    function disapproveIn(obj){

        $.ajax({
            type:"post",
            url:"disappR",
            async:true,
            data:{
                ins_id:obj.getAttribute("id"),
            },
            success:function () {
////                alert("审核通过！");
//                window.location.reload();
                var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
                child.parentNode.removeChild(child);
            }
        });
    }
    function approveIn(obj){
        $.ajax({
            type:"post",
            url:"appI",
            async:true,
            data:{
                ins_id:obj.getAttribute("id"),
            },
            success:function () {
                alert("审核通过！");
                window.location.reload();
            }
        });

    }
</script>
</body>
</html>