<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% HttpSession sesion = request.getSession();
	if(sesion.isNew() || sesion.getAttribute("usuario")==null){%>
		<form method="post">
		<label for="usuario">Usuario: </label>
		<input type="text" name="usuario"><br>
		<label for="password">Passowrd</label>
		<input type="password" name="password">
		<input type="submit" name="enviar" value="Entrar">
		</form>
	<%}else{%>
		<p>Está logeado con el usuario <%= sesion.getAttribute("usuario") %></p>
		<a href="LogOut">Salir</a>
	<%}%>
</body>
</html>