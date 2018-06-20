<%@ page import="model.Institution" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/13
  Time: 下午8:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>机构-信息统计</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">
    <link href="../css/bootstrap-select.min.css" rel="stylesheet">
    <link href="../css/sta1.css" rel="stylesheet">
    <link href="../css/table.css" rel="stylesheet">
    <%--<link href="../css/check.css" rel="stylesheet">--%>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
</head>
<body>
<%
    Institution institution=(Institution) session.getAttribute("insInfo");
    System.out.println(request.getAttribute("barx"));
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

<div class="navbar navbar-default navbar-fixed" style="width: 135px;height: 2280px;top: 50px">
    <ul class="nav nav-pills nav-stacked" style="margin-top: 50px;">
        <li role="presentation"><a href="showInsBasicInfo"><h5 style="padding-left: 15px">基本信息</h5></a></li>
        <li role="presentation"><a href="showAllClasses"><h5 style="padding-left: 15px">机构计划</h5></a></li>
        <li role="presentation"><a href="showInsOrders"><h5 style="padding-left: 15px">学员登记</h5></a></li>
        <li role="presentation" class="active"><a href=""><h5 style="padding-left: 15px">机构统计</h5></a></li>
    </ul>
</div>

<fieldset style="position:absolute;top:100px;left:200px;width: 1080px;height: 620px">
    <legend>销售状况</legend>
    <div style="position: absolute;top:80px;left:-20px;width: 1080px;height: 600px;">
        <div class="row" style="top: 100px;">
            <div class="col-md-3 col-md-offset-2">
                <div style="background: #337AB7;margin-right: 0.8em;box-shadow: 0 2px 5px 0 rgba(0, 0, 0, 0.16), 0 2px 10px 0 rgba(0, 0, 0, 0.12);transition: 0.5s all;border-radius: 20px">
                    <div class="col-md-8" style="padding: 10px;">
                        <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;"><%=request.getAttribute("ins_ORDERNUM")%> 张</h4>
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
                        <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;"><%=request.getAttribute("ins_STUDENTNUM")%> 人
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
                        <h4 style="color: #fff;font-size: 2.5em;font-family: 'Carrois Gothic', sans-serif;">¥<%=request.getAttribute("ins_MONEY")%>
                        </h4>
                        <h4 style="	font-size: 1.2em;color: #fff;margin: 0.3em 0em;font-family: 'Carrois Gothic', sans-serif;">
                            累计成交</h4>
                        <p style=" color: #fff;font-size: 0.8em;line-height: 1.8em;"></p>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>

            <div class="tab-wrapper" style="margin-top: 160px;">
                <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-1" checked>
                <label for="tab-radio-1" class="tab-handler tab-handler-1">订单信息</label>
                <div class="tab-content tab-content-1">
                    <div id="line1" style="margin-left:-170px;top:20px;width: 640px;height:400px;"></div>
                </div>

                <input type="radio" name="tab-radio" class="tab-radio" id="tab-radio-2">
                <label for="tab-radio-2" class="tab-handler tab-handler-2">其他信息</label>
                <div class="tab-content tab-content-2">
                    <div id="line2" style="margin-left:-170px;width: 640px;height: 400px;"></div>
                </div>
            </div>


        </div>
    </div>
</fieldset>
<fieldset style="position:absolute;top:880px;left:200px;width: 900px;">
    <legend>热门分析</legend>
    <div style="position: absolute;top:80px;left:70px;width: 900px;height: 450px;">
        <div class="row" style="top: 100px;margin-left: 50px;">
            <div class="col-md-3">
                <table class="table table-bordered table-striped" style="width: 180px;">
                    <caption>当月热门课程</caption>
                    <tbody>
                    <%
                        List topCourseMonth=(List)request.getAttribute("cm");
                        for(int i=0;i<topCourseMonth.size();i++){
                    %>
                    <tr>
                        <td><%=topCourseMonth.get(i)%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <div class="col-md-3">
                <table class="table table-bordered table-striped" style="width: 180px;">
                    <caption>当月热门班级</caption>
                    <tbody>
                    <%
                        List topClassMonth=(List)request.getAttribute("tc");
                        for(int i=0;i<topClassMonth.size();i++){
                    %>
                    <tr>
                        <td><%=topClassMonth.get(i)%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <div class="col-md-3">
                <table class="table table-bordered table-striped" style="width: 180px;">
                    <caption>热门课程</caption>
                    <tbody>
                    <%
                        List topCourse=(List)request.getAttribute("ca");
                        for(int i=0;i<topCourse.size();i++){
                    %>
                    <tr>
                        <td><%=topCourse.get(i)%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <div class="col-md-3">
                <table class="table table-bordered table-striped" style="width: 180px;">
                    <caption>热门班级</caption>
                    <tbody>
                    <%
                        List topClass=(List)request.getAttribute("tca");
                        for(int i=0;i<topClass.size();i++){
                    %>
                    <tr>
                        <td><%=topClass.get(i)%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>

            <div id="mapChart" style="margin-left:600px;top:-360px;width: 600px;height:400px;"></div>
        </div>
    </div>
</fieldset>
<fieldset style="position:absolute;top:1340px;left:200px;width: 900px;">
    <legend>活跃学员</legend>
    <div style="position: absolute;top:80px;left:70px;width: 900px;height: 400px;">
        <div class="row" style="top: 100px;">
            <div id="courseTypeChart" style="margin-left:30px;top:20px;width: 400px;height:400px;"></div>
            <div id="courseStatusChart" style="margin-left:480px;top:-380px;width: 400px;height:400px;"></div>
            <div id="gradesChart" style="margin-left:30px;top:-350px;width: 400px;height:400px;"></div>
            <div class="col-md-3" style="margin-top: -700px;margin-left: 560px;">
                <table class="table table-bordered table-striped" style="width: 380px;">
                    <caption style="font-size:18px;">消费前五名</caption>
                    <br/>
                    <thead>
                    <tr>
                        <th>会员名</th>
                        <th>会员等级</th>
                        <th>消费金额</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List top5=(List)request.getAttribute("t5");
                        for(int i=0;i<top5.size();i++){
                            String[] s=top5.get(i).toString().split("-");
                    %>
                    <tr>
                        <td><%=s[0]%></td>
                        <td><%=s[1]%></td>
                        <td><%=s[2]%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</fieldset>
</body>
<script src="../js/echarts.js"></script>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script>
    var courseTypeChart=echarts.init(document.getElementById("courseTypeChart"));
    var mydata = [];
    var key=[];
    <%
    Map<String,Integer> ctMap=(Map<String, Integer>) request.getAttribute("ct");
    for(Map.Entry<String,Integer> entry:ctMap.entrySet()){
    %>
    key.push(<%="\""+entry.getKey()+"\""%>);
    mydata.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=entry.getValue()%>});
    <%
    }
    %>
    option1 = {
        title : {
            text: '学员购买课程类型',
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
                name: '订单',
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
    courseTypeChart.setOption(option1);


    var mydata1 = [];
    var key1=[];
    <%
    Map<String,Integer> csMap=(Map<String, Integer>) request.getAttribute("cs");
    for(Map.Entry<String,Integer> entry:csMap.entrySet()){
    %>
    key1.push(<%="\""+entry.getKey()+"\""%>);
    mydata1.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=entry.getValue()%>});
    <%
    }
    %>
    var courseStatusChart=echarts.init(document.getElementById("courseStatusChart"));
    option2 = {
        title : {
            text: '订单状态',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: key1
        },
        series : [
            {
                name: '订单',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data: mydata1,
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
    courseStatusChart.setOption(option2);

    var mydata2 = [];
    var key2=[];
    <%
    Map<String,Integer> cgMap=(Map<String, Integer>) request.getAttribute("cg");
    for(Map.Entry<String,Integer> entry:cgMap.entrySet()){
    %>
    key2.push(<%="\""+entry.getKey()+"\""%>);
    mydata2.push({"name":<%="\""+entry.getKey()+"\""%>,"value":<%=entry.getValue()%>});
    <%
    }
    %>
    var gradesChart=echarts.init(document.getElementById("gradesChart"));
    option3 = {
        title : {
            text: '成绩比例',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: key2
        },
        series : [
            {
                name: '成绩',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data: mydata2,
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
    gradesChart.setOption(option3);


    var line1 = echarts.init(document.getElementById("line1"));
    line1.clear();
    option = {
        title: {
            text: '订单状况'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['总订单数','总金额','总学员数']

        },
        grid: {
            left: '3%',
//            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: <%=(List)request.getAttribute("months")%>
        },
        yAxis: [
            {
                type: 'value',
                name: '总订单数',
                min: 0,
                position: 'left'
            },{
                type: 'value',
                name: '总金额',
                min: 0,
                position: 'right'
            },{
                type: 'value',
                name: '总学员数',
                min: 0,
                position: 'right',
                offset: 60
            },

        ],
        series: [
            {
                name:'总订单数',
                type:'line',
                data: <%=(List)request.getAttribute("O1")%>
            },
            {
                name:'总金额',
                type:'line',
                yAxisIndex: 1,
                data: <%=(List)request.getAttribute("O2")%>,

            },
            {
                name:'总学员数',
                type:'line',
                data: <%=(List)request.getAttribute("O3")%>
            }
        ]
    };
    if (option && typeof option === "object") {
        line1.setOption(option, true);
    }
//    line1.on('legendselectchanged',function (params) {
//        var selected=params.selected;
//        var seriesName=params.name;
//        switch(seriesName){
//            case '总订单数':
//                if(selected['总订单数']){
//                    option.legend.selected['总订单数']=true;
//                    option.legend.selected['总学员数']=true;
//                }else{
//                    option.legend.selected['总订单数']=false;
//                }
//                break;
//            case '总金额':
//                if(selected['总金额']){
//                    option.legend.selected['总金额']=true;
//                }else{
//                    option.legend.selected['总金额']=false;
//                }
//                break;
//            case '总学员数':
//                if(selected['总学员数']){
//                    option.legend.selected['总学员数']=true;
//                }else{
//                    option.legend.selected['总学员数']=false;
//                }
//                break;
//        }
//        line1.setOption(option);
//    })

    var line2 = echarts.init(document.getElementById("line2"));
    line2.clear();
    option2 = {
        title: {
            text: '订单其他信息'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data:['成交率','平均订单价','线上购买占比']

        },
        grid: {
            left: '3%',
//            right: '4%',
            bottom: '3%',
            containLabel: true
        },
        xAxis: {
            type: 'category',
            boundaryGap: false,
            data: <%=(List)request.getAttribute("months")%>
        },
        yAxis: [
            {
                type: 'value',
                name: '成交率',
                min: 0,
                max: 1,
                position: 'left'
            },{
                type: 'value',
                name: '平均订单价',
                min: 0,
                position: 'right'
            },{
                type: 'value',
                name: '线上购买占比',
                min: 0,
                position: 'right',
                offset: 90
            },

        ],
        series: [
            {
                name:'成交率',
                type:'line',
                data: <%=(List)request.getAttribute("O4")%>
            },
            {
                name:'平均订单价',
                type:'line',
                yAxisIndex: 1,
                data: <%=(List)request.getAttribute("O5")%>
            },
            {
                name:'线上购买占比',
                type:'line',
                data: <%=(List)request.getAttribute("O6")%>
            }
        ]
    };
    if (option2 && typeof option2 === "object") {
        line2.setOption(option2, true);
    }

    <%--var myChart1=echarts.init(document.getElementById("bar"));--%>
    <%--option1 = {--%>
        <%--title : {--%>
            <%--text: '教师班级信息',--%>
            <%--x:'center'--%>
        <%--},--%>
        <%--xAxis: {--%>
            <%--type: 'category',--%>
            <%--data: <%=request.getAttribute("barx")%>,--%>
        <%--},--%>
        <%--yAxis: {--%>
            <%--type: 'value'--%>
        <%--},--%>
        <%--series: [{--%>
            <%--data: <%=request.getAttribute("bary")%>,--%>
            <%--type: 'bar'--%>
        <%--}]--%>
    <%--};--%>
    <%--myChart1.setOption(option1);--%>


</script>
</html>