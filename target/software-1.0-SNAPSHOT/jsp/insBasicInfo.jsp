<%@ page import="model.Institution" %>
<%@ page import="model.Teacher" %>
<%@ page import="java.util.List" %><%--
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
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%
    Institution institution=(Institution) session.getAttribute("insInfo");
    List<Teacher> teacherList=(List<Teacher>) request.getAttribute("teachers");
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
        <li role="presentation"><a href="showInsOrders"><h5 style="padding-left: 15px">学员登记</h5></a></li>
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

        <button type="button" id="ca" onclick="ret()" class="btn minus_btn" style="margin-left: 35%;visibility: hidden;">取消</button>
        <button type="submit" id="save" style="margin-left: 42px;margin-top: 0px;visibility: hidden" class="btn blueminus_btn">保存</button>
        <button id="sign1" class="alert alert-warning" role="alert" style="visibility: hidden">信息修改后，请等待管理员的审核！</button>

    </form>

    <h4>师资信息</h4>
    <div class="write_form">
        <table id="show_teacher" class="table table-bordered" style="width: 500px;border-width: 2;margin-top: 10px;text-align: center">
            <thead>
            <th>教师姓名</th>
            <th>等级</th>
            <th>科目</th>
            <th></th>
            </thead>
            <tbody id="teachers">
            <%
                for(int i=0;i<teacherList.size();i++){
                    Teacher teacher=teacherList.get(i);
            %>
            <tr>
                <td><%=teacher.getName()%></td>
                <td><%=teacher.getRank()%></td>
                <td><%=teacher.getSubject()%></td>
                <td>
                    <button id="b0" type="button" class="btn minus_btn" onclick="del(this)">
                    删除
                    </button>
                </td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
        <button type="button" class="btn btn-primary" style="margin-top:-150px;margin-left: 90%;" onclick="append_teacher();"> + 新增教师</button>
        <button id="cancel" type="button" onclick="ret()" class="btn minus_btn" style="margin-left: 42%;visibility: hidden">取消</button>
        <button id="confirm" type="button" onclick="add_teacher()" class="btn blueminus_btn" style="margin-left: 50%;margin-top: -56px;visibility: hidden">确认</button>
        <br/>
        <button id="sign" class="alert alert-warning" role="alert" style="visibility: hidden">添加成功!</button>
    </div>

</fieldset>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
<script>
    function modify(){
        document.getElementById("f-insname").style.visibility = "hidden";
        document.getElementById("f-insloc").style.visibility = "hidden";
        document.getElementById("f-num").style.visibility = "hidden";
        document.getElementById("name_input").style.visibility = "";
        document.getElementById("loc_input").style.visibility = "";
        document.getElementById("num_input").style.visibility = "";
        document.getElementById("save").style.visibility = "";
        document.getElementById("ca").style.visibility = "";
        document.getElementById("sign1").style.visibility = "";
    }
    var num=0;
    function append_teacher(){
        document.getElementById("confirm").style.visibility = "";
        document.getElementById("cancel").style.visibility = "";
        num=num+1;
        var newLine='<tr id="r'+num+'"><td><input id="tn'+num+'" placeholder="请填写教师姓名"></td> <td> <select id="s'+num+'" style="height: 34px;background: white"> <option>金牌</option> <option>银牌</option> <option>铜牌</option> </select> </td><td><input id="t'+num+'" placeholder="请填写任教科目"></td> <td><button id="b'+num+'"type="button" class="btn minus_btn" onclick="del(this)"> 删除 </button> </td> </tr>';
        $("#teachers").append(newLine);
    }
    function ret(){
        window.location.reload();
    }
    function add_teacher(){
        for(var i=1;i<=num;i++){
            if(document.getElementById("tn"+i)!=null) {
                $.ajax({
                    type: "post",
                    url: "addSomeTeachers",
                    async: false,
                    data: {
                        na: document.getElementById("tn" + i).value,
                        ra: document.getElementById("s" + i).value,
                        su: document.getElementById("t" + i).value,
                    },
                });
            }
        }
        document.getElementById("sign").style.visibility="";
        setTimeout(function(){
            document.getElementById("sign").style.visibility="hidden";
            window.location.reload();
        },1000)
    }
    function del(obj){
        var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
        child.parentNode.removeChild(child);
    }
</script>
</html>