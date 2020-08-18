package modelo.database;

import modelo.logica.Estudiante;
import modelo.logica.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBAlumno {

    DBConexion cn = new DBConexion();

    public ResultSet getAlumnoById(String id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id_a, "
                + " contrasena_a,"
                + " nombre_a,"
                + " apellido_a,"
                + " correo_a,"
                + " contacto_a"
                + " FROM alumno "
                + " WHERE id_a = ? ");
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
    public ResultSet getAlumnos() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT id_a, "
                + " nombre_a,"
                + " correo_a"
                + " FROM alumno ");
        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarAlumno(Usuario a) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into alumno (id_a,"
                    + " contrasena_a,"
                    + " nombre_a,"
                    + " apellido_a,"
                    + " correo_a,"
                    + " contacto_a)"
                    + " values(?,?,?,?,?,?)");
            pstm.setString(1, a.getId());
            pstm.setString(2, a.getPassword());
            pstm.setString(3, a.getNombre());
            pstm.setString(4, a.getApellido());
            pstm.setString(5, a.getCorreo());
            pstm.setString(6, a.getContacto());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void actualizarAlumno(Usuario a) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update alumno set contraseña_a=?,"
                    + " nombre_a=?,"
                    + " apellido_a=?,"
                    + " correo_a=?,"
                    + " contacto_a=?"
                    + " where id_a = ?");
            pstm.setString(1, a.getPassword());
            pstm.setString(2, a.getNombre());
            pstm.setString(3, a.getApellido());
            pstm.setString(4, a.getCorreo());
            pstm.setString(5, a.getContacto());
            pstm.setString(6, a.getId());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }
}

