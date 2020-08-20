package controlador.servlet;

import modelo.database.DBAlumno;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletPerfil extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession().getAttribute("rol").equals("estudiante")){
            DBAlumno conexion = new DBAlumno();
            try {
                ResultSet estudianteDB = conexion.getAlumnoById((String) req.getSession().getAttribute("codigo"));
                estudianteDB.next();
                req.getSession().setAttribute("nombre y apellido",estudianteDB.getString("nombre_a")+" "+estudianteDB.getString("apellido_a"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }
}
