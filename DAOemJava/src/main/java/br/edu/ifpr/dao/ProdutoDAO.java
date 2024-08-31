/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.dao;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.bean.Produto;
import br.edu.ifpr.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author efbaro
 */
public class ProdutoDAO implements Dao<Integer, Produto>{

    protected Connection con;

    public ProdutoDAO(Connection con) {
        this.con = con;
    }

    
    @Override
    public void create(Produto entity) {
        
        String sql = "INSERT INTO produto (descricao, categoria_id, valor) VALUES (?, ?, ?);";
        
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getDescricao());
            
            CategoriaDAO daoCategoria = new CategoriaDAO(con);
            
            // Se a categoria dentro do produto não estiver 
            // cadastrado no banco
            if (entity.getCategoria().getId() <= 0) {
                // Cadastra a categoria no banco
                daoCategoria.create(entity.getCategoria());
            } 

            query.setInt(2, entity.getCategoria().getId());
            query.setDouble(3, entity.getValor());
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
    public Produto retrieve(Integer pk) {
        
        Produto produto = null;
        
        String sql = "SELECT id, descricao, categoria_id, valor FROM produto WHERE id = ?";
        
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();
            
            CategoriaDAO daoCategoria = new CategoriaDAO(con);
            
            if (rs.next()) {
                produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setValor(rs.getDouble("valor"));
                int id_categoria = rs.getInt("categoria_id");
                Categoria categoria = daoCategoria.retrieve(id_categoria);
                
                produto.setCategoria(categoria);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return produto;
    }

    @Override
    public void update(Produto entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer pk) {
        
        String sql = "DELETE FROM produto WHERE id = ?";
        
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
    public List<Produto> findALL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static void main(String[] args) {
        
        /*
        Produto p = new Produto();
        p.setDescricao("Peça X");
        
        Categoria c = new Categoria();
        c.setDescricao("Bicicleta");
        
        p.setCategoria(c);
        
        ProdutoDAO dao = new ProdutoDAO(ConnectionFactory.createConnectionToMySQL());
        dao.create(p);
        */
        
        /*
        Produto p = new Produto();
        p.setDescricao("Peça Y");
        
        CategoriaDAO daoCategoria = new CategoriaDAO(ConnectionFactory.createConnectionToMySQL());
        Categoria categoriaMoto = daoCategoria.retrieve(2);
        
        p.setCategoria(categoriaMoto);
        
        ProdutoDAO dao = new ProdutoDAO(ConnectionFactory.createConnectionToMySQL());
        dao.create(p);
        */
        
         ProdutoDAO dao = new ProdutoDAO(ConnectionFactory.createConnectionToMySQL());
         Produto p = dao.retrieve(1);
         
         dao.delete(p.getId());

        
    }
    
}
