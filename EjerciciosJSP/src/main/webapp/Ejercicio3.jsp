<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
double notaMedia=0;
if(request.getMethod().equals("POST")){
	double sumaNotas = Double.parseDouble(request.getParameter("nota1"))+Double.parseDouble(request.getParameter("nota2"))+Double.parseDouble(request.getParameter("nota3"));
	notaMedia = sumaNotas/3;
}
%>
<form method="post">
<input type="number" name="nota1" required><br/>
<input type="number" name="nota2" required><br/>
<input type="number" name="nota3" required><br/>
<input type="submit" value="calcular">
</form>
<label >La media es: <% if(request.getMethod().equals("POST")){%>
<%= notaMedia %>
<% } %></label>

</body>
</html>