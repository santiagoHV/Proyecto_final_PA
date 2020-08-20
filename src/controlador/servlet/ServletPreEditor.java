package controlador.servlet;

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

public class ServletPreEditor extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ArrayList<Notas> notas= new ArrayList<Notas>();
        DBMaterias conexionDB =new DBMaterias();
        ResultSet res = null;

        try {
            res = conexionDB.getNotasByProfesore(obtenerMateria((String) req.getSession().getAttribute("codigo")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
            while (true){
                try {
                    if (!res.next()) break;
                    notas.add(new Notas("materia",res.getString("codigo_e"),res.getInt("corte1"),
                            res.getInt("corte2"),res.getInt("corte3")));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        try {
            req.getSession().setAttribute("materia",obtenerMateria((String) req.getSession().getAttribute("codigo")));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        req.getSession().setAttribute("notas",notas);
        resp.sendRedirect("editorNotas.jsp");
    }

    String obtenerMateria(String id) throws SQLException {
        DBProfesor conexionDB = new DBProfesor();
        ResultSet res = conexionDB.getProfesorById(id);
        res.next();
        return res.getString("materia");
    }

}
