package controlador.servlet;
import modelo.database.DBAlumno;
import modelo.database.DBMetodos;
import modelo.database.DBProfesor;
import modelo.logica.Estudiante;
import modelo.logica.Profesor;
import modelo.logica.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletRegistro extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DBProfesor dataBaseProfesor = new DBProfesor();
        DBAlumno dataBaseAlumno = new DBAlumno();
        System.out.println(request.getParameter("id"));
        System.out.println(request.getParameter("password"));
        Usuario nuevoUsuario = crearUsuario(request.getParameter("rol"),request.getParameter("nombre"),request.getParameter("apellidos"),request.getParameter("correo"),
                request.getParameter("contacto"),request.getParameter("password"),request.getParameter("id"),request.getParameter("materia"));
        request.getSession().setAttribute("rol",request.getParameter("rol"));
        request.getSession().setAttribute("id",request.getParameter("id"));
        if(request.getParameter("rol").equals("estudiante")){
            dataBaseAlumno.insertarAlumno(nuevoUsuario);
        }
        else{
            dataBaseProfesor.actualizarProfesor(nuevoUsuario);
        }

        response.sendRedirect("index.jsp");
    }

    /**
     * METODO LISKOV
     * @param rol
     * @param nombre
     * @param apellido
     * @param correo
     * @param contacto
     * @param password
     * @param id
     * @param materia
     * @return
     */
    Usuario crearUsuario(String rol,String nombre, String apellido,String correo,String contacto,String password,String id, String materia){
        /*rol => true = estudiante; false = profesor
         */
        if(rol.equals("estudiante")){
            return new Estudiante(nombre,apellido,correo,contacto,password,id);
        }else{
            return new Profesor(nombre,apellido,correo,contacto,password,id,materia);
        }
    }
}
