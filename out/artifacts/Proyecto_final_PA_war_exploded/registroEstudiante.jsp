<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 11/08/2020
  Time: 3:32 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String profesores[][] = (String[][]) request.getSession().getAttribute("lista de profesores");%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <link href="assets/styles.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>

<body class="body-registro">
<div class="container mt-5 container-registro">

    <div class="row">

        <div class="offset-md-1 col-md-10 mt-4">
            <form class=" form-registro " method="post" action="/Registro-completo">
                <input type="hidden" name="rol" value="estudiante">
                <input type="hidden" name="materia" value="NULO">
                <img src="assets/img/escudo.png" class="escudo-registro mb-5 mt-3">
                <h2>Ingrese sus datos de registro</h2>
                <hr>
                <div class="form-row">
                    <div class="form-group col-md-6 col-12">
                        <label for="inputNombre">Nombre completo</label>
                        <input required type="text" class="form-control" id="inputNombre" placeholder="Nombre completo" name="nombre">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputApellido">Apellidos</label>
                        <input required type="text" class="form-control" id="inputApellido" placeholder="Apellidos" name="apellidos">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputCorreo">Correo electrónico</label>
                        <input required type="email" class="form-control" id="inputCorreo" placeholder="Correo electrónico" name="correo">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputContacto">Número de contacto</label>
                        <input required type="number" class="form-control" id="inputContacto" placeholder="Número de contacto" name="contacto">
                    </div>
                </div>
                <hr>
                <div class="form-row">
                    <div class="form-group col-md-6 col-12">
                        <label for="inputNombre">Nueva contraseña</label>
                        <input required type="password" class="form-control" id="inputContraseña" placeholder="Contraseña">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputApellido">Repita la contraseña</label>
                        <input required type="password" class="form-control" id="inputContraseña2" placeholder="Contraseña" name="password">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <H3>Id generado</H3>
                        <input class="form-control" value="<%=request.getSession().getAttribute("ID")%>" disabled>
                        <input type="hidden" name="id" value="<%=request.getSession().getAttribute("ID")%>" name="id">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label class="mt-4">
                            Este será su codigo de estudiante vigente para la plataforma de notas parciales y finales de tercer semestre
                        </label>
                    </div>
                </div>
                <hr>
                <div class="form-row">
                    <div class="form-group col-12">
                        <label>Bienvenido al sistema de gestión academica de ingeniería de sistemas del tercer semestre de la universidad distrital, aquí encontrará la información de sus notas parciales y finales, junto con sus horarios e informacion relevante de la universidad</label>
                        <label>Al aceptar e inscribirse se le asignarán las siguientes materias con su respectivo profesor:</label>
                    </div>
                    <div class="col-12">

                        <table class="table table-registro">
                            <thead class="thead-lighti">
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Materia</th>
                                <th scope="col">Docente</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row">2</th>
                                <td>Calculo Multivariado</td>
                                <td><%=profesores[0][0]%></td>
                            </tr>
                            <tr>
                                <th scope="row">3</th>
                                <td>Ecuaciones diferenciales</td>
                                <td><%=profesores[1][0]%></td>
                            </tr>
                            <tr>
                                <th scope="row">5</th>
                                <td>Programación avanzada</td>
                                <td><%=profesores[2][0]%></td>
                            </tr>
                            <tr>
                                <th scope="row">4</th>
                                <td>Fisica (Electromagnetismo)</td>
                                <td><%=profesores[3][0]%></td>
                            </tr>
                            <tr>
                                <th scope="row">6</th>
                                <td>Ingles II</td>
                                <td><%=profesores[4][0]%></td>
                            </tr>
                            <tr>
                                <th scope="row">1</th>
                                <td>Teoría de sistemas</td>
                                <td><%=profesores[5][0]%></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <hr>
                <div class="form-row mt 5">
                    <div class="form-group col-12">
                        <input type="checkbox" id="aceptacion">
                        <label>Acepta las condiciones y materias a inscribir</label>
                    </div>
                    <button class=" btn-registro  btn-lg btn-block mb-5" type="submit">REGISTRARME</button>
                </div>
        </div>


        </form>
    </div>

</div>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
</body>

</html>