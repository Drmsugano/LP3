/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe de conexão com o banco de dados
 * Usuário: root
 * Senha: ""
 * 
 * Utilizamos essa estrutura para evitar repetição de código
 * e simplificar a obtenção de conexão com o banco de dados
 * 
 * @author Everton Baro
 */
public class ConnectionFactory {
    
    // Nome do usuário do MySQL 
    private static final String USERNAME = "efbaro";
    
    // Senha do Mysql
    private static final String PASSWORD = "1234";
    
    // String de conexão com o banco de dados
    // Porta e nome do banco de dados no qual pretende-se se conectar
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/ifpr";
    
    public static Connection createConnectionToMySQL() {
        
        try {
            // Cria a conexão com banco de dados.
            Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return connection;
            
        } catch (SQLException e) {
            System.out.println("Não foi possível conectar-se ao Banco de Dados");
            System.out.println(DATABASE_URL);
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public static void main(String[] args) {
        
        Connection con = createConnectionToMySQL();
        
        if (con != null) {
            System.out.println("Conexão obtida com sucesso!" + con);
        } else {
            System.out.println("Não foi possível fazer a conexão.");
        }
        
    }
    
    
}
