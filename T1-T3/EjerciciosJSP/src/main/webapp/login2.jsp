<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(request.getMethod().equals("POST") && request.getMethod() != null){ %>
	<%if(request.getAttribute("usuario")!= null){ %>
	<jsp:useBean id="pepe" scope="request" class="iesalixar.servidor.login.Usuario"></jsp:useBean>
	<%=pepe.getUsuario() %><br/>
	<%=pepe.getPassword() %>
	<%} %>
<%} %>
</body>
</html>