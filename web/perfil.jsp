<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 20/08/2020
  Time: 8:52 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String[][] menu = (String[][]) request.getSession().getAttribute("menu");%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="assets/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>

<body class="body-notas">
<nav class="navbar navbar-expand-lg navbar-dark navbarUD">
    <a class="navbar-brand" href="#"><img src="assets/img/escudo.png" class="escudo-navbar"></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item ">
                <a class="nav-link" href="#">Inicio </a>
            </li>
            <li class="nav-item active">
                <a class="nav-link" href="#">Perfil</a>
            </li>
            <li class="nav-item ">
                <a class="nav-link" href="<%=menu[2][1]%>"><%=menu[2][0]%></a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Calificaciones
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="<%=menu[0][1]%>"><%=menu[0][0]%></a>
                    <a class="dropdown-item" href="<%=menu[1][1]%>"><%=menu[1][0]%></a>
                </div>
            </li>
        </ul>
    </div>
</nav>
<div class=" container container-home p-5 mt-3">
    <section class="section about-section gray-bg" id="about">
        <div class="container">
            <div class="row align-items-center flex-row-reverse">
                <div class="col-lg-6">
                    <div class="about-text go-to">
                        <h3 class="dark-color"><%=request.getSession().getAttribute("nombre y apellido")%></h3>

                        <div class="row about-list">
                            <div class="col-md-6">
                                <div class="media">
                                    <%if(request.getSession().getAttribute("rol").equals("estudiante")){%>
                                    <label>Ingenieria de sistemas</label>
                                    <%}else if(request.getSession().getAttribute("rol").equals("profesor")){%>
                                    <label>Docente de <%=request.getSession().getAttribute("materia")%></label>
                                    <%}%>
                                </div>
                                <div class="media">
                                    <label>Tercer semestre</label>
                                </div>
                                <div class="media">
                                    <p>Bogotá</p>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="media">
                                    <p><%=request.getSession().getAttribute("correo")%></p>
                                </div>
                                <div class="media">
                                    <p><%=request.getSession().getAttribute("contacto")%></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="about-avatar">
                        <%if(request.getSession().getAttribute("rol").equals("estudiante")){%>
                        <img src="assets/img/student.png" title="" alt="">
                        <%}else if(request.getSession().getAttribute("rol").equals("profesor")){%>
                        <img src="assets/img/professor-avatar.png" title="" alt="">
                        <%}%>

                    </div>
                </div>
            </div>
        </div>
    </section>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>

</html>
