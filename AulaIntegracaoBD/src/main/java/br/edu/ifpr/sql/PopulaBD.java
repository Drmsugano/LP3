/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.sql;

import br.edu.ifpr.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
public class PopulaBD {
    
    public static void main(String[] args) {
        
        try {
            Connection con = ConnectionFactory.createConnectionToMySQL();
            
            String sql = "CREATE DATABASE ifpr;";
            
            PreparedStatement query = con.prepareStatement(sql);
            
            query.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(PopulaBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
