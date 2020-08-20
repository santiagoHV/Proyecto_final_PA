package controlador.servlet;

import modelo.database.DBAlumno;
import modelo.database.DBProfesor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletPerfil extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("rol").equals("estudiante")){
            DBAlumno conexion = new DBAlumno();
            try {
                ResultSet estudianteDB = conexion.getAlumnoById((String) req.getSession().getAttribute("codigo"));
                estudianteDB.next();
                req.getSession().setAttribute("nombre y apellido",estudianteDB.getString("nombre_a")+" "+estudianteDB.getString("apellido_a"));
                req.getSession().setAttribute("correo",estudianteDB.getString("correo_a"));
                req.getSession().setAttribute("contacto",estudianteDB.getString("contacto_a"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if(req.getSession().getAttribute("rol").equals("profesor")){
            DBProfesor conexion = new DBProfesor();
            try {
                ResultSet profesorDB = conexion.getProfesorById((String) req.getSession().getAttribute("codigo"));
                profesorDB.next();
                req.getSession().setAttribute("nombre y apellido",profesorDB.getString("nombre_p")+" "+profesorDB.getString("apellido_p"));
                req.getSession().setAttribute("correo",profesorDB.getString("correo_p"));
                req.getSession().setAttribute("contacto",profesorDB.getString("contacto_p"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        resp.sendRedirect("perfil.jsp");
    }
}
