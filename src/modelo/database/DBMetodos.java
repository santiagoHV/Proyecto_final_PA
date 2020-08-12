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
        PreparedStatement pstm = cn.getConexion().prepareStatement("/*INGRESE CODIGO SQL PARA PEDIR CODIGO GENERADO ID ESTUDIANTE*/");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public ResultSet getIdProfGenerado() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("/*INGRESE CODIGO SQL PARA PEDIR CODIGO GENERADO ID PROFESOR*/");
        ResultSet res = pstm.executeQuery();
        return res;
    }
    public void insertarSiguienteIDEst(String c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("/*INGRESE CODIGO PARA EDITAR CODIGO GENERADO ID ESTUDIANTE*/");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    public void insertarSiguienteIDProf(String c) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("/*INGRESE CODIGO PARA EDITAR CODIGO GENERADO ID PROFESOR*/");
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    //-------------------------------------------------------------------------------------------------------------------------------
}
