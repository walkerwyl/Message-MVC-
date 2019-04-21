<%@ page contentType="text/html;charset=gb2312" %>
<%@ page import="mybean.data.Register" %>
<jsp:useBean id="register" class="mybean.data.Register" scope="request" />

<head><%@ include file="head.txt" %></head>
<html>
<title>Message Port Sign Page</title>
<h1><center>Register Page</center></h1>

<center>
<form action="heipRigster" method="post">
    <table align="center">
	     <tr><td>Your name:</td>    <td><input type="text" name="usr"><br></td></tr>
	      <tr><td>Your password:</td>  <td><input type="text" name="passwd"><br></td></tr>
	       <tr><td><input type="submit" value="Send"><input type="reset" value="Clear"><br></td></tr>
    </table>
</form>
<jsp:setProperty name="register" property="*" />
</center>

</body>
</html>
