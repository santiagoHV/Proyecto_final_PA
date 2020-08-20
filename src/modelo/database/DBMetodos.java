package modelo.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMetodos {

    DBConexion cn;

    public DBMetodos() {
        cn = new DBConexion();
    }

    /**
     * Trae el ID de estudiante generado
     * @return
     * @throws SQLException
     */
    public ResultSet getIdEstGenerado() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT pk_cargo, "
                                                                     + "id_g"
                                                                     + " FROM generador_id"
                                                                     + " WHERE pk_cargo = 1 ");
        ResultSet res = pstm.executeQuery();
        res.next();
        return res;
    }

    /**
     * Trae el ID de profesor generado
     * @return
     * @throws SQLException
     */
    public ResultSet getIdProfGenerado() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT pk_cargo, "
                                                                     + "id_g"
                                                                     + " FROM generador_id"
                                                                     + " WHERE pk_cargo = 2 ");
        ResultSet res = pstm.executeQuery();
        res.next();
        System.out.println("res = "+res);
        return res;
    }

    /**
     * Ingresa el ID que se utilizara en el siguiente registro de estudiante
     * @param idx
     */
    public void insertarSiguienteIDEst(String idx) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update generador_id set id_g = ?"
                                                                         + " where pk_cargo = 1");
            pstm.setString(1,idx);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * Ingresa el ID que se utilizara en el siguiente registro de profesor
     * @param idx
     */
    public void insertarSiguienteIDProf(String idx) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update generador_id set id_g = ?"
                                                                         + " where pk_cargo = 2");
            pstm.setString(1,idx);
            pstm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
