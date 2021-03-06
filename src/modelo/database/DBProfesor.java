package modelo.database;

import modelo.logica.Profesor;
import modelo.logica.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBProfesor{

    static DBConexion cn = new DBConexion();

    /**
     * Trae los datos de un profesor segun su ID
     * @param id
     * @return
     * @throws SQLException
     */
    public ResultSet getProfesorById(String id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id_p, "
                + " contrasena_p,"
                + " nombre_p,"
                + " apellido_p,"
                + " correo_p,"
                + " contacto_p,"
                + " materia"
                + " FROM profesor "
                + " WHERE id_p = ? ");
        pstm.setString(1, id);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();
         */

        return res;
    }

    /**
     * trae todos los registros de la tabla contactos
     */
    public ResultSet getProfesores() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id_p, "
                + " nombre_p,"
                + " apellido_p,"
                + " correo_p,"
                + " materia"
                + " FROM profesor ");
        ResultSet res = pstm.executeQuery();
        return res;
    }

    /**
     * Registra un nuevo profesor en la base de datos
     * @param a
     */
    public static void insertarProfesor(Usuario a) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into profesor (id_p,"
                    + " contrasena_p,"
                    + " nombre_p,"
                    + " apellido_p,"
                    + " correo_p,"
                    + " contacto_p,"  
                    + " materia)"
                    + " values(?,?,?,?,?,?,?)");
            pstm.setString(1, a.getId());
            pstm.setString(2, a.getPassword());
            pstm.setString(3, a.getNombre());
            pstm.setString(4, a.getApellido());
            pstm.setString(5, a.getCorreo());
            pstm.setString(6, a.getContacto());
            pstm.setString(7, a.getMateria());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     * Actualiza los datos de un profesor
     * @param a
     */
    public static void actualizarProfesor(Usuario a) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update profesor set contrasena_p=?,"
                    + " nombre_p=?,"
                    + " apellido_p=?,"
                    + " correo_p=?,"
                    + " contacto_p=?,"
                    + " id_p=?"
                    + " where materia = ?");
            pstm.setString(1, a.getPassword());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido());
            pstm.setString(4, a.getCorreo());
            pstm.setString(5, a.getContacto());
            pstm.setString(6, a.getId());
            pstm.setString(7, a.getMateria());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}

