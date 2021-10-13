<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("usuario").equals("admin") && request.getParameter("pass").equals("admin")){ %>
<jsp:forward page="admin.jsp"></jsp:forward>
<%}else if(request.getParameter("usuario").equals("usuario") && request.getParameter("pass").equals("usuario")) {%>
<jsp:forward page="usuario.jsp"></jsp:forward>
<%}else{ %>
<jsp:forward page="LogIn.jsp">
	<jsp:param value="malDato" name="error"/>
</jsp:forward>
<%} %>
</body>
</html>