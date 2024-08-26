/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.dao;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class CategoriaDAO implements Dao<Integer, Categoria>{
    
    protected Connection con;

    public CategoriaDAO(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Categoria entity) {
        String sql = "INSERT INTO categoria (descricao) VALUES (?);";
        
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getDescricao());
            query.executeUpdate();
            
            ResultSet rs = query.getGeneratedKeys();
            
            if (rs.next()) {
                // Pega o id gerado pelo banco de dados para a
                // nova categoria gravada.
                int id = rs.getInt(1);
                entity.setId(id);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Categoria retrieve(Integer pk) {
       
        Categoria categoria = null;
        
        if (pk != null) {
            
            String sql = "SELECT id, descricao FROM categoria WHERE id = ?";
            try {
                PreparedStatement query = con.prepareStatement(sql);
                query.setInt(1, pk);
                ResultSet rs = query.executeQuery();

                if (rs.next()) {
                    categoria = new Categoria();
                    categoria.setId(rs.getInt("id"));
                    categoria.setDescricao(rs.getString("descricao"));
                }
                query.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        return categoria;
    }

    @Override
    public void update(Categoria entity) {
        
        String sql = "UPDATE Categoria SET descricao = ? WHERE id = ?";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getDescricao());
            query.setInt(2, entity.getId());
            
            int rowsUpdated = query.executeUpdate();
            
            query.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        
        String sql = "DELETE FROM categoria WHERE id = ?";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            
            int rowsUpdated = query.executeUpdate();
            
            query.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Categoria> findALL() {
        
        List<Categoria> categorias = new LinkedList<Categoria>();
        
        String sql = "SELECT id, descricao FROM categoria";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            
            while(rs.next()) {
                
                Categoria categoria = new Categoria();
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
                
                categorias.add(categoria);
            }
            
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return categorias;

    }
    
    
    public static void main(String[] args) {
        /**
         * Teste CREATE
         
        Categoria c = new Categoria();
        c.setDescricao("Caminhão");
        
        CategoriaDAO dao = new CategoriaDAO(ConnectionFactory.createConnectionToMySQL());
        
        System.out.println("Antes de gravar no banco ID da categoria " + c.getId());
        
        dao.create(c);
        */

        // Teste do RETRIEVE
        /**
        CategoriaDAO dao = new CategoriaDAO(ConnectionFactory.createConnectionToMySQL());
        Categoria categoria = dao.retrieve(2);
        
        System.out.println(categoria);
        */
        
        // Testar UPDATE
        /**
        CategoriaDAO dao = new CategoriaDAO(ConnectionFactory.createConnectionToMySQL());
        Categoria categoria = dao.retrieve(2);
            
        categoria.setDescricao("Motocicleta");
        dao.update(categoria);
        **/
        
        // Testar DELETE

        CategoriaDAO dao = new CategoriaDAO(ConnectionFactory.createConnectionToMySQL());
        
        dao.delete(2);
        
        // Testar findAll
           /*
        CategoriaDAO dao = new CategoriaDAO(ConnectionFactory.createConnectionToMySQL());
        
        List<Categoria> categorias = dao.findALL();
        
        System.out.println(categorias);
        System.out.println(categorias.size());
*/

    }
}
