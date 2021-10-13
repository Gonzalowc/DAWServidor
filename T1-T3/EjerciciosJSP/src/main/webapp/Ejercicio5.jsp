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
<input type="number" name="numero" min=0>
<input type="submit" value="Enviar">

<%if(request.getMethod().equals("POST") && request.getMethod()!=null) {%>
<% int numero = Integer.parseInt(request.getParameter("numero")); %>
	<table border=1>
	<%for(int i=0; i<=10; i++){ %>
	<tr>
	<td><%= i %> X <%= numero %></td>
	<td><%= i*numero %></td>
	</tr>



<%}%>
	</table>	
<% }%>



</form>
</body>
</html>