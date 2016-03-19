<%@ page language="java" import="java.util.*,pojo.Person" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>人员信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <table  align="center" bordercolor="red" border="2px">
  <tr>
  <td>姓名</td>
  <td>性别</td>
  <td>年龄</td>
  <td>邮箱</td>
  <td>操作</td>
  </tr>
<%
									List<Person> computers = 
									(List<Person>)request.getAttribute("persons");
									for(int i=0;i<computers.size();i++){
										Person p = computers.get(i);
										%>
  <tr>
  <td><%=p.getName() %></td>
  <td><%=p.getGender() %></td>
  <td><%=p.getAge() %></td>
  <td><%=p.getEmail()%></td>
  <td><a href="updateperson.do?id=<%=p.getId() %>">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="deleteperson.do?id=<%=p.getId() %>">删除</a></td>
  </tr>
  <%} %>
  <tr>
  <a href="addperson.jsp"/>增加人员
  </tr>
  
  </table>
  </body>
</html>
