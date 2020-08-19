<%--
  Created by IntelliJ IDEA.
  Date: 30/07/2020
  Time: 10:20 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="assets/styles.css" rel="stylesheet" type="text/css">

</head>

<body class="body-login">
<div class="container-login">
    <div class="login">
        <img src="assets/img/escudo.png" class="escudo-login">
        <div class="form-login">
            <form action="/Ingreso" method="post">
                <h2>BIENVENIDO</h2>
                <hr><br> Usuario(ID)
                <input class="input-login" name="usuario" type="text"> Contraseña<br>
                <input class="input-login" name="password" type="password">
                <input type="hidden" name="rol" >
                <a href=""><button class="button-login">Ingresar</button></a>
            </form>
        </div>

    </div>
    <div class="new"><a href="preRegistro.jsp">¿No estas registrado?</a></div>
</div>
</body>

</html>
