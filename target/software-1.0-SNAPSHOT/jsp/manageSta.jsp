<%@ page import="java.util.List" %>
<%@ page import="util.VIPStaVO" %>
<%@ page import="util.InsStaVO" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/16
  Time: 下午7:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ManagerStatistic</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/sta.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
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
            <a class="navbar-brand" style="margin-left: -50px">Training经理版</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="../jsp/main.jsp">首页</a></li>
            </ul>
            <div id="memberDiv"
                 style="position: absolute;top: 15px;left: 950px;width: 150px;height: 30px;color: black">
                <label>欢迎您, </label>
                <p id="name" style="position:absolute;top:0px;left:50px;width:70px;height:20px">Manager</p>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="main">登出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation"><a href="showApp"><h5 style="padding-left: 15px">机构审批</h5></a></li>
        <li role="presentation"><a href="sump"><h5 style="padding-left: 15px">支付结算</h5></a></li>
        <li role="presentation" class="active"><a href="manageSta"><h5 style="padding-left: 15px">网站统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>网站统计</legend>
    <div class="tab-wrapper" style="margin-top: 10px;">
        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
        <label for="tab-radio-1" class="tab-handler tab-handler-1">机构统计</label>
        <div class="tab-content tab-content-1">
            <div class="write_form">
                <table id="regist" class="table table-bordered" style="margin-left:-92px;width: 980px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>机构编号</th>
                    <th>机构名</th>
                    <th>地点</th>
                    <th>班级数</th>
                    <th>总销量</th>
                    <th>总销售额</th>
                    </thead>
                    <tbody>
                    <%
                        List<InsStaVO> insStaVOS= (List<InsStaVO>) request.getAttribute("INSTABLE");
                        for(int i=0;i<insStaVOS.size();i++){
                                    InsStaVO vo=insStaVOS.get(i);
                    %>
                    <tr>
                        <td><%=vo.getIns_id()%></td>
                        <td><%=vo.getIns_name()%></td>
                        <td><%=vo.getLocation()%></td>
                        <td><%=vo.getClass_num()%></td>
                        <td><%=vo.getOrder_num()%></td>
                        <td><%=vo.getMoney()%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
        <label for="tab-radio-2" class="tab-handler tab-handler-2">学员统计</label>
        <div class="tab-content tab-content-2">
            <div class="write_form">
                <table id="info" class="table table-bordered" style="margin-left:-92px;width: 900px;border-width: 1;margin-top: 10px;text-align: center">
                    <thead>
                    <th>会员名</th>
                    <th>会员等级</th>
                    <th>总订单数</th>
                    <th>总金额</th>
                    </thead>
                    <tbody>
                    <%
                        List<VIPStaVO> vipStaVOS= (List<VIPStaVO>) request.getAttribute("VIPTABLE");
                        for(int i=0;i<vipStaVOS.size();i++){
                            VIPStaVO vo=vipStaVOS.get(i);
                    %>
                    <tr>
                        <td><%=vo.getVip_name()%></td>
                        <td><%=vo.getVip_rank()%></td>
                        <td><%=vo.getOrder_num()%></td>
                        <td><%=vo.getAll_money()%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-3">
        <label for="tab-radio-3" class="tab-handler tab-handler-3">财务统计</label>
        <div class="tab-content tab-content-3">
            <div style="position: absolute;top:10px;left:0px;width: 900px;height: 600px;">
                <div class="row" style="top: 100px;">
                    <div class="col-md-3 col-md-offset-2">
                        <div style="background: #337AB7;margin-right: 0.8em;box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);transition: 0.5s all;border-radius: 20px">
                            <div class="col-md-8" style="padding: 10px;">
                                <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;"><%=request.getAttribute("MORDER")%> 张</h4>
                                <h4 style="	font-size: 1.2em;color: #fff;margin: 0.3em 0em;font-family: 'Carrois Gothic', sans-serif;">
                                    累计订单</h4>
                                <p style=" color: #fff;font-size: 0.8em;line-height: 1.8em;"></p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div style="background: #337AB7;margin-right: 0.8em;box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);transition: 0.5s all;border-radius: 20px">
                            <div class="col-md-8" style="padding: 10px;">
                                <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;"><%=request.getAttribute("MSTUDENT")%> 人
                                </h4>
                                <h4 style="	font-size: 1.2em;color: #fff;margin: 0.3em 0em;font-family: 'Carrois Gothic', sans-serif;">
                                    听课人次</h4>
                                <p style=" color: #fff;font-size: 0.8em;line-height: 1.8em;"></p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div style="background: #337AB7;margin-right: 0.8em;box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);transition: 0.5s all;border-radius: 20px">
                            <div class="col-md-8" style="padding: 10px;">
                                <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;">¥<%=request.getAttribute("MMONEY")%>
                                </h4>
                                <h4 style="	font-size: 1.2em;color: #fff;margin: 0.3em 0em;font-family: 'Carrois Gothic', sans-serif;">
                                    累计成交</h4>
                                <p style=" color: #fff;font-size: 0.8em;line-height: 1.8em;"></p>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                    <div id="vipBar" style="margin-top:140px;margin-left:50px;top:100px;width: 500px;height:400px;"></div>
                    <div id="insBar" style="margin-left:600px;margin-top:-300px;width: 500px;height: 400px;"></div>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<script src="../js/echarts.js"></script>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script>
    var myChart1=echarts.init(document.getElementById("vipBar"));
    option1 = {
        title : {
            text: '会员统计信息',
            x:'center'
        },
        color: ['rgb(129,204,175)'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        xAxis: {
            type: 'category',
            data: <%=request.getAttribute("vipx")%>,
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: <%=request.getAttribute("vipy")%>,
            type: 'bar'
        }]
    };
    myChart1.setOption(option1);

    var myChart2=echarts.init(document.getElementById("insBar"));
    option2 = {
        title : {
            text: '机构统计信息',
            x:'center'
        },
        color: ['rgb(129,204,175)'],
        tooltip : {
            trigger: 'axis',
            axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
            }
        },
        xAxis: {
            type: 'category',
            data: <%=request.getAttribute("insx")%>,

        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: <%=request.getAttribute("insy")%>,
            type: 'bar',
        }]
    };
    myChart2.setOption(option2);
</script>
</body>
</html>