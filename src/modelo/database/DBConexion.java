package modelo.database;

import java.sql.*;

public class DBConexion {

    //INGRESAR DATOS DEPENDIENDO DE SU BASE DE DATOS
    static String bd = "";
    static String login = "";
    static String password = "";


    static String mensaje = "Arregle esa mierda";
    static String url = "jdbc:mysql://localhost/"+bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    Connection conexion = null;

    public DBConexion() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url,login,password);

            if (conexion!=null){
                System.out.println("Conexión a base de datos "+bd+" OK");
            }
        }catch(SQLException e){
            mensaje = e.getMessage();
        }catch(ClassNotFoundException e){
            mensaje = e.getMessage();
        }
    }

    public static String getMensaje() {
        return mensaje;
    }

    public static void setMensaje(String mensaje) {
        DBConexion.mensaje = mensaje;
    }

    public Connection getConexion(){
        return conexion;
    }

    public void desconectar(){
        conexion = null;
    }

}
