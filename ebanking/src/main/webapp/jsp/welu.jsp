<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*"%>

<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OnlineBank_User</title>
<style type="text/css">
<link href="./resources/css/menu.css" rel="stylesheet" type="text/css" />
<link href="./resources/css/main.css" rel="stylesheet" type="text/css" />
</style>
</head>

<body>
<table width="900" height="500" border="1" align="center" cellpadding="0" cellspacing="0" style="font-weight:normal; background-color:#FFFFFF">
    <tr style="height:30px;">
    <td colspan="3" style="background-color:#2175bc;">&nbsp;</td>
  </tr>
  <%
  String uname=(String)session.getAttribute("uname");
  %>
  <input name="uname" type="hidden" id="uname"  value="<%=uname%>"/>
  <tr>
<td width="160" >
<div id="ddblueblockmenu">
  <div class="menutitle">Account Operations</div>
  <ul>
    <li><a href="jsp/welu.jsp">Welcome,&nbsp;<%=uname%></a></li>
    <li><a href="jsp/account.jsp">Account</a></li>
    <li><a href="jsp/balu.jsp">Balance</a></li>
	<li><a href="jsp/transfer.jsp">Transfer</a></li>
	<li><a href="jsp/loan.jsp">Loan </a></li>
	<li><a href="jsp/userepu.jsp">Report</a></li>
	<li><a href="jsp/logout.jsp">LogOut</a></li>
  </ul>
  <div class="menutitle">&nbsp;</div>
</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>	</td>
    <td colspan="2" style="padding:20px;">
	<div class="box1">
	<marquee><h2><font color="#FF0000">Welcome To Online Bank</font></h2></marquee>
	</div>
	<br/><p align="left" style="line-height:18px; padding:10px; font-weight:normal">The central concept of the application is to allow the  customer(s) to service virtually using the Internet with out going to bank and  allow customers to open new account, withdraw, deposit,  close and  getting balance using this banking service.&nbsp;  The information pertaining to the customers stores on an RDBMS at the  server side (BANK).&nbsp; The Bank services  the customers according to the customer&rsquo;s intention and it updates and backups  of each customer transaction accordingly.</p>
	</td>
  </tr>
  <tr style="height:30px;">
    <td colspan="3" style="background-color:#2175bc;">&nbsp;</td>
  </tr>
</table>
</body>

</html>
