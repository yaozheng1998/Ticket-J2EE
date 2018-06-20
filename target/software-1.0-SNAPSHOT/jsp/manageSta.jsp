<%@ page import="java.util.List" %>
<%@ page import="util.VIPStaVO" %>
<%@ page import="util.InsStaVO" %>
<%@ page import="java.util.Map" %><%--
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
    <title>Manager-网站统计</title>
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

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 1330px;top: 50px">
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
        <label for="tab-radio-1" class="tab-handler tab-handler-1">运营状况</label>
        <div class="tab-content tab-content-1">
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
                    <div id="line1" style="margin-top:140px;margin-left:20px;top:100px;width: 500px;height:400px;"></div>
                    <div id="map" style="margin-left:550px;margin-top:-300px;width: 500px;height: 400px;"></div>
                    <div id="pie" style="margin-left:20px;margin-top:50px;width: 500px;height: 400px;"></div>
                </div>
            </div>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
        <label for="tab-radio-2" class="tab-handler tab-handler-2">财务状况</label>
        <div class="tab-content tab-content-2">
            <!--折线图 销售额随时间的变化-->
            <div id="line2" style="margin-left:50px;top:50px;width: 500px;height:400px;"></div>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-3">
        <label for="tab-radio-3" class="tab-handler tab-handler-3">学员统计</label>
        <div class="tab-content tab-content-3">
            <div class="write_form">
                <table id="info" class="table table-bordered table-striped" style="margin-left:-22px;width: 900px;border-width: 1px;margin-top: 10px;text-align: center">
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
            <!--学员总数与时间的变化关系-->
            <div id="line3" style="margin-top:10px;margin-left:30px;top:70px;width: 500px;height:400px;"></div>
        </div>

        <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-4">
        <label for="tab-radio-4" class="tab-handler tab-handler-3">机构统计</label>
        <div class="tab-content tab-content-4">
            <div class="write_form">
                <table id="regist" class="table table-bordered table-striped" style="margin-left:-22px;width: 980px;border-width: 1px;margin-top: 10px;text-align: center">
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
            <!--机构总数与时间的变化关系-->
            <!--机构总数与地域之间的关系-->
            <!--某月前十名销售额／学员数-->
            <!--总时间销售额／学员数-->
            <div id="line4" style="margin-top:40px;margin-left:-40px;top:100px;width: 500px;height:400px;"></div>
            <div id="map2" style="margin-top:-400px;margin-left:490px;top:100px;width: 500px;height:400px;"></div>
            <div class="row" style="top: 100px;margin-left: -20px;margin-top: 210px;">
                <div class="col-md-3">
                    <table class="table table-bordered table-striped" style="width: 230px;right: 10px;">
                        <caption>当月机构销售额排行</caption>
                        <thead>
                        <tr>
                            <th>机构名</th>
                            <th>地点</th>
                            <th>销售额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List topMoneyMonth=(List)request.getAttribute("tm");
                            for(int i=0;i<topMoneyMonth.size();i++){
                                String[] s1=topMoneyMonth.get(i).toString().split("-");
                        %>
                        <tr>
                            <td><%=s1[0]%></td>
                            <td><%=s1[1]%></td>
                            <td><%=s1[2]%></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-3">
                    <table class="table table-bordered table-striped" style="width: 180px;">
                        <caption>当月机构学员数排行</caption>
                        <thead>
                        <tr>
                            <th>机构名</th>
                            <th>学员总数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List topNumMonth=(List)request.getAttribute("tn");
                            for(int i=0;i<topNumMonth.size();i++){
                                String[] s2=topNumMonth.get(i).toString().split("-");
                        %>
                        <tr>
                            <td><%=s2[0]%></td>
                            <td><%=s2[1]%></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-3">
                    <table class="table table-bordered table-striped" style="width: 230px;">
                        <caption>机构销售额排行</caption>
                        <thead>
                        <tr>
                            <th>机构名</th>
                            <th>地点</th>
                            <th>销售额</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List topMoneyAll=(List)request.getAttribute("tma");
                            for(int i=0;i<topMoneyAll.size();i++){
                                String[] s3=topMoneyAll.get(i).toString().split("-");
                        %>
                        <tr>
                            <td><%=s3[0]%></td>
                            <td><%=s3[1]%></td>
                            <td><%=s3[2]%></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
                <div class="col-md-3">
                    <table class="table table-bordered table-striped" style="width: 180px;">
                        <caption>机构学员数排行</caption>
                        <thead>
                        <tr>
                            <th>机构名</th>
                            <th>学员总数</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                            List topNumAll=(List)request.getAttribute("tna");
                            for(int i=0;i<topNumAll.size();i++){
                                String[] s4=topNumAll.get(i).toString().split("-");
                        %>
                        <tr>
                            <td><%=s4[0]%></td>
                            <td><%=s4[1]%></td>
                        </tr>
                        <%
                            }
                        %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<script src="../js/jquery-3.3.1.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/bootstrap-select.js"></script>
<script src="../js/echarts.js"></script>
<script src="../js/china.js"></script>
<script>
    var line1=echarts.init(document.getElementById("line1"));
    line1.clear();
    option1 = {
        title : {
            text: '课程平均售价/成交率变化',
            x: 'left',
            align: 'left'
        },
        grid: {
            bottom: 80
        },
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                animation: false,
                label: {
                    backgroundColor: '#505765'
                }
            }
        },
        legend: {
            data:['平均售价','成交率'],
            x: 'right'
        },
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                axisLine: {onZero: false},
                data : <%=(List)request.getAttribute("M")%>
            }
        ],
        yAxis: [
            {
                name: '平均售价(元)',
                type: 'value',
                max: 10000
            },
            {
                name: '成交率',
                nameLocation: 'start',
                max: 1,
                type: 'value',
//                inverse: true
            }
        ],
        series: [
            {
                name:'平均售价',
                type:'line',
                animation: false,
                areaStyle: {
                    normal: {}
                },
                lineStyle: {
                    normal: {
                        width: 1
                    }
                },
                data: <%=(List)request.getAttribute("AVERAGE")%>

            },
            {
                name:'成交率',
                type:'line',
                yAxisIndex:1,
                animation: false,
                areaStyle: {
                    normal: {}
                },
                lineStyle: {
                    normal: {
                        width: 1
                    }
                },
                data: <%=(List)request.getAttribute("OK")%>
            }
        ]
    };
    line1.setOption(option1,true);

    <%--var myChart1=echarts.init(document.getElementById("vipBar"));--%>
    <%--option1 = {--%>
        <%--title : {--%>
            <%--text: '会员统计信息',--%>
            <%--x:'center'--%>
        <%--},--%>
        <%--color: ['rgb(129,204,175)'],--%>
        <%--tooltip : {--%>
            <%--trigger: 'axis',--%>
            <%--axisPointer : {            // 坐标轴指示器，坐标轴触发有效--%>
                <%--type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'--%>
            <%--}--%>
        <%--},--%>
        <%--xAxis: {--%>
            <%--type: 'category',--%>
            <%--data: <%=request.getAttribute("vipx")%>,--%>
        <%--},--%>
        <%--yAxis: {--%>
            <%--type: 'value'--%>
        <%--},--%>
        <%--series: [{--%>
            <%--data: <%=request.getAttribute("vipy")%>,--%>
            <%--type: 'bar'--%>
        <%--}]--%>
    <%--};--%>
    <%--myChart1.setOption(option1);--%>

    <%--var myChart2=echarts.init(document.getElementById("insBar"));--%>
    <%--option2 = {--%>
        <%--title : {--%>
            <%--text: '机构统计信息',--%>
            <%--x:'center'--%>
        <%--},--%>
        <%--color: ['rgb(129,204,175)'],--%>
        <%--tooltip : {--%>
            <%--trigger: 'axis',--%>
            <%--axisPointer : {            // 坐标轴指示器，坐标轴触发有效--%>
                <%--type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'--%>
            <%--}--%>
        <%--},--%>
        <%--xAxis: {--%>
            <%--type: 'category',--%>
            <%--data: <%=request.getAttribute("insx")%>,--%>

        <%--},--%>
        <%--yAxis: {--%>
            <%--type: 'value'--%>
        <%--},--%>
        <%--series: [{--%>
            <%--data: <%=request.getAttribute("insy")%>,--%>
            <%--type: 'bar',--%>
        <%--}]--%>
    <%--};--%>
    <%--myChart2.setOption(option2);--%>

    var map=echarts.init(document.getElementById("map"));
    map.clear();
    var num1 = [];
    var num2=[];
    var num3=[];
    var num4=[];
    <%
    Map<String,String> locationMap=(Map<String, String>) request.getAttribute("LOCATION1");
    for(Map.Entry<String,String> entry:locationMap.entrySet()){
        String[] s=entry.getValue().split("-");
    %>
    num1.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=Integer.parseInt(s[0])%>});
    num2.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=Double.parseDouble(s[1])%>});
    num3.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=Integer.parseInt(s[2])%>});
    num4.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=Double.parseDouble(s[3])%>});
    <%
    }
    %>
    console.log(num1);
    console.log(num2);
    console.log(num3);
    console.log(num4);
    var option3 = {
        backgroundColor: '#FFFFFF',
        title: {
            text: '网站课程与地域的关系',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: function(params){
                var series=map.getOption().series;
                console.log(params['name']);
                var res='<div><p>'+params['name']+'</p>';
                for(var i=0;i<series.length;i++){
                    var dataArr=series[i].data;
                    for(var j=0;j<series[i].data.length;j++){
                        if(dataArr[j].name==params['name']){
                            res+='<p>'+series[i].name+': '+dataArr[j].value+'</p>';
                        }
                    }
                }
                res+='</div>';
                return res;
            }
        },
        visualMap: {
            show : false,
            x: 'left',
            y: 'bottom',
            splitList: [
                {start: 500, end:600},{start: 400, end: 500},
                {start: 300, end: 400},{start: 200, end: 300},
                {start: 100, end: 200},{start: 0, end: 100},
            ],
            color: ['#66CC33', '#00FF00', '#66FF33','#339900', '#33CC00', '#00CC00']
        },
        legend: {
            data:['订单数量','订单总额','课程销售数量','课程平均售价'],
            x: 'right',
            top: 40
        },
        series: [
            {
                name: '订单数量',
                type: 'map',
                mapType: 'china',
                roam: true,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                data:num1
            },
            {
                name: '订单总额',
                type: 'map',
                mapType: 'china',
                roam: true,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                data:num2
            },
            {
                name: '课程销售数量',
                type: 'map',
                mapType: 'china',
                roam: true,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                data:num3
            },
            {
                name: '课程平均售价',
                type: 'map',
                mapType: 'china',
                roam: true,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                data:num4
            }
        ]
    };
    map.setOption(option3);


    var pie=echarts.init(document.getElementById("pie"));
    pie.clear();
    var mydata = [];
    var key=[];
    <%
    Map<String,String> typeMap=(Map<String,String>) request.getAttribute("TYPE");
    for(Map.Entry<String,String> entry:typeMap.entrySet()){
        String[] values=entry.getValue().split("-");
    %>
    key.push(<%="\""+entry.getKey()+"\""%>);
    mydata.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=values[0]%>});
    <%
    }
    %>
    optionPie = {
        title : {
            text: '课程销售与类型关系',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: key
        },
        series : [
            {
                name: '销售量',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data: mydata,
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
    pie.setOption(optionPie);

    var line3=echarts.init(document.getElementById("line3"));
    line3.clear();
    optionline3 = {
        title: {
            text: '学员总数变化情况'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['学员总数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: <%=request.getAttribute("M")%>
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name:'学员总数',
                type:'line',
                data: <%=request.getAttribute("STUDENT")%>
            }
        ]
    };
    line3.setOption(optionline3,true);

    var line4=echarts.init(document.getElementById("line4"));
    line4.clear();
    optionline4 = {
        title: {
            text: '机构总数变化情况'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['机构总数']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: <%=request.getAttribute("M")%>
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name:'机构总数',
                type:'line',
                stack: '总量',
                data: <%=request.getAttribute("INS")%>
            }
        ]
    };
    line4.setOption(optionline4);

    var line2=echarts.init(document.getElementById("line2"));
    line2.clear();
    optionline2 = {
        title: {
            text: '机构总销售额变化情况'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['销售额']
        },
        grid: {
            left: '3%',
            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: <%=request.getAttribute("M")%>
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                name:'销售额',
                type:'line',
                data: <%=request.getAttribute("MC")%>
            }
        ]
    };
    line2.setOption(optionline2);


    var map2=echarts.init(document.getElementById("map2"));
    map2.clear();
    var map2data=[];
    <%
    Map<String,Integer> insLo=(Map<String, Integer>) request.getAttribute("insLO");
    for(Map.Entry<String,Integer> entry:insLo.entrySet()){

    %>
    map2data.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=entry.getValue()%>});
    <%
    }
    %>
    var optionMap2 = {
        backgroundColor: '#FFFFFF',
        title: {
            text: '机构总数与地域的关系',
            x:'center'
        },
        tooltip : {
            trigger: 'item'
        },
        visualMap: {
            show : false,
            x: 'left',
            y: 'bottom',
            splitList: [
                {start: 500, end:600},{start: 400, end: 500},
                {start: 300, end: 400},{start: 200, end: 300},
                {start: 100, end: 200},{start: 0, end: 100},
            ],
            color: ['#66CC33', '#00FF00', '#66FF33','#339900', '#33CC00', '#00CC00']
        },
        legend: {
            data:['机构数量'],
            x: 'bottom'
        },
        series: [
            {
                name: '机构数量',
                type: 'map',
                mapType: 'china',
                roam: true,
                label: {
                    normal: {
                        show: false
                    },
                    emphasis: {
                        show: false
                    }
                },
                data:map2data
            }
        ]
    };
    map2.setOption(optionMap2);
</script>
</body>
</html>