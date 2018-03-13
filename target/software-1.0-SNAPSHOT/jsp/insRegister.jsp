<%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/13
  Time: 下午4:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>InstitutionRegister</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
</head>
<body style="height: 780px;background-image: url(../img/training.jpg);background-size: cover">
<div>
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">切换导航</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand">Training机构版</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <!--<ul class="nav navbar-nav">-->
                <!--<li class="active"><a href="main.action">首页</a></li>-->
                <!--</ul>-->
                <ul class="nav navbar-nav navbar-right">
                    <!--<li data-toggle="modal" data-target="#login"><a href="#">登录/注册</a></li>-->
                    <li><a href="#">会员版</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div style="margin-top:6%;margin-left:30%;height: 600px;">
    <h4 style="align-items: center;padding-left: 17%;padding-top: 6%;">注册机构</h4>
    <div style="width: 400px;">
        <form method="post" onsubmit="">
            <div class="form-group">
                <input type="name" id="ins_name" name="ins_name" class="form-control" placeholder="请输入机构名">
            </div>
            <div class="form-group">
                <input type="password" id="ins_password" name="ins_password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="form-group">
                <input type="password" id="ins_confirmPass" name="ins_confirmPass" class="form-control" placeholder="请再次输入密码">
            </div>
            <div class="form-group">
                <input type="name" id="ins_location" name="ins_location" class="form-control" placeholder="请输入机构地点">
            </div>
            <div class="form-group">
                <input type="number" id="ins_classnum" name="ins_classnum" class="form-control" placeholder="输入机构班级数">
            </div>

            <div class="write_form">
                <table id="addTeacher" class="table table-bordered" style="width: 500px;border-width: 2;margin-top: 10px;text-align: center">
                    <thead>
                    <th>教师姓名</th>
                    <th>等级</th>
                    <th>科目</th>
                    <th></th>
                    </thead>
                    <tbody id="teachers">
                    <tr id="r1">
                        <td><input id="tn1" placeholder="请填写教师姓名"></td>
                        <td>
                            <select id="s1"class="selectpicker">
                                <option>金牌</option>
                                <option>银牌</option>
                                <option>铜牌</option>
                            </select>
                        </td>
                        <td><input id="t1" placeholder="请填写任教科目"></td>
                        <td><button id="b1" type="button" class="btn minus_btn" onclick="del(this)">
                            删除
                        </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <button type="button" class="btn btn-primary" style="margin-top:-150px;margin-left: 700px;" onclick="append_teacher();"> + 新增教师</button>
            </div>
            <br>
            <div class="row">
                <div class="col-xs-8">
                    <a data-toggle="modal" data-target="" data-dismiss="modal" class="text-center">已有账号，去登录吧~</a>
                </div>
                <div class="col-xs-4">
                    <button type="button" class="btn btn-primary btn-block btn-flat" onclick="regis()">注册</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert-dev.min.js"></script>
<script>
    var num=1;
    function del(obj){
        var id=obj.getAttribute("id");
        document.getElementById("addTeacher").deleteRow(document.getElementById(id).rowIndex+1);
    }

    function append_teacher(){
        num=num+1;
        var newLine='<tr id="r'+num+'"><td><input id="tn'+num+'" placeholder="请填写教师姓名"></td> <td> <select id="s'+num+'" style="width: 219px;height: 34px;background: white"> <option>金牌</option> <option>银牌</option> <option>铜牌</option> </select> </td><td><input id="t'+num+'" placeholder="请填写任教科目"></td> <td><button type="button" class="btn minus_btn" onclick="del(this)"> 删除 </button> </td> </tr>';
        $("#teachers").append(newLine);
    }
    function regis(){
        $.ajax({
            type:"post",
            url:"../addIns",
            async:true,
            data:{
                insName:document.getElementById("ins_name").value,
                insPassword:document.getElementById("ins_password").value,
                insLoc:document.getElementById("ins_location").value,
                insClass:document.getElementById("ins_classnum").value,
            },
            success: function(){
                for(var i=1;i<=num;i++) {
                    $.ajax({
                        type: "post",
                        url: "../addTeacher",
                        async: false,
                        data: {
                            teacherName:document.getElementById("tn"+i).value,
                            rank:document.getElementById("s"+i).value,
                            subject:document.getElementById("t"+i).value,
                        },
                        success:function(){
                            swal("成功!", "注册成功，等待审核！", "success")
                            window.setTimeout("window.location='/jsp/addIns.jsp'",2500);
                        }
                    });
                }
            }

        });
    }
</script>
</html>