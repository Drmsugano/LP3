
package br.edu.ifpr.util;
// Classe de Conexão com o Banco

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/ifpr";
    
    public static Connection createConnectionToMysql(){
        try {
            Connection conn = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static void main(String[] args) {
        Connection con = createConnectionToMysql();
        if (con != null){
            System.out.println("Conectado com sucesso");
        } else{
            System.out.println("Não foi possivel conectar");
        }
    }
}