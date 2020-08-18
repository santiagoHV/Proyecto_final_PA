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
        System.out.println(req.getParameter("contraseña"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //estudiantes 202010--
        //profesores 1020---

        String usuarioDeEntrada = request.getParameter("usuario");
        String contraseñaDeEntrada = request.getParameter("password");

        String parametroInicialUsuario = usuarioDeEntrada.split("")[0];

        if(parametroInicialUsuario.equals( "1")){
            try {
                if(verificarUsuario(usuarioDeEntrada,contraseñaDeEntrada,false)){
                    response.sendRedirect("home.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if(parametroInicialUsuario.equals("2")){
            try {
                if(verificarUsuario(usuarioDeEntrada,contraseñaDeEntrada,true)){

                    response.sendRedirect("home.jsp");
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
        System.out.println(rol);

        try {
            if(rol) {
                System.out.println("entra if estudiante");
                res = idEstudianteDB.getAlumnoById(usuario);
                DBdiferenciador = "a";
            }
            else{
                res = idProfesorDB.getProfesorById(usuario);
                DBdiferenciador = "p";
            }
            res.next();
            System.out.println(res.getString("contrasena_"+DBdiferenciador));
            if (res.getString("contrasena_"+DBdiferenciador).equals(contraseña)) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException throwables) {
            System.out.println(throwables);
            return false;
        }
    }
}
