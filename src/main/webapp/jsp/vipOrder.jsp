<%@ page import="util.OrderClassVO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="util.ToPayOrderVO" %>
<%@ page import="util.CalReturnMoney" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/10
  Time: 下午2:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>VIP-我的订单</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/vipOrder.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
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
            <a class="navbar-brand" style="margin-left: -50px">Training</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="showCourse.action">首页</a></li>
                <li><a href="vipBasicInfo.action">个人信息</a></li>
            </ul>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li><a href="/jsp/insRegister.jsp">机构注册</a></li>--%>
            <%--</ul>--%>
            <div id="memberDiv"
                 style="position: absolute;top: 15px;left: 950px;width: 150px;height: 30px;color: black">
                <label>欢迎您, <%=session.getAttribute("id")%></label>
                <p id="name" style="position:absolute;top:0px;left:50px;width:70px;height:20px"></p>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="main">登出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation"><a href="vipBasicInfo.action"><h5 style="padding-left: 15px">会员信息</h5></a></li>
        <li role="presentation" class="active"><a href="showMyClasses.action"><h5 style="padding-left: 15px">我的课程</h5></a></li>
        <li role="presentation"><a href="vipSta"><h5 style="padding-left: 15px">购买统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 700px;">
    <legend>我的订单</legend>
    <div class="tab-wrapper">
        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
        <label for="tab-radio-1" class="tab-handler tab-handler-1">全部</label>
        <div class="tab-content tab-content-1">
            <%
                List<OrderClassVO> list=(List<OrderClassVO>)request.getAttribute("myClasses");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            %>
            <div class="write_form">
                <%
                    if(list.size()==0){
                %>
                <b>您还没有订单！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>下单时间</th>
                    <th>付款方式</th>
                    <th>机构名</th>
                    <th>班级名</th>
                    <th>开班日期</th>
                    <th>教师名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>成绩</th>
                    <th>订单状态</th>
                    <%--<th></th>--%>
                    </thead>
                    <tbody>
                    <%
                        for(int i=0;i<list.size();i++){
                            OrderClassVO vo=list.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=sdf.format(vo.getOrder_time())%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=sdf.format(vo.getBegin_time())%></td>
                        <td><%=vo.getTeacher_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <td><%=vo.getGrade()%></td>
                        <td><%=vo.getState()%></td>
                        <%--<td>--%>
                        <%--<%--%>
                            <%--if(vo.getState().equals("待开班")||vo.getState().equals("进行中")||vo.getState().equals("待分配")){--%>
                        <%--%>--%>

                            <%--<button id='<%=vo.getOrder_classId()%>' class="btn minus_btn" onclick="deleteClass(this)">--%>
                                <%--退订--%>
                            <%--</button>--%>
                            <%--<%--%>
                                <%--}--%>
                            <%--%>--%>
                        <%--</td>--%>
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
            <button id="sign" class="alert alert-warning" role="alert" style="visibility: hidden">退订成功，请查看账户退款</button>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
        <label for="tab-radio-2" class="tab-handler tab-handler-2">待开班</label>
        <div class="tab-content tab-content-2">
            <%
                List<OrderClassVO> todolist=(List<OrderClassVO>)request.getAttribute("todoClass");
            %>
            <div class="write_form">
                <%
                    if(todolist.size()==0){
                %>
                <b>没有符合条件的订单！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>下单时间</th>
                    <th>付款方式</th>
                    <th>机构名</th>
                    <th>班级名</th>
                    <th>开班日期</th>
                    <th>教师名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>订单状态</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <%
                        for(int i=0;i<todolist.size();i++){
                            OrderClassVO vo=todolist.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=sdf.format(vo.getOrder_time())%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=sdf.format(vo.getBegin_time())%></td>
                        <td><%=vo.getTeacher_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <td><%=vo.getState()%></td>
                        <td>
                            <button id='<%=vo.getOrder_classId()%>-<%=vo.getOrder_time()%>-<%=vo.getPrice()%>' class="btn minus_btn" onclick="deleteClass2(this)">
                                退订
                            </button>
                        </td>
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
            <button id="sign2" class="alert alert-warning" role="alert" style="visibility: hidden">退订成功，请查看账户退款</button>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-3">
        <label for="tab-radio-3" class="tab-handler tab-handler-3">进行中</label>
        <div class="tab-content tab-content-3">
            <%
                List<OrderClassVO> goinglist=(List<OrderClassVO>)request.getAttribute("goingClass");
            %>
            <div class="write_form">
                <%
                    if(goinglist.size()==0){
                %>
                <b>没有符合条件的订单！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>下单时间</th>
                    <th>付款方式</th>
                    <th>机构名</th>
                    <th>班级名</th>
                    <th>结课日期</th>
                    <th>教师名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>订单状态</th>
                    <th></th>
                    </thead>
                    <tbody>
                    <%
                        for(int i=0;i<goinglist.size();i++){
                            OrderClassVO vo=goinglist.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=sdf.format(vo.getOrder_time())%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=sdf.format(vo.getEnd_time())%></td>
                        <td><%=vo.getTeacher_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <td><%=vo.getState()%></td>
                        <td>
                            <button id='<%=vo.getOrder_classId()%>' class="btn minus_btn" onclick="deleteClass3(this)">
                                退订
                            </button>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
                <%}%>
            </div>
            <button id="sign3" class="alert alert-warning" role="alert" style="visibility: hidden">退订成功</button>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-4">
        <label for="tab-radio-4" class="tab-handler tab-handler-4">已结束</label>
        <div class="tab-content tab-content-4">
            <%
                List<OrderClassVO> endlist=(List<OrderClassVO>)request.getAttribute("endClass");
            %>
            <div class="write_form">
                <%
                    if(endlist.size()==0){
                %>
                <b>没有符合条件的订单！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>下单时间</th>
                    <th>付款方式</th>
                    <th>机构名</th>
                    <th>班级名</th>
                    <th>结课日期</th>
                    <th>教师名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>成绩</th>
                    <th>订单状态</th>
                    </thead>

                    <tbody>
                    <%
                        for(int i=0;i<endlist.size();i++){
                            OrderClassVO vo=endlist.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=sdf.format(vo.getOrder_time())%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=sdf.format(vo.getEnd_time())%></td>
                        <td><%=vo.getTeacher_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <td><%=vo.getGrade()%></td>
                        <td><%=vo.getState()%></td>
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

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-5">
        <label for="tab-radio-5" class="tab-handler tab-handler-5">已退订</label>
        <div class="tab-content tab-content-5">
            <%
                List<OrderClassVO> refundlist=(List<OrderClassVO>)request.getAttribute("refundClass");
            %>
            <div class="write_form">
                <%
                if(refundlist.size()==0){
                %>
                    <b>没有符合条件的订单！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>下单时间</th>
                    <th>付款方式</th>
                    <th>机构名</th>
                    <th>班级名</th>
                    <th>价格</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>退订日期</th>
                    <th>返款金额</th>
                    <th>订单状态</th>
                    </thead>

                    <tbody>
                    <%
                        for(int i=0;i<refundlist.size();i++){
                            OrderClassVO vo=refundlist.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=sdf.format(vo.getOrder_time())%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getClass_name()%></td>
                        <td><%=vo.getPrice()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <%
                            if(vo.getRefund_time()==null||(vo.getRefund_time().length()==0)){
                        %>
                        <td></td>
                        <%
                            }else{
                        %>
                        <td><%=sdf.format(df.parse(vo.getRefund_time()))%></td>
                        <%
                            }
                        %>
                        <td><%=vo.getRefund_money()%></td>
                        <td><%=vo.getState()%></td>
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

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-6">
        <label for="tab-radio-6" class="tab-handler tab-handler-6">待分配</label>
        <div class="tab-content tab-content-6">
            <%
                List<OrderClassVO> todividelist=(List<OrderClassVO>)request.getAttribute("divideClass");
            %>
            <div class="write_form">
                <%
                    if(todividelist.size()==0){
                %>
                <b>没有符合条件的订单！</b>
                <%
                }else{
                %>
                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单号</th>
                    <th>下单时间</th>
                    <th>付款方式</th>
                    <th>机构名</th>
                    <th>学生名</th>
                    <th>联系方式</th>
                    <th>订单状态</th>
                    <th></th>
                    </thead>

                    <tbody>
                    <%
                        for(int i=0;i<todividelist.size();i++){
                            OrderClassVO vo=todividelist.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=sdf.format(vo.getOrder_time())%></td>
                        <td><%=vo.getPay_type()%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getStudent_name()%></td>
                        <td><%=vo.getPhone()%></td>
                        <td><%=vo.getState()%></td>
                        <td>
                            <button id='<%=vo.getOrder_classId()%>' class="btn minus_btn" onclick="deleteClass4(this)">
                                退订
                            </button>
                        </td>
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
            <button id="sign4" class="alert alert-warning" role="alert" style="visibility: hidden">退订成功，请查看账户退款</button>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-7">
        <label for="tab-radio-7" class="tab-handler tab-handler-7">待支付</label>
        <div class="tab-content tab-content-7">
            <%
                List<ToPayOrderVO> toPayOrderVOList= (List<ToPayOrderVO>) request.getAttribute("topay");

            %>
            <div class="write_form">
                <%
                    if(toPayOrderVOList.size()==0){
                %>
                <b>没有待支付的订单！</b>
                <%
                }else{
                %>

                <table class="table table-bordered" style="margin-left:-50px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>订单编号</th>
                    <th>下单时间</th>
                    <th>机构名</th>
                    <th>机构地点</th>
                    <th>价格</th>
                    <th></th>
                    <th></th>
                    </thead>
                    <tbody>
                    <%
                        for(int i=0;i<toPayOrderVOList.size();i++){
                            ToPayOrderVO vo=toPayOrderVOList.get(i);
                    %>
                    <tr>
                        <td><%=vo.getOrder_id()%></td>
                        <td><%=sdf2.format(vo.getOrder_time())%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getIns_location()%></td>
                        <td><%=vo.getMoney()%></td>
                        <td>
                            <button class="btn blueminus_btn" onclick="">
                                支付
                            </button>
                        </td>
                        <td>
                            <button id="<%=vo.getOrder_id()%>" class="btn minus_btn" onclick="del(this)">
                                删除
                            </button>
                        </td>
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
</fieldset>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
<script>
    function deleteClass(obj){
        swal({
            title: "确定退订？",
            text: "不能全额退款！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: true
        }, function() {
            $.ajax({
                type:"post",
                url:"cancelMyClass",
                async:true,
                data:{
                    order_classId:obj.getAttribute("id"),
                },
                success:function(){
                    document.getElementById("sign").style.visibility="";
                    var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
                    child.parentNode.removeChild(child);
                    setTimeout(function(){
                        document.getElementById("sign").style.visibility="hidden";
                    },1000);
                }
            });
        })

    }
    function deleteClass2(obj){
        var lid=obj.getAttribute("id");
        arr=lid.split('-');
        console.log(arr);
        swal({
            title: "确定退订？",
            text: "不能全额退款！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: true
        }, function() {
            $.ajax({
                type:"post",
                url:"cancelMyClass",
                async:true,
                data:{
                    order_classId:arr[0],
                    money:arr[2],
                    vipName:'<%=session.getAttribute("id")%>',
                },
                success:function(){
                    document.getElementById("sign2").style.visibility="";
                    var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
                    child.parentNode.removeChild(child);
                    setTimeout(function(){
                        document.getElementById("sign2").style.visibility="hidden";
                    },1000);
                }
            });
        })

    }
    function deleteClass3(obj){
        var lid=obj.getAttribute("id");
        arr=lid.split('-');
        swal({
            title: "确定退订？",
            text: "已开课，不退款！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: true
        }, function() {
            $.ajax({
                type:"post",
                url:"cancelMyClass",
                async:true,
                data:{
                    order_classId:arr[0],
                    money:arr[2],
                    vipName:'<%=session.getAttribute("id")%>',
                },
                success:function(){
                    document.getElementById("sign3").style.visibility="";
                    var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
                    child.parentNode.removeChild(child);
                    setTimeout(function(){
                        document.getElementById("sign3").style.visibility="hidden";
                    },1000);
                }
            });
        })

    }
    function deleteClass4(obj){
        var lid=obj.getAttribute("id");
        arr=lid.split('-');
        swal({
            title: "确定退订？",
            text: "不能全额退款！",
            type: "warning",
            showCancelButton: true,
            confirmButtonColor: "#DD6B55",
            confirmButtonText: "确定",
            closeOnConfirm: true
        }, function() {
            $.ajax({
                type:"post",
                url:"cancelMyClass",
                async:true,
                data:{
                    order_classId:arr[0],
                    money:arr[2],
                    vipName:'<%=session.getAttribute("id")%>',
                },
                success:function(){
                    document.getElementById("sign4").style.visibility="";
                    var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
                    child.parentNode.removeChild(child);
                    setTimeout(function(){
                        document.getElementById("sign4").style.visibility="hidden";
                    },1000);
                }
            });
        })

    }
    function del(obj){
        $.ajax({
           type:"post",
            url:"deleteOrder",
            async:true,
            data:{
               order_id:obj.getAttribute("id"),
            },
            success:function(){
                var child=document.getElementById(obj.getAttribute("id")).parentNode.parentNode;
                child.parentNode.removeChild(child);
            }
        });
    }
</script>
</body>
</html>
