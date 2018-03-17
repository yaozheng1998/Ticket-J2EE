<%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/16
  Time: 下午6:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>VIPSta</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/vipOrder.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
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
                <li><a href="../jsp/main.jsp">首页</a></li>
                <li><a href="">个人信息</a></li>
            </ul>
            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li><a href="#">机构注册</a></li>--%>
            <%--</ul>--%>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="main">登出</a></li>
            </ul>
            <div id="memberDiv"
                 style="position: absolute;top: 15px;left: 950px;width: 150px;height: 30px;color: black">
                <label>欢迎您, <%=session.getAttribute("id")%></label>
                <p id="name" style="position:absolute;top:0px;left:50px;width:70px;height:20px"></p>
            </div>
        </div>
    </div>
</nav>

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 780px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation"><a href="vipBasicInfo"><h5 style="padding-left: 15px">会员信息</h5></a></li>
        <li role="presentation"><a href="showMyClasses"><h5 style="padding-left: 15px">我的订单</h5></a></li>
        <li role="presentation" class="active"><a href="vipSta"><h5 style="padding-left: 15px">购买统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 900px;height: 620px">
    <legend>购买统计</legend>
    <div style="position: absolute;top:80px;left:-20px;width: 900px;height: 600px;">
        <div class="row" style="top: 100px;">
            <div class="col-md-3 col-md-offset-2">
                <div style="background: #337AB7;margin-right: 0.8em;box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);transition: 0.5s all;border-radius: 20px">
                    <div class="col-md-8" style="padding: 10px;">
                        <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;"><%=request.getAttribute("ORDERNUM")%> 张</h4>
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
                        <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;"><%=request.getAttribute("STUDENTNUM")%> 人
                        </h4>
                        <h4 style="	font-size: 1.2em;color: #fff;margin: 0.3em 0em;font-family: 'Carrois Gothic', sans-serif;">
                            累计人次</h4>
                        <p style=" color: #fff;font-size: 0.8em;line-height: 1.8em;"></p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div class="col-md-3">
                <div style="background: #337AB7;margin-right: 0.8em;box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);transition: 0.5s all;border-radius: 20px">
                    <div class="col-md-8" style="padding: 10px;">
                        <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;">¥<%=request.getAttribute("MONEY")%>
                        </h4>
                        <h4 style="	font-size: 1.2em;color: #fff;margin: 0.3em 0em;font-family: 'Carrois Gothic', sans-serif;">
                            累计消费</h4>
                        <p style=" color: #fff;font-size: 0.8em;line-height: 1.8em;"></p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <div id="pie" style="margin-left:200px;top:100px;width: 600px;height:400px;"></div>
        </div>
    </div>
</fieldset>
<script src="../js/echarts.js"></script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>

<script type="text/javascript">
    var myChart=echarts.init(document.getElementById("pie"));
    option = {
        title : {
            text: '当前订单状态统计',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['待分配','待开班','进行中','已结束','已退订','待支付']
        },
        series : [
            {
                name: '订单',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:<%=request.getAttribute("DI")%>, name:'待分配'},
                    {value:<%=request.getAttribute("OP")%>, name:'待开班'},
                    {value:<%=request.getAttribute("GO")%>, name:'进行中'},
                    {value:<%=request.getAttribute("EN")%>, name:'已结束'},
                    {value:<%=request.getAttribute("RE")%>, name:'已退订'},
                    {value:<%=request.getAttribute("TP")%>, name:'待支付'},
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
</script>
</body>
</html>