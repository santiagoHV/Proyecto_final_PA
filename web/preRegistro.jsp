<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 11/08/2020
  Time: 3:30 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="assets/styles.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>

<body class="body-preregistro">
<div class="container mt-5">
    <form action="/Pre-registro" method="get">
        <input type="hidden" name="tipoDeUsuario" id="verificacionPreRegistro">
        <div class="row">
            <div class="offset-2 col-5">
                <div class="cardi" style="width: 18rem;">
                    <img src="assets/img/student.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h3 class="card-title">Soy estudiante</h3>
                        <input type="submit" class="btn-registro  btn-lg btn-block" value="Registrarme" onclick="distribuirUsuario('estudiante')">
                    </div>
                </div>
            </div>
            <div class="col-5">
                <div class="cardi" style="width: 18rem;">
                    <img src="assets/img/professor-avatar.png" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h3 class="card-title">Soy docente</h3>
                            <input type="submit" class="btn-registro  btn-lg btn-block" value="Registrarme" onclick="distribuirUsuario('profesor')">
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>



<script src="assets/functions-front.js" type="text/javascript"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>

</html>