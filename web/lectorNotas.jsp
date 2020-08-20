<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 19/08/2020
  Time: 10:21 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="assets/stylesLogin.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>

<body class="body-notas">
<nav class="navbar navbar-expand-lg navbar-dark navbarUD">
    <a class="navbar-brand" href="#"><img src="escudo.png" class="escudo-navbar"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item ">
                <a class="nav-link" href="#">Inicio </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Perfil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Horario</a>
            </li>
            <li class="nav-item dropdown active">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Calificaciones
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="#">Notas parciales</a>
                    <a class="dropdown-item" href="#">Notas finales</a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class=" container container-home p-5 mt-3">
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Materia</th>
            <th scope="col">Primer Corte (35%)</th>
            <th scope="col">Segundo Corte (35%)</th>
            <th scope="col">Tercer Corte (30%)</th>
            <th scope="col">Acumulado</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="row">Teoría de sistemas</th>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr>
            <th scope="row">Calculo Multivariado</th>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr>
            <th scope="row">Ecuaciones Diferenciales</th>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr>
            <th scope="row">Física (Electromagnetismo)</th>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr>
            <th scope="row">Programación Avanzada</th>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        <tr>
            <th scope="row">Ingles II</th>
            <td>0</td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
        </tr>
        </tbody>
    </table>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>

</html>
