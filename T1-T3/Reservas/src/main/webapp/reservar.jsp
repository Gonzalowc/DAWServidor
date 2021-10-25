<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%HttpSession sesion = request.getSession(false);%>

<%if(sesion!=null  && sesion.getAttribute("usuario")!=null && sesion.getAttribute("horaLogin")!=null){%>
<jsp:include page="barra.jsp" />
<h1>DATOS DE LA RESERVA</h1>
<form method="post">
<p>
<label for="fInicio">Fecha de Inicio</label>
<input type="date" name="fInicio" id="fInicio" required>
</p>
<p>
<label for="fFin">Fecha de Fin</label>
<input type="date" name="fFin" id="fFin" required>
</p>
<p>
<label for="NPersonas">Número de personas</label>
<input type="number" name="NPersonas" id="NPersonas" required>
</p>
<p>
<H2><label for="servicios">SERVICIOS</label></H2>
<input type="checkbox" name="servicios" value="wifi">Wifi 
<input type="checkbox" name="servicios" value="Limpieza">Limpieza<br/>
<input type="checkbox" name="servicios" value="Toallas">Toallas
<input type="checkbox" name="servicios" value="Ruta Giada">Ruta guíada<br/>
<input type="checkbox" name="servicios" value="Desayuno">Desayuno
<input type="checkbox" name="servicios" value="Sauna">Sauna
</p>
<input type="submit" value="RESERVAR">
</form>
<%} %>
</body>
</html>