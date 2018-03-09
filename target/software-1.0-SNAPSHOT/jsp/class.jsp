<%@ page import="util.ClassroomVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="util.CourseVO" %>
<%@ page import="model.Vip" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/8
  Time: 下午9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Classes</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/classes.css" rel="stylesheet">
</head>
<body>
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
            <a href="../vipBasicInfo.action" class="navbar-brand" style="margin-left: -50px">Training</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="../showCourse.action">首页</a></li>
                <li><a href="../vipBasicInfo.action">个人信息</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">机构注册</a></li>
            </ul>
            <div id="memberDiv"
                 style="position: absolute;top: 15px;left: 950px;width: 150px;height: 30px;color: black">
                <label>欢迎您, </label>
                <p id="name" style="position:absolute;top:0px;left:50px;width:70px;height:20px"><%=session.getAttribute("id")%></p>
            </div>
        </div>
    </div>
</nav>
<div class="tab-wrapper">
    <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
    <label for="tab-radio-1" class="tab-handler tab-handler-1">选班级</label>
    <div class="tab-content tab-content-1">
        <%List<ClassroomVO> classroomVOS=(ArrayList<ClassroomVO>)session.getAttribute("allClass");
            if(classroomVOS!=null){
                for(int j=0;j<classroomVOS.size();j++){
                    ClassroomVO vo=classroomVOS.get(j);
        %>
        <div class="col-sm-6 col-md-4" style="width: 220px;">
            <div class="thumbnail" style="width: 220px;">
                <div class="caption">
                    <div class="row" style="padding-left: 13px;">
                        <h3><%=vo.getName()%></h3>
                        <b><%=vo.getAllNum()%>人班</b>
                    </div>
                    <div class="row" style="padding-left: 13px;padding-bottom: 9px;">
                        <b>¥<%=vo.getPrice()%></b>
                        <b><%=vo.getTeacherRank()%>讲师 <%=vo.getTeacherName()%></b>
                    </div>
                </div>
            </div>
        </div>
        <%
                }
            }
        %>
    </div>
    <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
    <label for="tab-radio-2" class="tab-handler tab-handler-2">不选班级</label>
    <div class="tab-content tab-content-2">

    </div>
</div>

</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</html>