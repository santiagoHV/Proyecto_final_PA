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
        
        String usuarioDeEntrada = request.getParameter("usuario");
        String contraseñaDeEntrada = request.getParameter("contraseña");

        String parametroInicialUsuario = usuarioDeEntrada.split("")[0];

        if(parametroInicialUsuario == "1"){
            //es un profesor
        }else if(parametroInicialUsuario == "2"){
            //es un estudiante
        }else{
            response.sendRedirect("index.jsp");
        }
        
        
        
        DBAlumno idaDB = new DBAlumno();
        DBProfesor idpDB = new DBProfesor();
        //estudiantes 20201020---
        //profesores 1020---
        //----------VALIDACION----------------------------------------------------------
        try {
            ResultSet res = idaDB.getAlumnoById("*ID INGRESADO*");
            if (res.getString("contraseña_a") != "*CONTRASEÑA INGRESADA*") {
                response.sendRedirect("index.jsp");//no pasa
            }// redireccion a home
        } catch (SQLException throwables) {
            try {
                ResultSet res = idpDB.getProfesorById("ID INGRESADO");
                if (res.getString("contraseña_p") != "*CONTRASEÑA INGRESADA*") {
                    response.sendRedirect("index.jsp");
                }// redireccion a home
            }catch (SQLException throwables1) {
                response.sendRedirect("index.jsp");
            }
        }
        //----------------------------------------------------------------------------------
    }
}
