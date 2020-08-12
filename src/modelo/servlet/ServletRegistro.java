package modelo.servlet;
import modelo.database.DBMetodos;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServletRegistro extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        DBMetodos conDB=new DBMetodos();

        /*---------------GENERADOR ID----(Utilice atributo idx)----------------------------------------------*/
            /*SANTIAGO POR FAVOR ENCARGUESE DEL BOOLEANO, SI ES
            ESTUDIANTE TRUE, SI ES PROFESOR FALSE*/
        boolean estudiante;
        String idx;
        int idmod;
        ResultSet resIDEst=conDB.getIdEstGenerado();
        ResultSet resIDProf=conDB.getIdEstGenerado();
        if(estudiante=true){
            idx=resIDEst.getString("INGRESAR ATRIBUTO ID ESTUDIANTE");
            idmod=Integer.parseInt(idx);
            idmod++;
            idx=Integer.toString(idmod);
            conDB.insertarSiguienteIDEst(idx);
        }else{
            idx=resIDProf.getString("INGRESAR ATRIBUTO ID PROFESOR");
            idmod=Integer.parseInt(idx);
            idmod++;
            idx=Integer.toString(idmod);
            conDB.insertarSiguienteIDProf(idx);
        }
        /*---------------------------------------------------------------------------*/

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
