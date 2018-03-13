<%@ page import="model.Institution" %>
<%@ page import="util.CourseClassVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/13
  Time: 下午8:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>InsPlan</title>
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
    List<CourseClassVO> list = (List<CourseClassVO>) request.getAttribute("insClasses");
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
        <li role="presentation"><a href="showInsBasicInfo"><h5 style="padding-left: 15px">基本信息</h5></a></li>
        <li role="presentation" class="active"><a href="showAllClasses"><h5 style="padding-left: 15px">机构计划</h5></a></li>
        <li role="presentation"><a href=""><h5 style="padding-left: 15px">学员登记</h5></a></li>
        <li role="presentation"><a href=""><h5 style="padding-left: 15px">机构统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>机构计划</legend>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <div class="write_form">
            <%
                    if(list.size()==0){
                %>
        <b>本机构还没有发布任何课程计划！</b>
            <%
                }else{
                %>
        <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
            <thead>
            <th>课程名</th>
            <th>开课日期</th>
            <th>结课日期</th>
            <th>课时/周</th>
            <th>班级名</th>
            <th>教师</th>
            <th>班级价格</th>
            <th>总人数</th>
            <th>现有人数</th>
            </thead>
            <tbody>
            <%
                for(int i=0;i<list.size();i++){
                    CourseClassVO vo=list.get(i);
            %>
            <tr>
                <td><%=vo.getCourse_name()%></td>
                <td><%=sdf.format(vo.getStart_time())%></td>
                <td><%=sdf.format(vo.getEnd_time())%></td>
                <td><%=vo.getTimes()%></td>
                <td><%=vo.getClass_name()%></td>
                <td><%=vo.getTeacher_name()%></td>
                <td><%=vo.getPrice()%></td>
                <td><%=vo.getAll_num()%></td>
                <td><%=vo.getNow_num()%></td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
            <%
                    }
                %>
</fieldset>
</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
</html>