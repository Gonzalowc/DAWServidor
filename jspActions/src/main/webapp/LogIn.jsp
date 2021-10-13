<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("error") != null && request.getParameter("error").equals("malDato")){ %>
<h1 style="color:red;">Datos erroneos</h1>
<%} %>
<form action="forward.jsp" method="post">
<label>Usuario</label>
<input type="text" name="usuario"><br/>
<label>contraseña</label>
<input type="password" name="pass"><br/>
<input type="submit" value="Enviar">
</form>
</body>
</html>