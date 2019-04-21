<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="mybean.data.Register" %>
<jsp:useBean id="register" class="mybean.data.Register" scope="request" />
<jsp:setProperty name="register" property="*" />

<head><%@ include file="head.txt" %></head>
<html><center>

<font size="4" color="blue">
    <br><jsp:getProperty name="register" property="backNews" />
</font>

<table>
    <tr><td>зЂВсаеУћЃК</td>
        <td><jsp:getProperty name="register" property="usr" /></td>
    </tr>
    <tr><td>зЂВсгЪЯфЃК</td>
        <td><jsp:getProperty name="register" property="email" /></td>
    </tr>
    <tr><td>зЂВсЕчЛАЃК</td>
        <td><jsp:getProperty name="register" property="phone" /></td>
    </tr>
</table>

</center></body></html>
