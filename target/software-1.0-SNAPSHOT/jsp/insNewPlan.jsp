<%@ page import="model.Institution" %>
<%@ page import="util.CourseClassVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="model.Teacher" %><%--
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
    <title>机构-发布计划</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%
    Institution institution=(Institution) session.getAttribute("insInfo");
    List<CourseClassVO> list = (List<CourseClassVO>) request.getAttribute("insClasses");
    List<Teacher> teacherList= (List<Teacher>) request.getAttribute("insTeachers");
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
            <ul class="nav navbar-nav navbar-right">
                <li><a href="main">登出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation"><a href="showInsBasicInfo"><h5 style="padding-left: 15px">基本信息</h5></a></li>
        <li role="presentation" class="active"><a href="showAllClasses"><h5 style="padding-left: 15px">机构计划</h5></a></li>
        <li role="presentation"><a href="showInsOrders"><h5 style="padding-left: 15px">学员登记</h5></a></li>
        <li role="presentation"><a href="insSta"><h5 style="padding-left: 15px">机构统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>机构计划</legend>
    <%
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    %>
    <button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-info" style="margin-left: 80%">发布课程</button>
    <div class="write_form">
            <%
                    if(list.size()==0){
                %>
        <b>本机构还没有发布任何课程计划！</b>
            <%
                }else{
                %>
        <table class="table table-bordered" style="border-width: 1;margin-top: 10px;text-align: center">
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
    </div>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">新增课程</h4>
                </div>
                <div class="modal-body">
                    <form action="newPlan" id="formit" method="post">
                        <div class="form-group">
                            <input type="text" name="courseName" id="courseName" class="form-control" placeholder="请输入课程名">
                        </div>
                        <div class="form-group">
                            <input type="text" name="startTime" id="startTime" class="form-control" placeholder="请设置开课日期">
                        </div>
                        <div class="form-group">
                            <input type="text" name="endTime" id="endTime" class="form-control" placeholder="请设置结课日期">
                        </div>
                        <div class="form-group">
                            <input type="number" name="times" id="times" class="form-control" placeholder="请输入每周课次">
                        </div>
                        <div class="form-group">
                            <input type="number" name="bprice" id="bprice" class="form-control" placeholder="请输入基本价格">
                        </div>
                        <br/>
                        <b>班级信息【即一个课程名下的多个班级】</b>
                        <div class="write_form">
                            <table id="addClass" class="table table-bordered" style="width: 470px;border-width: 2;margin-top: 10px;text-align: center">
                                <thead>
                                <th>班级名</th>
                                <th>授课老师</th>
                                <th>人数</th>
                                <th>价格</th>
                                <th></th>
                                </thead>
                                <tbody id="classes">
                                <tr id="r1">
                                    <td><input style="width: 100px;" id="cn1" name="cn1" placeholder="请填写班级名"></td>
                                    <td>
                                        <select form="formit" id="tn1" name="tn1">
                                            <%
                                                for(int i=0;i<teacherList.size();i++){
                                                    Teacher t=teacherList.get(i);
                                            %>
                                            <option value="<%=t.getName()%>"><%=t.getName()%></option>
                                            <%
                                                }
                                            %>
                                        </select>
                                    </td>
                                    <td><input style="width: 125px;" id="n1" name="n1" placeholder="请填写班级人数"></td>
                                    <td><input style="width: 96px;" id="p1" name="p1" placeholder="请填写价格"></td>
                                    <td><button id="b1" type="button" class="btn minus_btn" onclick="del(this)">
                                        删除
                                    </button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input id="count" hidden="hidden" name="count" value="1">
                            <button type="button" class="btn blueminus_btn" style="margin-left: 460px;" onclick="append_teacher();">新班级</button>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-info">发布</button>
                        </div>

                    </form>
                </div>

            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>
</fieldset>
</body>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>
<script>
    $('#startTime').datepicker({
        format:'yyyy-mm-dd'
    });
    $('#endTime').datepicker({
        format:'yyyy-mm-dd'
    });
    function del(obj){
        var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
        child.parentNode.removeChild(child);
    }
    var num=1;
    function append_teacher(){
        num=num+1;
        var newline='<tr id="r'+num+'" name="r'+num+'"> <td><input style="width: 100px;" id="cn'+num+'" name="cn'+num+'" placeholder="请填写班级名"></td> <td> <select id="tn'+num+'" name="tn'+num+'">';
        var teachers=new Array();
        <%
        for(int p=0;p<teacherList.size();p++){%>
            teachers[<%=p%>]="<%=teacherList.get(p).getName()%>";
            newline+="<option value="+teachers[<%=p%>]+">"+teachers[<%=p%>]+"</option>";
        <%}
        %>
        newline+='</select> </td> <td><input style="width: 130px;" id="n'+num+'" name="n'+num+'" placeholder="请填写班级人数"></td> <td><input style="width: 100px;" id="p'+num+'" name="p'+num+'" placeholder="请填写价格"></td> <td><button id="b'+num+'" type="button" class="btn minus_btn" onclick="del(this)">删除 </button> </td> </tr>';
        $("#classes").append(newline);
        document.getElementById("count").value=num;
    }
</script>
</html>