package controlador.servlet;

import modelo.database.DBAlumno;
import modelo.database.DBMaterias;
import modelo.database.DBProfesor;
import modelo.logica.Notas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServletLectorNotas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rol = req.getParameter("rol");
        ArrayList<Notas> notas= new ArrayList<Notas>();
        DBMaterias conexionDB =new DBMaterias();
        ResultSet res = null;

        if(rol.equals("estudiante")){
            try {
                res = conexionDB.getNotasByEstudiante(Integer.parseInt(req.getParameter("codigo")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else if(rol.equals("profesor")){
            try {
                res = conexionDB.getNotasByProfesore(req.getParameter("materia"));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }





    }
    ArrayList<Notas> distribuirNotas(ResultSet res){
        ArrayList<Notas> notas= new ArrayList<Notas>();
        return notas;
    }
}
