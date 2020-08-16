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
        super.doGet(req, resp);
        DBAlumno idaDB = new DBAlumno();
        DBProfesor idpDB = new DBProfesor();
        //estudiantes 20201020---
        //profesores 1020---
        //----------VALIDACION----------------------------------------------------------
        try {
            ResultSet res = idaDB.getAlumnoById("*ID INGRESADO*");
            if (res.getString("contraseña_a") != "*CONTRASEÑA INGRESADA*") {
                resp.sendRedirect("index.jsp");//no pasa
            }// redireccion a home
        } catch (SQLException throwables) {
            try {
                ResultSet res = idpDB.getProfesorById("ID INGRESADO");
                if (res.getString("contraseña_p") != "*CONTRASEÑA INGRESADA*") {
                    resp.sendRedirect("index.jsp");
                }// redireccion a home
            }catch (SQLException throwables1) {
                resp.sendRedirect("index.jsp");
            }
        }
        //----------------------------------------------------------------------------------
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
