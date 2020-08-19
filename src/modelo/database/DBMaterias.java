package modelo.database;

import modelo.logica.Profesor;
import modelo.logica.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMaterias {
    static DBConexion cn = new DBConexion();

        public ResultSet getNotasByEstudiante(int codigo_e) throws SQLException {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT materia_p, "
                    + " corte1,"
                    + " corte2,"
                    + " corte3,"
                    + " corteFinal"
                    + " FROM materia "
                    + " WHERE codigo_e = ? ");
            pstm.setInt(1, codigo_e);

            ResultSet res = pstm.executeQuery();
            return res;
        }

        public ResultSet getNotasByProfesore(String materia_p) throws SQLException {
            PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT codigo_e, "
                    + " corte1,"
                    + " corte2,"
                    + " corte3,"
                    + " corteFinal"
                    + " FROM materia "
                    + " WHERE materia_p = ? ");
            pstm.setString(1, materia_p);

            ResultSet res = pstm.executeQuery();
            return res;
        }

        public static void insertarNotas(Usuario a) {
            try {
                PreparedStatement pstm = cn.getConexion().prepareStatement("insert into materia (materia_p,"
                        + " codigo_e,"
                        + " corte1,"
                        + " corte2,"
                        + " corte3,"
                        + " corteFinal)"
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

        public void actualizarNotas(Profesor a) {
            try {
                        PreparedStatement pstm = cn.getConexion().prepareStatement("update materia set corte1=?,"
                                + " corte2,"
                                + " corte3,"
                                + " corteFinal"
                                + " where codigo_e = ?,"
                                + " materia_p = ?");
                pstm.setString(1, a.getPassword());
                pstm.setString(2, a.getNombre());
                pstm.setString(3, a.getApellido());
                pstm.setString(4, a.getCorreo());
                pstm.setString(5, a.getContacto());
                pstm.setString(6, a.getContacto());
                pstm.executeUpdate();


            } catch (SQLException e) {
                System.out.println(e);
            }

        }
}
