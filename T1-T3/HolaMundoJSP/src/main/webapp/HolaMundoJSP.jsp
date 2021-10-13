<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pruebaJSP</title>
</head>
<body>
	<h1>Hola Mundo JSP</h1>
	<h3>Añadiendo texto a mi JSP</h3>
	<%
	out.println("<ul>");
	for(int i = 0; i<20; i++){
		out.println("<li>"+i+"</li>");
	}
	out.println("</ul>");
	%>
</body>
</html>