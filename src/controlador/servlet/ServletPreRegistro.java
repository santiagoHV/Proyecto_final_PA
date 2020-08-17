package controlador.servlet;

import modelo.database.DBMetodos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletPreRegistro extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBMetodos conDB = new DBMetodos();

        if(request.getParameter("tipoDeUsuario").equals("estudiante")){
            request.getSession().setAttribute("ID",generarIdEstudiante(conDB));
            response.sendRedirect("registroEstudiante.jsp");
        }else if(request.getParameter("tipoDeUsuario").equals("profesor")){
            request.getSession().setAttribute("ID",generarIdProfesor(conDB));
            response.sendRedirect("registroProfesor.jsp");
        }else{
            System.out.println("ERROR EN DISTRIBUCION DE REGISTRO");
        }
    }

    /**
     *
     * @param conexionDB
     * @return
     */
    String generarIdEstudiante(DBMetodos conexionDB){
        ResultSet resIDEstudiante;
        String idEstudianteNuevo = "";
        try {
            resIDEstudiante = conexionDB.getIdEstGenerado();
            idEstudianteNuevo=resIDEstudiante.getString("id_g");
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }
        idEstudianteNuevo=Long.toString(Long.parseLong(idEstudianteNuevo)+1);
        conexionDB.insertarSiguienteIDEst(idEstudianteNuevo);
        return idEstudianteNuevo;
    }

    /**
     *
     * @param conexionDB
     * @return
     */
    String generarIdProfesor(DBMetodos conexionDB) {
        ResultSet resIDProfesor;
        String idProfesorNuevo = "";
        try {
            resIDProfesor = conexionDB.getIdProfGenerado();
            idProfesorNuevo = resIDProfesor.getString("id_g");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        idProfesorNuevo = Integer.toString(Integer.parseInt(idProfesorNuevo) + 1);
        conexionDB.insertarSiguienteIDProf(idProfesorNuevo);
    return idProfesorNuevo;
    }


}
