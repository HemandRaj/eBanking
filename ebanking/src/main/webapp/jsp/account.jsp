<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*"%>
<%@ page import="com.hemand.ebanking.bean.userBean" %>
<%@ page import="com.hemand.ebanking.dao.commonDAO" %>
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>OnlineBank_User</title>
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
  <tr>
<td width="160" >
<div id="ddblueblockmenu">
  <div class="menutitle">Account Operations</div>
  <ul>
    <li><a href="jsp/welu.jsp">Home</a></li>
  </ul>
  <div class="menutitle">&nbsp;</div>
</div>

<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>	</td>
      <td colspan="2" style="padding:20px;">
	<div class="box1">
	<marquee><h2><font color="#FF0000">Welcome To Online Bank.</font></h2></marquee>
	</div>
	<br/>
	  <table width="70%" border="0" align="center" cellpadding="2" cellspacing="2">
        <tr>
          <th colspan="3" bgcolor="#333333" scope="col"><font color="#FFFFFF">Account Details</font></th>
        </tr>
        <tr>
          <td width="39%">&nbsp;</td>
          <td width="3%">&nbsp;</td>
          <td width="58%">&nbsp;</td>
        </tr>
        <%
        userBean user = new userBean();
        user = commonDAO.retriveUser(uname);
		%>
        <table>
	       <center>   
		       <tr><td><strong>Account Number :</strong></td><td><input type='text' name='accno' value=<%=user.accountNumber %>><br><br></td></tr>
	           <tr><td><strong>Name    :</strong></td><td><input type='textarea' name='name' value=<%=user.name %>><br><br></td></tr>
		       <tr><td><strong>Gender:</strong></td><td><input type='text' name='gen' value=<%=user.gender %>><br><br></td></tr>
		       <tr><td><strong>DateOfBirth:</strong></td><td><input type='text' name='dob' value=<%=user.dob %>><br><br></td></tr>
               <tr><td><strong>DateOfJoin:</strong></td><td><input type='text' name='doj' value=<%=user.doj %>><br><br></td></tr>
		       <tr><td><strong>Address   :</strong></td><td><input type='text' name='add' value=<%=user.address %>><br><br></td></tr>
		       <tr><td><strong>Mobile   :</strong></td><td><input type='text' name='mob' value=<%=user.mobile %>><br><br></td></tr>
    		   <tr><td><strong>Email   :</strong></td><td><input type='text' name='email' value=<%=user.email %>><br><br></td></tr>
		       <tr><td><Strong>Type   :</Strong></td><td><input type='text' name='type' value=<%=user.accountType %>><br><br></td></tr>
		   </center>  
	    </table>
	</tr>
</table>
  <tr style="height:30px;">
    <td colspan="3" style="background-color:#2175bc;">&nbsp;</td>
  </tr>
</table>
</body>

</html>
