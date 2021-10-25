<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{
margin: 0 auto;
text-align: center;
}
</style>
</head>
<body>
<% HttpSession sesion = request.getSession(false);
if(sesion!=null  && sesion.getAttribute("usuario")!=null && sesion.getAttribute("horaLogin")!=null){
%>
<jsp:include page="barra.jsp" />
<img src="indice.png">
<%}else{ %>
<h1 class="title">CENTRAL DE VIAJES</h1>
<form method="post">
	<p>
		<label for="usuario">Usuario</label><br/>
		<input type="text" name="usuario" id="usuario" required>
	</p>
	<p>
		<label for="password">Password</label><br/>
		<input type="password" name="password" id="password" required>
	</p>
	<p>
	<label for="confPassword">Confirmar Password</label><br/>
	<input type="password" name="confPassword" id="confPassword" required>
	</p>
	<p>
	<label for="correo">Email</label><br/>
	<input type="email" name="correo" id="correo" required> 
	<p>
	<input type="submit" value="REGISTRARSE">
</form>

<%} %>
</body>
</html>