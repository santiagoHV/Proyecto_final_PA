package controlador.servlet;

import modelo.database.DBAlumno;
import modelo.database.DBMetodos;
import modelo.database.DBProfesor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletIngreso extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //estudiantes 20201020---
        //profesores 1020---

        String usuarioDeEntrada = request.getParameter("usuario");
        String contraseñaDeEntrada = request.getParameter("contraseña");

        String parametroInicialUsuario = usuarioDeEntrada.split("")[0];

        if(parametroInicialUsuario == "1"){
            try {
                if(verificarUsuario(usuarioDeEntrada,contraseñaDeEntrada,false)){
                    //pasa
                }else{
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if(parametroInicialUsuario == "2"){
            try {
                if(verificarUsuario(usuarioDeEntrada,contraseñaDeEntrada,true)){
                    //pasa
                }else{
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    boolean verificarUsuario(String usuario,String contraseña,boolean rol) throws SQLException {
        /*rol => true = estudiante; false = profesor
        */

        DBAlumno idEstudianteDB = new DBAlumno();
        DBProfesor idProfesorDB = new DBProfesor();
        ResultSet res;
        String DBdiferenciador;

        try {
            if(rol) {
                res = idEstudianteDB.getAlumnoById(usuario);
                DBdiferenciador = "a";
            }
            else{
                res = idProfesorDB.getProfesorById(usuario);
                DBdiferenciador = "p";
            }

            if (res.getString("contraseña_"+DBdiferenciador) == contraseña) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException throwables) {
            return false;
        }
    }
}
