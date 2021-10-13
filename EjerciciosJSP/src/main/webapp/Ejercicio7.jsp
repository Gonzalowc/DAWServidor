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
<input type="number" name="altura" min=3>
<input type="submit" value="Enviar">
</form>
<%if(request.getMethod().equals("POST") && request.getMethod() != null){ %>
<% int altura = Integer.parseInt(request.getParameter("altura")); %>
<%for(int fila=0; fila < altura; fila++) {%>
<% for(int columna=0; columna<altura*2-1; columna++){ 
		if(columna<altura-fila-1 || columna>altura+fila-1){%>
		<span>[]</span>
		<% }else{/*for if condicion pintar*/ %>
		<span><img src="img/ladrillo.webp" id="euroImg" width="15px"></span>
<%}}/*for columna*/ %>
<br>
<%} /*for fila*/ %>
<%} /*for if method*/ %>
</body>
</html>