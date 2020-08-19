package modelo.database;

import java.sql.*;
/**
 * Clase que permite conectar con mysql
 * @author
 */
public class DBConexion {
    static String bd = "proyecto";
    static String login = "root";
    static String password = "sultans2001*";
    static String url = "jdbc:mysql://localhost/"+bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    static String mensaje = "";

    private Connection conexion;
    /**
     * Constructor de la clase
     */
    public DBConexion() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            setConexion(DriverManager.getConnection(url,login,password));

            if (conexion!=null){
                System.out.println("Conexión a base de datos "+bd+" OK");
            }
        }catch(SQLException e){
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }catch(ClassNotFoundException e){
            mensaje = e.getMessage();
            System.out.println(mensaje);
        }
    }

    /**
     * Metodo para retornar mensajes de control
     * @return
     */
    public static String getMensaje() {
        return mensaje;
    }

    /**
     * Metodo para setear mensajes de control
     * @param mensaje
     */
    public static void setMensaje(String mensaje) {
        DBConexion.mensaje = mensaje;
    }

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }


}
