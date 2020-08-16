<%--
  Created by IntelliJ IDEA.
  User: santi
  Date: 11/08/2020
  Time: 3:31 p. m.
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

<body class="body-registro">
<div class="container mt-5 container-registro">

    <div class="row">

        <div class="offset-md-1 col-md-10 mt-4">
            <form class=" form-registro" method="post" action="/Registro-completo">
                <input type="hidden" name="rol" value="profesor">
                <img src="assets/img/escudo.png" class="escudo-registro mb-5 mt-3">
                <h2>Ingrese sus datos de registro</h2>
                <hr>
                <div class="form-row">
                    <div class="form-group col-md-6 col-12">
                        <label for="inputNombre">Nombre completo</label>
                        <input type="text" class="form-control" id="inputNombre" placeholder="Nombre completo">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputApellido">Apellidos</label>
                        <input type="text" class="form-control" id="inputApellido" placeholder="Apellidos">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputCorreo">Correo electrónico</label>
                        <input type="email" class="form-control" id="inputCorreo" placeholder="Correo electrónico">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputContacto">Número de contacto</label>
                        <input type="number" class="form-control" id="inputContacto" placeholder="Número de contacto">
                    </div>
                </div>
                <hr>
                <div class="form-row">
                    <div class="form-group col-md-6 col-12">
                        <label for="inputNombre">Nueva contraseña</label>
                        <input type="password" class="form-control" id="inputContraseña" placeholder="Contraseña">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label for="inputApellido">Repita la contraseña</label>
                        <input type="password" class="form-control" id="inputContraseña2" placeholder="Contraseña">
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <H3>Id generado</H3>
                        <input type="email" class="form-control" value="<%=request.getSession().getAttribute("ID")%>" disabled>
                    </div>
                    <div class="form-group col-md-6 col-12">
                        <label class="mt-4">
                            Este será su codigo de docente vigente para la plataforma de notas parciales y finales de tercer semestre
                        </label>
                    </div>
                </div>
                <hr>
                <div class="form-row">
                    <div class="form-group col-12">
                        <label>Bienvenido al sistema de gestión academica de ingeniería de sistemas del tercer semestre de la universidad distrital, aquí encontrará la información de sus estudiantes, junto con las notas parciales y finales, sobre las cuales tendrá poder de edición sobre 3 cortes</label>
                        <label>Al aceptar e inscribirse debe escoger cuál sera su materia y el sistema NO le permitirá cambiar de materia:</label>
                    </div>
                    <div class="col-12 offset-md-3 col-md-6">

                        <table class="table table-registro">
                            <thead class="thead-lighti">
                            <tr>
                                <th scope="col"></th>
                                <th scope="col">Materia</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <th scope="row"><input type="radio" name="materia" value="TGS" class="form-control"></th>
                                <td>Teoría de sistemas</td>
                            </tr>
                            <tr>
                                <th scope="row"><input type="radio" name="materia" value="CM" class="form-control"></th>
                                <td>Calculo Multivariado</td>
                            </tr>
                            <tr>
                                <th scope="row"><input type="radio" name="materia" value="ED" class="form-control"></th>
                                <td>Ecuaciones diferenciales</td>
                            </tr>
                            <tr>
                                <th scope="row"><input type="radio" name="materia" value="FEM" class="form-control"></th>
                                <td>Fisica (Electromagnetismo)</td>
                            </tr>
                            <tr>
                                <th scope="row"><input type="radio" name="materia" value="PA" class="form-control"></th>
                                <td>Programación avanzada</td>
                            </tr>
                            <tr>
                                <th scope="row"><input type="radio" name="materia" value="I2" class="form-control"></th>
                                <td>Ingles II</td>
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
