package controlador.servlet;

import modelo.database.DBMaterias;
import modelo.logica.Notas;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ServletEditorNotas extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Notas> notasAntiguas = (ArrayList<Notas>) req.getSession().getAttribute("notas");
        for(int i = 0;i < notasAntiguas.size();i++){
            DBMaterias.actualizarNotas(new Notas((String) req.getSession().getAttribute("materia"),req.getParameter("estudiante"+i),Integer.parseInt(req.getParameter("primeraNota"+i)),
                    Integer.parseInt(req.getParameter("segundaNota"+i)),Integer.parseInt(req.getParameter("terceraNota"+i))));
        }
    }
}
