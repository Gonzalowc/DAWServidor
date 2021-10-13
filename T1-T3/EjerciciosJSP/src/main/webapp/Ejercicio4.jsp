<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/Ejercicio2.css">
</head>
<body>
<form method="post">
<label>Euros:</label>
<input type="number" name="euro" value=0 min=0><br/>
<label>Dolares:</label>
<input type="number" name="dolar" value=0 min=0><br/>
<input type="submit" name="aEuro" value="aEuro">
<input type="submit" name="aDolar" value="aDollar"> 
</form>

<%
double cambio=0;
if( request.getMethod().equals("POST") ){ 
	if(request.getParameter("aDolar")!=null && request.getParameter("aDolar").equals("aDollar") && request.getParameter("dolar")!=null ){
		cambio = Double.parseDouble(request.getParameter("euro"))*1.15;
%>
<p>El cambio de <%= request.getParameter("euro") %><img src="img/euro.png" id="euroImg">. Son <%= cambio %><img src="img/dolar.png" id="dolarImg"> 
<%
	}else if(request.getParameter("aEuro") != null && request.getParameter("aEuro").equals("aEuro")&& request.getParameter("euro")!=null ){
		cambio = Double.parseDouble(request.getParameter("dolar"))*0.85;
		%>
<p>El cambio de <%= request.getParameter("dolar") %> <img src="img/dolar.png" id="dolarImg">. Son <%= cambio %><img src="img/euro.png" id="euroImg"> 
	<%}
}%>
</p>
</body>
</html>