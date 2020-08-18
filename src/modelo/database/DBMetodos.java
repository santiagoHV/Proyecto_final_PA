package modelo.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMetodos {

    DBConexion cn;

    public DBMetodos() {
        cn = new DBConexion();
    }
    //-------------------PARTE SALDARRIAGA NO TOCARXD-------------------------------------------------------------------------------
    public ResultSet getIdEstGenerado() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT pk_cargo, "
                                                                     + "id_g"
                                                                     + " FROM generador_id"
                                                                     + " WHERE pk_cargo = 1 ");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getIdProfGenerado() throws SQLException {
<<<<<<< HEAD
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT pk_cargo, "
                                                                     + "id_g"
                                                                     + " FROM generador_id"
                                                                     + " WHERE pk_cargo = 2 ");
        ResultSet res = pstm.executeQuery();
=======
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT pk_cargo, id_g "
                                                                     + "FROM generador_id "
                                                                     + "WHERE pk_cargo = ?");
        pstm.setString(1,"2");


        ResultSet res = pstm.executeQuery();
        res.next();
        System.out.println("res = "+res);
>>>>>>> parent of 69d649d... correcciones en registro
        return res;
    }
    public void insertarSiguienteIDEst(String idx) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update generador_id set id_g = ?"
                                                                         + " where pk_cargo = 1");
            pstm.setString(1,idx);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void insertarSiguienteIDProf(String idx) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update generador_id set id_g = ?"
                                                                         + " where pk_cargo = 2");
            pstm.setString(1,idx);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------
}
