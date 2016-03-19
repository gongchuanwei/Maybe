<%@ page language="java" import="java.util.*,pojo.Person" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改人缘信息</title>
    
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
  <% 
								Person p=	(Person)request.getAttribute("person");
									
										%>
  <form action="save.do?id=<%=p.getId() %>" method="post">
  
  姓名： <input type="text" name="name" value="<%=p.getName() %>"/><br/>
   年龄： <input type="text" name="age" value="<%=p.getAge() %>"/><br/>
    性别： <input type="text" name="gender" value="<%=p.getGender() %>"/><br/>
     email： <input type="text" name="email" value="<%=p.getEmail() %>"/><br/>
     <input type="submit" value="确认修改"/>
  
  </form>
  </body>
</html>
