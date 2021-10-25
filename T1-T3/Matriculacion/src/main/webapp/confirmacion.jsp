<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Confirmación</title>
<%
HttpSession sesion = request.getSession(false);
String curso = null;
Cookie[] cookies = null;
if (sesion != null) {
	cookies = request.getCookies();
	for (int i = 0; i < cookies.length; i++) {
		if (cookies[i].getName().equals("curso")) {
	curso = cookies[i].getValue();
	break;
		}
	}
}
%>
</head>
Estos son tus datos: 
Nombre:<%=sesion.getAttribute("nombre")%><br/>
Apellidos:<%=sesion.getAttribute("apellidos")%><br />
Correo:<%=sesion.getAttribute("correo")%><br />
Curso:<% if(curso!=null){ %>
<%=curso%><br/>
<%}else{%>No seleccionado<br/>
<%} %>
Modulos:
<%if(sesion.getAttribute("modulos") != "null"){ %>
<%=sesion.getAttribute("modulos")%><br/>
<%}else{ %>No seleccionados<br/>
<%} %>

<br/>USUARIO BEAN<br/>
<jsp:useBean id="userBean" scope="session" class="servidor.controller.Usuario"></jsp:useBean>

Usuario <%=userBean.getUsuario() %>
Nombre <%=userBean.getNombre() %>
Correo <%=userBean.getCorreo() %>
modulos <%=userBean.getModulos() %>
objeto <%=userBean.toString() %>
</body>
</html>