<%@ page import="util.ClassroomVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="util.CourseVO" %>
<%@ page import="model.Vip" %>
<%@ page import="util.GetDiscount" %>
<%@ page import="service.ClassService" %><%--
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
    <link href="../css/table.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
</head>
<%
    Vip vip=(Vip) session.getAttribute("vipInfo");
%>
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
            <a href="../showCourse.action" class="navbar-brand" style="margin-left: -50px">Training</a>
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
        <div style="width: 90%;height: 200px;">
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

        <div class="write_form">
            <button class="btn btn-primary" style="margin-left: 15px;" onclick="append();"> + 新增学生</button>
            <table id="addStudent" class="table table-bordered" style="width: 900px;border-width: 1;margin-top: 10px;text-align: center">
                <thead>
                <th>学生姓名</th>
                <th>选择班级</th>
                <th>联系方式</th>
                <th></th>
                </thead>
                <tbody id="three_stu">

                <tr id="r1">
                    <td><input id="n1" placeholder="请填写学生姓名"></td>
                    <td>
                        <select id="s1"class="selectpicker">
                            <%
                                if(classroomVOS!=null){
                                    for(int k=0;k<classroomVOS.size();k++){
                                        ClassroomVO vo=classroomVOS.get(k);
                            %>
                            <option><%=vo.getName()%></option>
                            <%
                                }
                                }
                            %>
                        </select>
                    </td>
                    <td><input id="t1" placeholder="请填写联系方式"></td>
                    <td><button id="b1" class="btn minus_btn" onclick="del()">
                        删除
                    </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div id="payDiv" style="margin-top: 20px;">
            <input type="checkbox"><b> <%=vip.getVipLevel()%>会员，享受7折优惠</b>
            <br/>
            <input type="checkbox"><b> <%=vip.getVipSubMoney()%>元抵用券</b>
            <br/>
            <br/>
            <div style="margin-left: 78%;">
                <h4 id="sum_money">
                    <%--合计： 8799 元--%>
                </h4>
                <button class="btn btn-primary" onclick="choosePay()">购买</button>
            </div>

        </div>
    </div>

    <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
    <label for="tab-radio-2" class="tab-handler tab-handler-2">不选班级</label>
    <div class="tab-content tab-content-2">
        <div class="write_form">
            <button class="btn btn-primary" style="margin-left: 15px;" onclick="append_nine();"> + 新增学生</button>
            <table id="addNineStudent" class="table table-bordered" style="width: 900px;border-width: 1;margin-top: 10px;text-align: center">
                <thead>
                <th>学生姓名</th>
                <th>联系方式</th>
                <th></th>
                </thead>
                <tbody id="nine_stu">
                <tr id="rr1">
                    <td><input placeholder="请填写学生姓名" value=""></td>
                    <td><input placeholder="请填写联系方式" value=""></td>
                    <td><button class="btn minus_btn" onclick="del_nine()">
                        删除
                    </button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <div id="payDiv2" style="margin-top: 20px;">
            <input type="checkbox"><b> <%=vip.getVipLevel()%>会员，享受<%=GetDiscount.getdis(vip.getVipLevel())%>折优惠</b>
            <br/>
            <input type="checkbox"><b> <%=vip.getVipLevel()%> 元抵用券</b>
            <br/>
            <br/>
            <div style="margin-left: 78%;">
                <h4>合计： 8799 元</h4>
                <button class="btn btn-primary">确认支付</button>
            </div>

        </div>
    </div>
</div>

</body>
<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
<script type="text/javascript">
    var num=1;
    function append(){
        <%--<%--%>
        <%--i++;--%>
        <%--System.out.println(i);--%>
        <%--if(i>=4){--%>
        <%--%>--%>
        <%--alert("选择班级每单限3学员！");--%>
        <%--<%--%>
        <%--}else{--%>
        <%--%>--%>
        num=num+1;
        var newLine='<tr id="r'+num+'"><td><input id="n'+num+'" placeholder="请填写学生姓名"></td> <td> <select id="s'+num+'" style="width: 219px;height: 34px;background: transparent">';
        //可能java中class是关键词？class用不了
        var classnames=new Array();
        <%
        for(int p=0;p<classroomVOS.size();p++){%>
            classnames[<%=p%>]="<%=classroomVOS.get(p).getName()%>";
            newLine+="<option>"+classnames[<%=p%>]+"</option>";

        <%}
        %>
        newLine+='</select> </td> <td><input id="t'+num+'" placeholder="请填写联系方式" ></td> <td><button id="b'+num+'" class="btn minus_btn"> 删除 </button> </td> </tr>';
        $("#three_stu").append(newLine);
//        }
//        %>
    }
    function append_nine(){
        var newLine='<tr><td><input placeholder="请填写学生姓名" value=""></td> <td><input placeholder="请填写联系方式" value=""></td> <td><button class="btn minus_btn"> 删除 </button> </td> </tr>';
        //可能java中class是关键词？class用不了
        $("#nine_stu").append(newLine);
    }
    function del(){
//        $(":checked").fadeOut("show");
        document.getElementById("addStudent").deleteRow(document.getElementById("r1").rowIndex);
    }
    function del_nine(){
        document.getElementById("addNineStudent").deleteRow(document.getElementById("rr").rowIndex);
    }
    var sum;
    function choosePay(){
        //order增加，并且orderclass增加
        sum=9000;
        $.ajax({
            type:"post",
            url:"../addOneOrder",
            async:false,
            data:{
                money:sum,
            },
            success:function(){
                //确认支付 不确认则待支付订单；确认后正常
                swal({
                    title: "支付",
                    text: "确认支付",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "立即支付",
                    cancelButtonText: "取消",
                    closeOnConfirm: false,
                    closeOnCancel: false
                }, function(isConfirm) {
                    if (isConfirm) {
                        for(var g=1;g<=num;g++){

                            $.ajax({
                                type:"post",
                                url:"orderCourse",
                                async:false,
                                data:{
                                    student_name:document.getElementById("n"+g).value,
                                    class_name:document.getElementById("s"+g).value,
                                    phone:document.getElementById("t"+g).value,
                                },
                            });
                        }
                        swal("支付!", "支付成功！", "success")
                    } else{
                        swal("取消", "订单将在15分钟后失效，请尽快支付！", "error")
                    }
                })
                //15分钟支付
            },
        });
    }
</script>
</html>