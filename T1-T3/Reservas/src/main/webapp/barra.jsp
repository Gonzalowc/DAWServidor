<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%HttpSession sesion = request.getSession(); %>
<div class="barra">
<h3><a href="Inicio">Volver</a></h3>
<h3><a href="Logout">Salir</a></h3><br/>
<h4>Usuario: <%=sesion.getAttribute("usuario") %>
Sesion: <%=sesion.getAttribute("horaLogin") %></h4>
</div>
</body>
</html>