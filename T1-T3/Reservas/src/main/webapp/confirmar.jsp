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

<h1>RESERVA CONFIRMADA</h1>
<jsp:useBean id="reserva" scope="session" class="servidor.model.Reserva"></jsp:useBean>
<br/>
<br/>
<p>FECHA INICIO: <%= reserva.getfInicio()%><br/></p>
<p>FECHA FINALIZACION: <%=reserva.getfFin() %><br/></p>
<p>NÚMERO DE PERSONAS: <%=reserva.getNPersonas() %><br/></p>
<p>SERVICIOS RESERVADOS:<br/>
<ul>
<%for(int i=0; i < reserva.getServicios().size(); i++){%>
<li><%=reserva.getServicios().get(i) %></li>
<%} %>
</ul>
<%} %>
</body>
</html>