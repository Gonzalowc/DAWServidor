<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
if (request.getMethod().equals("POST")){
if(request.getParameter("usuario").equals("admin") && request.getParameter("pass").equals("admin")){ %>
<jsp:forward page="admin.jsp"></jsp:forward>
<%}else if(request.getParameter("usuario").equals("usuario") && request.getParameter("pass").equals("usuario")) {%>
<jsp:forward page="usuario.jsp"></jsp:forward>
<%}else{ %>
<h1 style="color:red;">Datos erroneos</h1>
<%} }%>
<form method="post">
<label>Usuario</label>
<input type="text" name="usuario"><br/>
<label>contraseña</label>
<input type="password" name="pass"><br/>
<input type="submit" value="Enviar">
</form>


</body>
</html>