package controlador.servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
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
        String rol = (String) req.getSession().getAttribute("rol");
        System.out.println(rol+req.getSession().getAttribute("codigo"));
        ArrayList<Notas> notas= new ArrayList<Notas>();
        DBMaterias conexionDB =new DBMaterias();
        ResultSet res = null;

        if(rol.equals("estudiante")){
            try {
                res = conexionDB.getNotasByEstudiante(Integer.parseInt((String) req.getSession().getAttribute("codigo")));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            while (true){
                try {
                    if (!res.next()) break;
                    System.out.println(res.getString("materia_p")+res.getString("corte3"));
                    notas.add(new Notas(res.getString("materia_p"),"20201003",res.getInt("corte1"),
                            res.getInt("corte2"),res.getInt("corte3")));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }else if(rol.equals("profesor")){
            try {
                System.out.println(obtenerMateria((String) req.getSession().getAttribute("codigo")));
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
        }

        for(int i = 0;i < notas.size();i++) {
            System.out.println(notas.get(i).getMateria()+notas.get(i).getPrimerCorte());
        }

        req.getSession().setAttribute("notas",notas);
        resp.sendRedirect("lectorNotas.jsp");
    }

    /**
     * Trae la materia segun el profesor
     * @param id
     * @return
     * @throws SQLException
     */
    String obtenerMateria(String id) throws SQLException {
        DBProfesor conexionDB = new DBProfesor();
        ResultSet res = conexionDB.getProfesorById(id);
        res.next();
        return res.getString("materia");
    }

}
