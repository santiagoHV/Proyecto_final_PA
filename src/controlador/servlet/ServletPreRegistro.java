package controlador.servlet;

import modelo.database.DBMetodos;
import modelo.database.DBProfesor;

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
        DBProfesor profesoresDBconexion = new DBProfesor();
        String profesores[][] = new String[7][3];
        ResultSet profesoresDB;
        int i = 0;
        try {
            profesoresDB = profesoresDBconexion.getProfesores();
            while (profesoresDB.next()){
                System.out.println(i);
                profesores[i][0] = profesoresDB.getString("nombre_p")+" "+profesoresDB.getString("apellido_p");
                profesores[i][1] = profesoresDB.getString("materia");
                profesores[i][2] = habilitarMateriaProfesor(profesoresDB.getString("nombre_p"));
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("se salio por "+throwables);
        }
        for(int j = 0;j < 6;j++)System.out.println(profesores[j][0]+"  "+profesores[j][1]);

        request.getSession().setAttribute("lista de profesores",profesores);

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
     *Trae y asigna el ID de estudaintes que esta en la base de datos
     *y devuelve el proximo
     * @param conexionDB
     * @return
     */
    String generarIdEstudiante(DBMetodos conexionDB){
        ResultSet resIDEstudiante= null;
        String idEstudianteNuevo = "";

        try {
            resIDEstudiante = conexionDB.getIdEstGenerado();
            System.out.println(resIDEstudiante.getString("id_g"));
            idEstudianteNuevo =  resIDEstudiante.getString("id_g");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("se rompio"+throwables);
        }
        idEstudianteNuevo=Integer.toString(Integer.parseInt(idEstudianteNuevo)+1);
        conexionDB.insertarSiguienteIDEst(idEstudianteNuevo);
        return idEstudianteNuevo;
    }

    /**
     * Trae y asigna el ID de profesor que esta en la base de datos
     * y devuelve el proximo
     * @param conexionDB
     * @return
     */
    String generarIdProfesor(DBMetodos conexionDB) {
        ResultSet resIDProfesor = null;
        String idProfesorNuevo = "";
        try {
            resIDProfesor = conexionDB.getIdProfGenerado();
            idProfesorNuevo = resIDProfesor.getString("id_g");
            System.out.println("id profe: "+idProfesorNuevo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        idProfesorNuevo = Integer.toString(Integer.parseInt(idProfesorNuevo) + 1);
        conexionDB.insertarSiguienteIDProf(idProfesorNuevo);
    return idProfesorNuevo;
    }

    /**
     * Habilita la materia de un profesor
     * @param in
     * @return
     */
    String habilitarMateriaProfesor(String in){
        if(in.equals("Por Asignar"))return "";
        else return "disabled class='disabled'";
    }


}
