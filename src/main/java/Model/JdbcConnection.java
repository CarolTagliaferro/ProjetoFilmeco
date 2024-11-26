package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;

public class JdbcConnection {
    //Declaração de variavéis de banco
    private Connection con = null;
    private String hostName = null;
    private String userName = null;
    private String password = null;
    private String url = null;
    private String jdbcDriver = null;
    private String dataBaseName = null;
    private String dataBasePrefix = null;
    private String dabaBasePort = null;

    public JdbcConnection() {
        super();

        /**
         *Área de alteração de parametro de banco
         */

        //"jdbc:mysql://localhost:3306/Filmeco";
        hostName = "localhost";
        userName = "root";
        password = "";
        jdbcDriver = "org.gjt.mm.mysql.Driver";
        dataBaseName = "Filmeco";
        dataBasePrefix = "jdbc:mysql:/";
        dabaBasePort = "3306";

        //url = dataBasePrefix + hostName + ":"+dabaBasePort+"/" + dataBaseName;
        url = "jdbc:mysql://localhost:3306/Filmeco";

    }


    /**
     *Retorna uma java.sql.Connection.
     *@return con
     */


    public Connection getConnection() {
        try {
            if (con == null) {
                //Class.forName(jdbcDriver);
                con = DriverManager.getConnection(url, userName, password);
                System.out.println("Conexão com o MySQL estabelecida com sucesso!");
            } else if (con.isClosed()) {
                con = null;
                return getConnection();
            }
        }  catch (SQLException e) {

            //TODO: use um sistema de log apropriado.

            e.printStackTrace();
        }
        return con;
    }

    public ResultSet executeLinha(String query, JdbcConnection conn) {
        try (Connection con = conn.getConnection()){
            PreparedStatement stmt = con.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }



    public void closeConnection() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                //TODO: use um sistema de log apropriado.
                e.printStackTrace();
            }
        }
    }
}
