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
<label>Nombre del mes: </label>
<input type="text" name="mes"><br/>
<label>Año del mes: </label>
<input type="number" name="anio"><br/>
<label>Texto encima del calendario: </label>
<input type="text" name="texto">
<input type="submit">
</form>


<%
if(request.getMethod().equals("POST") && request.getMethod() != null){
String mes = request.getParameter("mes");
String anio = request.getParameter("anio");
String mensaje = request.getParameter("texto");
String[] meses = {"enero", "febrero","marzo","abril","mayo","junio","agosto","septiembre","octubre","noviembre","diciembre"};
%>
<input type="calendar" value="<%=anio %>-<%= meses[0] %>-1" min="2018-01-01" max="2018-12-31">
<%} %>



</body>
</html>