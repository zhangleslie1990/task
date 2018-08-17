<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2>Hello World!</h2>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>My JSP 'showCalendar.jsp' starting page</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="/quartzDemo/src/main/jsp/laydate.css">
    <script src="/quartzDemo/src/main/jsp/laydate.js"></script>
</head>

<body>
<!--
<link rel="stylesheet" type="text/css" href="styles.css" mce_href="styles.css">

-->

<jsp:setProperty name="rili" property="*"/>
<form action="" method="post" name="form">
    <!-- 輸入日曆的年份:<input type="text" value="2008" name="year" size=5>-->
    輸入日曆的年份:
    <select name="year">
        <%
            for (int i = 1900; i < 2500; i++) {
                if (i == 2010) {
        %>
        <option value=<%=i%> selected><%=i%>年</option>
        <%
        } else {
        %>
        <option value=<%=i%>><%=i%>年</option>
        <%
                }
            }
        %>
    </select>
    選擇日曆的月份:
    <select name="month">
        <%
            for (int i = 1; i < 13; i++) {
        %>
        <option value=<%=i%>><%=i%>月</option>
        <%
            }
        %>
    </select>
    <br/><input type="submit" value="提交" name="submit">
</form>
<font color="blue">
    <jsp:getProperty name="rili" property="year"/>
</font>年
<font color="green">
    <jsp:getProperty name="rili" property="month"/>
</font>月的日曆
<jsp:getProperty name="rili" property="calendar"/>

</body>
</html>
