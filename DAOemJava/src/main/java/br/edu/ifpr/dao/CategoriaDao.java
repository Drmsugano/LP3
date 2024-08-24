package br.edu.ifpr.dao;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CategoriaDao implements Dao<Integer, Categoria> {

    protected Connection conn;

    public CategoriaDao(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void create(Categoria entity) {
        String sql = "INSERT INTO categoria (descricao) VALUES (?);";
        try {
            PreparedStatement query = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getDescricao());
            query.executeUpdate();
            ResultSet rs = query.getGeneratedKeys();
            if(rs.next()){
                //Pega o Id gerado pelo banco para a nova categoria gravada
               int id = rs.getInt(1);
               entity.setId(id);
            }
            query.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Categoria retrieve(Integer pk) {
       Categoria categoria = null;
       String sql = "SELECT id, descricao FROM categoria WHERE id = ?";
        try {
            PreparedStatement query = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();
            if(rs.next()){
                categoria = new Categoria ();
                categoria.setId(rs.getInt("id"));
                categoria.setDescricao(rs.getString("descricao"));
            }
            query.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return categoria;
    }

    @Override
    public void update(Categoria entity) {
       String sql = "UPDATE categoria SET descricao = ? WHERE id = ?;";
        try {
            PreparedStatement query = conn.prepareStatement(sql);
            query.setString(1, entity.getDescricao());
            query.setInt(2, entity.getId());
            int rowsUpdated = query.executeUpdate();
            query.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM categoria WHERE id = ?;";
        try {
            PreparedStatement query = conn.prepareStatement(sql);
            query.setInt(1, pk);
            int rowsUpdated = query.executeUpdate();
            query.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Categoria> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
       /* 
         Metodo Create
        
        Categoria c = new Categoria ();
        c.setDescricao("Caminhão");
        CategoriaDao dao = new CategoriaDao(ConnectionFactory.createConnectionToMysql());
        System.out.println("Antes do Insert ID da Categoria: " + c.getId());
        dao.create(c);
        System.out.println("Depois do Insert ID da Categoria: " + c.getId()); */
       
        /* Metodo Retrieve 
        CategoriaDao dao = new CategoriaDao(ConnectionFactory.createConnectionToMysql());
        Categoria categoria = dao.retrieve(2);
        System.out.println(categoria);
       */
        /* 
        Metodo Update
       
        CategoriaDao dao = new CategoriaDao(ConnectionFactory.createConnectionToMysql());
        Categoria c = dao.retrieve(2);
        c.setDescricao("Biz");
        dao.update(c); 
        */
        /* 
        Metodo Delete
        */
        CategoriaDao dao = new CategoriaDao(ConnectionFactory.createConnectionToMysql());
        dao.delete(2);
    }
}
