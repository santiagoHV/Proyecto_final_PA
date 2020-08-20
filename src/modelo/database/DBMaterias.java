package modelo.database;

import modelo.logica.Profesor;
import modelo.logica.Usuario;
import modelo.logica.Notas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMaterias {
    static DBConexion cn = new DBConexion();

    /**
     * Trae las notas de un estudiante segun su ID
     *
     * @param codigo_e
     * @return
     * @throws SQLException
     */
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

    /**
     * Trae todas las notas de una materia
     *
     * @param materia_p
     * @return
     * @throws SQLException
     */
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

    /**
     * Ingresa notas a un estudiante
     * @param a
     */
    public void insertarNotas(Notas a) {
            try {
                PreparedStatement pstm = cn.getConexion().prepareStatement("insert into materia (materia_p,"
                        + " codigo_e,"
                        + " corte1,"
                        + " corte2,"
                        + " corte3,"
                        + " corteFinal)"
                        + " values(?,?,?,?,?,?)");
                pstm.setString(1, a.getMateria());
                pstm.setInt(2, Integer.parseInt(a.getEstudiante()));
                pstm.setInt(3, a.getPrimerCorte());
                pstm.setInt(4, a.getSegundoCorte());
                pstm.setInt(5, a.getTercerCorte());
                pstm.setDouble(6, a.getNotaFinal());

                pstm.executeUpdate();

            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    /**
     * Actualiza notas de un estudiante
     * @param a
     */
    public static void actualizarNotas(Notas a) {
            try {
                        PreparedStatement pstm = cn.getConexion().prepareStatement("update materia set corte1 = ?,"
                                + " corte2 = ?,"
                                + " corte3 = ?,"
                                + " corteFinal = ?"
                                + " where codigo_e = ? and"
                                + " materia_p = ?");
                pstm.setInt(1, a.getPrimerCorte());
                pstm.setInt(2, a.getSegundoCorte());
                pstm.setInt(3, a.getTercerCorte());
                pstm.setDouble(4, a.getNotaFinal());
                pstm.setString(5, a.getEstudiante());
                pstm.setString(6, a.getMateria());
                pstm.executeUpdate();


            } catch (SQLException e) {
                System.out.println(e);
            }

        }
}
