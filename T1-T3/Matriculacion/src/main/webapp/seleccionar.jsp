<%@page import="java.io.Console"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
HttpSession sesion = request.getSession();
String nombre =(sesion.getAttribute("nombre")==null)?(String)sesion.getAttribute("usuario"):(String)sesion.getAttribute("nombre");
String apellidos =(sesion.getAttribute("nombre")==null)?"":(String)sesion.getAttribute("apellidos");
String correo =(sesion.getAttribute("nombre")==null)?"":(String)sesion.getAttribute("correo");
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
<body>
<form method="post">
<label for="usuario">Usuario</label>
	<input type="text" name="usuario" id="usuario" value="<%=session.getAttribute("usuario")%>"><br/>
	<label for="nombre">Nombre</label>
	<input type="text" name="nombre" id="nombre" value="<%=nombre%>"><br/>
	<label for="apellidos">Apellidos</label>
	<input type="text" name="apellidos" id="apellidos" value="<%=apellidos %>"><br/>
	<label for="correo">Correo</label>
	<input type="email" name="correo" id="correo"><br/><br/>
	<label for="curso">Curso<br/>
	<%if(curso==null){ %>
	DAW 1<input type="radio" value="DAW1" name="curso">
	DAW 2<input type="radio" value="DAW2" name="curso">
	<%}else if(curso.equals("DAW2")){ %>
	DAW 1<input type="radio" value="DAW1" name="curso">
	DAW 2<input type="radio" value="DAW2" name="curso" checked>
	<%}else if(curso.equals("DAW1")){ %>
	DAW 1<input type="radio" value="DAW1" name="curso" checked>
	DAW 2<input type="radio" value="DAW2" name="curso">
	<%} %>
	</label><br/><br/>
	<label for="modulos">Modulos:<br/>
	SERVIDOR <input type="checkbox" name="modulos" value="SERVIDOR"><br/>
	CLIENTE <input type="checkbox" name="modulos" value="CLIENTE"><br/>
	DAW     <input type="checkbox" name="modulos" value="DAW"><br/>
	DIW     <input type="checkbox" name="modulos" value="DIW"><br/>
	INTERFAZ <input type="checkbox" name="modulos" value="INTERFAZ">
	</label><br/>
	<input type="submit" value="Matricular">
</form>
</body>
</html>