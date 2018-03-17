<%@ page import="util.OrderClassVO" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Institution" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Course" %>
<%@ page import="model.Classroom" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/13
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Check</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <link href="../css/check.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%
    Institution institution=(Institution) session.getAttribute("insInfo");
    List<OrderClassVO> open= (List<OrderClassVO>) request.getAttribute("openIO");
    List<OrderClassVO> go= (List<OrderClassVO>) request.getAttribute("goIO");
    List<OrderClassVO> end= (List<OrderClassVO>) request.getAttribute("endIO");
    List<OrderClassVO> divide= (List<OrderClassVO>) request.getAttribute("divideIO");
    List<Course> courseList=(List<Course>) request.getAttribute("coursesINS");
    System.out.print(courseList);

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
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
        <li role="presentation"><a href="showAllClasses"><h5 style="padding-left: 15px">机构计划</h5></a></li>
        <li role="presentation" class="active"><a href="showInsOrders"><h5 style="padding-left: 15px">学员登记</h5></a></li>
        <li role="presentation"><a href="insSta"><h5 style="padding-left: 15px">机构统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>学员登记</legend>
    <button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-info" style="margin-left: 80%">线下缴费</button>
    <div class="tab-wrapper">
        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
        <label for="tab-radio-1" class="tab-handler tab-handler-1">待开班</label>
        <div class="tab-content tab-content-1">
            <div class="write_form">
                <%
                    if(open.size()==0){
                %>
                <b>没有待开班课程信息！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>会员名</th>
                    <th>付款方式</th>
                    <th>班级名</th>
                    <th>开班日期</th>
                    <th>教师名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    </thead>
                    <tbody>
                    <%
                        for(int i=0;i<open.size();i++){
                            OrderClassVO vo=open.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=vo.getVipName()%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=sdf.format(vo.getBegin_time())%></td>
                        <td><%=vo.getTeacher_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
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
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
        <label for="tab-radio-2" class="tab-handler tab-handler-2">进行中</label>
        <div class="tab-content tab-content-2">
            <%
                if(go.size()!=0){
            %>
            <button class="blueminus_btn btn" style="margin-left: 83%;margin-top: -84px;" onclick="gradein()">登分</button>
            <%
                }
            %>
            <div class="write_form">
                <%
                    if(go.size()==0){
                %>
                <b>当前没有进行中的课程信息！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>会员名</th>
                    <th>付款方式</th>
                    <th>班级名</th>
                    <th>结课日期</th>
                    <th>教师名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>成绩</th>
                    </thead>
                    <tbody>
                    <%
                        for(int i=0;i<go.size();i++){
                            OrderClassVO vo=go.get(i);
                    %>
                    <tr>
                        <td id="o<%=i%>"><%=vo.getOrder_id()%></td>
                        <td><%=vo.getVipName()%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=sdf.format(vo.getEnd_time())%></td>
                        <td><%=vo.getTeacher_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td id="sn<%=i%>"><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <td id="g<%=i%>"><%=vo.getGrade()%></td>
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
            <button id="con" class="blueminus_btn btn" style="margin-left: 83%;visibility: hidden" onclick="save_grade()">保存</button>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-3">
        <label for="tab-radio-3" class="tab-handler tab-handler-3">已结束</label>
        <div class="tab-content tab-content-3">
            <div class="write_form">
                <%
                    if(end.size()==0){
                %>
                <b>本机构还未结束任何课程！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>会员名</th>
                    <th>付款方式</th>
                    <th>班级名</th>
                    <th>结课日期</th>
                    <th>教师名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>成绩</th>
                    </thead>

                    <tbody>
                    <%
                        for(int i=0;i<end.size();i++){
                            OrderClassVO vo=end.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=vo.getVipName()%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=sdf.format(vo.getEnd_time())%></td>
                        <td><%=vo.getTeacher_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <td><%=vo.getGrade()%></td>
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
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-4">
        <label for="tab-radio-4" class="tab-handler tab-handler-4">待分配</label>
        <div class="tab-content tab-content-4">
            <div class="write_form">
                <%
                    if(divide.size()==0){
                %>
                <b>当前没有待分配学生！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>会员名</th>
                    <th>下单时间</th>
                    <th>付款方式</th>
                    <%--<th>课程名</th>--%>
                    <th>学生名</th>
                    <th>联系方式</th>
                    </thead>

                    <tbody>
                    <%
                        for(int i=0;i<divide.size();i++){
                            OrderClassVO vo=divide.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=vo.getVipName()%></td>
                        <td><%=vo.getOrder_time()%></td>
                        <td><%=vo.getPay_type()%></td>
                        <%--<td><%=vo%></td>--%>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
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
        </div>

    </div>

    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title" id="myModalLabel">线下购买</h4>
                </div>
                <div class="modal-body">
                    <form action="offlinePay" id="formit" method="post">
                        <div class="form-group">
                            <input style="width: 220px;" type="text" name="vipName" id="vipName" class="form-control" placeholder="请输入会员名（选填）">
                        </div>
                        <div class="form-group">
                            <select class="selectpicker" id="courses">
                                <option value="" disabled selected>请选择对应课程</option>
                                <%
                                    for(int j=0;j<courseList.size();j++){
                                        Course course=courseList.get(j);
                                %>
                                <option value="<%=course.getType()+"-"+course.getTimes()+"课时/周-"+course.getBasic_price()%>"><%=course.getType()+"-"+course.getTimes()+"课时/周-¥"+course.getBasic_price()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <br/>
                        <b>选择班级</b>
                        <div class="write_form">
                            <table id="addClass" class="table table-bordered" style="width: 540px;border-width: 2;margin-top: 10px;text-align: center">
                                <thead>
                                <th>班级</th>
                                <th>学生姓名</th>
                                <th>联系方式</th>
                                <th></th>
                                </thead>
                                <tbody id="classes">
                                <tr id="r1">
                                    <td>
                                        <select form="formit" id="c1" name="c1">
                                            <%--<option value="">8.5</option>--%>
                                        </select>
                                    </td>
                                    <td><input style="width: 130px;" id="n1" name="n1" placeholder="请填写学生姓名"></td>
                                    <td><input style="width: 130px;" id="p1" name="p1" placeholder="请填写联系方式"></td>
                                    <td><button id="b1" type="button" class="btn minus_btn" onclick="del(this)">
                                        删除
                                    </button>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                            <input id="count" hidden="hidden" name="count" value="1">
                            <button type="button" class="btn blueminus_btn" style="margin-left: 460px;" onclick="append_student();">新学生</button>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <button type="submit" class="btn btn-info">确认</button>
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
    function del(obj){
        var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
        child.parentNode.removeChild(child);
    }
    var num=1;
    function append_student(){
        num=num+1;
        var newline='<tr id="r'+num+'"> <td>';
        newline+='<select form="formit" id="c'+num+'" name="c'+num+'"> <option value="">7</option> <option value="">8</option> </select></td>';
        newline+='<td><input style="width: 130px;" id="n'+num+'" placeholder="请填写学生姓名"></td> <td><input style="width: 130px;" id="p'+num+'" name="p'+num+'" placeholder="请填写联系方式"></td> <td><button id="b'+num+'" type="button" class="btn minus_btn" onclick="del(this)">删除 </button> </td> </tr>';
        $("#classes").append(newline);
        document.getElementById("count").value=num;
    }

    $("#courses").change(function(){
        $.ajax({
           type:"post",
            url:"getCO",
            async:true,
            data:{
               course_id:document.getElementById("courses").value,
            },
            success:function(){
               <%
               List<Classroom> co=(List<Classroom>) request.getAttribute("Ucourses");
               if(co!=null){
               for(int i=0;i<co.size();i++){
               %>
                document.getElementById("c1").options.add(new Option(<%=co.get(i).getClass_name()%>,<%=co.get(i).getClass_name()%>));
                <%
                }
                }
                %>


            }
        });
    });

    function gradein(){
        document.getElementById("con").style.visibility="";
        <%
        for(int i=0;i<go.size();i++){
        %>
        document.getElementById("g<%=i%>").innerHTML='<input id="gi<%=i%>" value='+document.getElementById("g<%=i%>").innerHTML+'>';
        <%
        }
        %>
    }
    function save_grade(){
        document.getElementById("con").style.visibility="hidden";
        <%
        for(int j=0;j<go.size();j++){
        %>
        $.ajax({
           type:"post",
            url:"gradeIN",
            async:"false",
            data:{
               order_id:document.getElementById("o<%=j%>").innerHTML,
               name:document.getElementById("sn<%=j%>").innerHTML,
               grade:document.getElementById("gi<%=j%>").value,
            },
            success:function(){
                document.getElementById("g<%=j%>").innerHTML=document.getElementById("gi<%=j%>").value;
            }
        });
        <%
        }
        %>

    }
</script>
