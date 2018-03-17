<%--
  Created by IntelliJ IDEA.
  User: YZ
  Date: 2018/3/13
  Time: 下午4:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>InsSuccess</title>
</head>
<body>
    <b>您的机构注册已完成！请等待管理员审核</b>
    <b>您的机构编号为<%=session.getAttribute("insId")%>,您将以此编号登录，请妥善保存～</b>
    <a href="../main">Training College</a>
</body>
</html>
