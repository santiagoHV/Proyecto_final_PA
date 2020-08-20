package controlador.servlet;

import modelo.database.DBAlumno;
import modelo.database.DBMetodos;
import modelo.database.DBProfesor;
import org.jetbrains.annotations.NotNull;

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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //estudiantes 202010--
        //profesores 1020---

        String usuarioDeEntrada = request.getParameter("usuario");
        String contraseñaDeEntrada = request.getParameter("password");

        String parametroInicialUsuario = usuarioDeEntrada.split("")[0];

        if(parametroInicialUsuario.equals( "1")){
            try {
                if(verificarUsuario(usuarioDeEntrada,contraseñaDeEntrada,false)){
                    request.getSession().setAttribute("escrito",escritoBievenida("1"));
                    request.getSession().setAttribute("materia",obtenerMateria(usuarioDeEntrada));
                    request.getSession().setAttribute("rol","profesor");
                    request.getSession().setAttribute("codigo",usuarioDeEntrada);
                    request.getSession().setAttribute("menu",serviciosHome("1",usuarioDeEntrada));
                    response.sendRedirect("home.jsp");
                }else{
                    request.getSession().setAttribute("menu",serviciosHome("2",usuarioDeEntrada));
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }else if(parametroInicialUsuario.equals("2")){
            try {
                if(verificarUsuario(usuarioDeEntrada,contraseñaDeEntrada,true)){
                    request.getSession().setAttribute("escrito",escritoBievenida("2"));
                    request.getSession().setAttribute("rol","estudiante");
                    request.getSession().setAttribute("codigo",usuarioDeEntrada);
                    request.getSession().setAttribute("menu",serviciosHome("2",usuarioDeEntrada));
                    response.sendRedirect("home.jsp");
                }else{
                    response.sendRedirect("index.jsp");
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }else{
            response.sendRedirect("index.jsp");
        }
    }

    /**
     * Valida los parametros ingresados y distingue su cargo
     * @param usuario
     * @param contraseña
     * @param rol
     * @return
     * @throws SQLException
     */
    boolean verificarUsuario(String usuario,String contraseña,boolean rol) throws SQLException {
        /*rol => true = estudiante; false = profesor
        */

        DBAlumno idEstudianteDB = new DBAlumno();
        DBProfesor idProfesorDB = new DBProfesor();
        ResultSet res;
        String DBdiferenciador;

        try {
            if(rol) {
                System.out.println("entra if estudiante");
                res = idEstudianteDB.getAlumnoById(usuario);
                DBdiferenciador = "a";
            }
            else{
                res = idProfesorDB.getProfesorById(usuario);
                DBdiferenciador = "p";
            }
            res.next();
            if (res.getString("contrasena_"+DBdiferenciador).equals(contraseña)) {
                return true;
            }else{
                return false;
            }
        } catch (SQLException throwables) {
            System.out.println(throwables);
            return false;
        }
    }

    /**
     * Carga el home
     * @param rol
     * @return
     */
    String[][] serviciosHome(String rol,String codigo) throws SQLException {
        String calificaciones[][] = new String[3][2];
            if(rol.equals("1")){
                calificaciones[0][0] = "Ver mi curso";
                calificaciones[0][1] = "/Lector-notas";
                calificaciones[1][0] = "Editar/Subir notas";
                calificaciones[1][1] = "Editor-notas";
                calificaciones[2][0] = "Pensum";
                calificaciones[2][1] = obtenerLinkPensum(obtenerMateria(codigo));
            }else if(rol.equals("2")){
                calificaciones[0][0] = "Notas parciales";
                calificaciones[0][1] = "/Lector-notas";
                calificaciones[1][0] = "Notas finales";
                calificaciones[1][1] = "/Editor-notas";
                calificaciones[2][0] = "Horario";
                calificaciones[2][1] = "horario.jsp";
            }else{
                System.out.println("error en distribucion de menus al home");
            }
        return calificaciones;
    }

    /**
     * Arroja el mensaje de bienvenida
     * @param rol
     * @return
     */
    String escritoBievenida(String rol){
        if(rol.equals("1"))return "Este es el nuevo sistema de gestión académica para estudiantes de tercer semestre de ingeniería de sistemas de la universidad distrital Francisco Jose de Caldas, en este aplicativo tendrá acceso a su curso, lectura de notas y edición de las mismas; esto junto con el pensum de su materia.";
        else if(rol.equals("2")) return "Este es el nuevo sistema de gestión académica para estudiantes de tercer semestre de ingeniería de sistemas de la universidad distrital Francisco Jose de Caldas, en este aplicativo tendrá acceso a sus notas parciales, finales y acumuladas; esto junto con su horario el cual le fue asignado para el semestre en curso.";
        else return "";
    }
    String obtenerMateria(String id) throws SQLException {
        DBProfesor conexionDB = new DBProfesor();
        ResultSet res = conexionDB.getProfesorById(id);
        res.next();
        return res.getString("materia");
    }
    String obtenerLinkPensum(String materia){
        switch (materia){
            case "CM": return "http://ingenieria1.udistrital.edu.co/bannersis/pensum/creditos/pdf/3/Calculo_multivariado.pdf";
            case "FEM": return "http://ingenieria1.udistrital.edu.co/bannersis/pensum/creditos/pdf/3/Fisica_2_electromagnetismo.pdf";
            case "I2": return "http://ingenieria1.udistrital.edu.co/moodle/file.php?file=%2F220%2Fpensum%2Fimagenes%2F3%2Fsegundalenguan2.html";
            case "ED": return "http://ingenieria1.udistrital.edu.co/bannersis/pensum/creditos/pdf/3/Ecuaciones_diferenciales.pdf";
            case "PA": return "http://ingenieria1.udistrital.edu.co/bannersis/pensum/creditos/pdf/3/Programacion_avanzada.pdf";
            case "TGS": return "http://ingenieria1.udistrital.edu.co/bannersis/pensum/creditos/pdf/3/Teoria_de_sistemas.pdf";
            default: return "";
        }
    }

}
