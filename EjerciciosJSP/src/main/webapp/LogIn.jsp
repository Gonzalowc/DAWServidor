<%@page import="iesalixar.servidor.login.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<form method="post">
<input type="text" name="usuario">
<input type="password" name="password">
<input type="submit" value="Enviar">
</form>
<%if(request.getMethod().equals("POST") && request.getMethod() !=null){ %>
<jsp:useBean id="login" scope="request" class="iesalixar.servidor.login.Usuario" type= "iesalixar.servidor.login.Usuario">
	<jsp:setProperty name="login" property="usuario" />
	<jsp:setProperty name="login" property="password" />
</jsp:useBean>
<%=login.getPassword() %>
<%=login.getUsuario() %>
<%=login.isUserValid()%>
<%=login.saludarAlicia() %>

<% 
request.setAttribute("usuario", login);
request.getRequestDispatcher("login2.jsp").forward(request, response); %>
<%} %>

</body>
</html>