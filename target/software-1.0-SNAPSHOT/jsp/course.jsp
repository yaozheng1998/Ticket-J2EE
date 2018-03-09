<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="util.CourseVO" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="util.ClassroomVO" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/7
  Time: 下午8:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Course</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/smallseashell.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
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
            <a href="vipBasicInfo.action" class="navbar-brand" style="margin-left: -50px">Training</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="showCourse.action">首页</a></li>
                <li><a href="vipBasicInfo.action">个人信息</a></li>
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

<div>
    <ul class="select">
        <li class="select-list">
            <dl id="select1">
                <dt>机构：</dt>
                <dd class="select-all selected"><a href="javascript:">全部</a></dd>
                <% List<String> insList=(ArrayList<String>)request.getAttribute("allIns") ;
                for(int i=0;i<insList.size();i++){
                    %>
                <dd><a href="javascript:"><%=insList.get(i)%></a></dd>
                <%
                }%>
            </dl>
        </li>
        <li class="select-list">
            <dl id="select2">
                <dt>地点：</dt>
                <dd class="select-all selected"><a href="javascript:">全部</a></dd>
                <% List<String> locList=(ArrayList<String>)request.getAttribute("allLoc") ;
                    for(int i=0;i<locList.size();i++){
                %>
                <dd><a href="javascript:"><%=locList.get(i)%></a></dd>
                <%
                    }%>
            </dl>
        </li>
        <li class="select-list">
            <dl id="select3">
                <dt>学科：</dt>
                <dd class="select-all selected"><a href="javascript:">全部</a></dd>
                <% List<String> subList=(ArrayList<String>)request.getAttribute("allSub") ;
                    for(int i=0;i<subList.size();i++){
                %>
                <dd><a href="javascript:"><%=subList.get(i)%></a></dd>
                <%
                    }%>
            </dl>
        </li>
        <li class="select-result">
            <dl>
                <dt>已选条件：</dt>
                <dd class="select-no">暂时没有选择过滤条件</dd>
            </dl>
        </li>
    </ul>
</div>

<div class="row" style="padding-left: 13%;margin-bottom: 20px;">
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        List<CourseVO> courseList = (ArrayList<CourseVO>) request.getAttribute("allCourse");
        for (int i = 0; i < courseList.size(); i++) {
            CourseVO courseVO = courseList.get(i);
            String url = "../img/" + (i+1) + ".jpg";
    %>
    <div class="col-sm-6 col-md-4" style="width: 305px;">
        <div class="thumbnail" style="width: 305px;">
            <img src="<%=url%>" style="width: 300px;">
            <div class="caption">
                <div class="row" style="padding-left: 30px;">
                    <h3><%=courseVO.getInsName()%></h3>
                    <b><%=courseVO.getInsLoc()%></b>
                </div>
                <div class="row" style="padding-left: 30px;">
                    <b><%=sdf.format(courseVO.getStartTime())%></b>
                    <b>至</b>
                    <b><%=sdf.format(courseVO.getEndTime())%></b>
                </div>
                <div class="row" style="padding-left: 30px;padding-bottom: 9px;">
                    <b><%=courseVO.getSubject()%></b>
                    <b>¥ <%=courseVO.getBasicPrice()%>起</b>
                    <b><%=courseVO.getTimes()%>课时/周</b>
                </div>
                <p style="padding-left: 90px;"><button id='<%=courseVO.getCourseId()%>' class="btn btn-primary" type="button" onclick="showTheClass(this)">购买</button></p>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
<%--<table style="position:relative;left:10%;top:20px;">--%>
    <%--<%--%>
        <%--List<CourseVO> courseList = (ArrayList<CourseVO>) request.getAttribute("allCourse");--%>
        <%--for (int i = 0; i < courseList.size(); i++) {--%>
            <%--CourseVO courseVO = courseList.get(i);--%>
            <%--String url = "../img/" + i + ".jpg";--%>
    <%--%>--%>
    <%--<tr>--%>
        <%--<td style="padding: 50px">--%>
            <%--<img src="<%=url%>" style="height: 150px;width: 200px">--%>
        <%--</td>--%>
        <%--<td style="padding-bottom: 50px">--%>
            <%--<h3><a href=""></a><%=courseVO.getSubject()%>--%>
            <%--</h3>--%>
            <%--<p style="width: 500px;height: 50px"><%=courseVO.getInsName()%>--%>
            <%--</p>--%>
        <%--</td>--%>
        <%--<td style="padding:50px;">--%>
            <%--<form action="searchRoom" method="post">--%>
                <%--<button type="submit" class="btn btn-default btn-primary"></button>--%>
            <%--</form>--%>
        <%--</td>--%>
    <%--</tr>--%>
    <%--<%--%>
        <%--}--%>
    <%--%>--%>
<%--</table>--%>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/smallseashell.js"></script>
<script type="text/javascript" charset="utf-8">
    var course_id;
    function showTheClass(obj){
        course_id=obj.getAttribute("id");
        $.ajax({
            type:"post",
            url:"showClass",
            async:false,
            data:{
                courseId:course_id,
            },
            success:function(data){
//                location.reload();
                window.location.href="/jsp/class.jsp";
            },
        });
    }
</script>
</html>