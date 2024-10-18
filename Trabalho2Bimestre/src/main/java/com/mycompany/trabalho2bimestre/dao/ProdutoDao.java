/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.dao;

import com.mycompany.trabalho2bimestre.bean.Produto;
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
public class ProdutoDao implements Dao<Integer, Produto> {

    protected Connection con;

    public ProdutoDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Produto entity) {
        String sql = "INSERT INTO produto (descricao,tipo,quantidade,categoria) VALUES (?,?,?,?);";
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getDescricao());
            query.setString(2, entity.getTipo());
            query.setInt(3, entity.getQuantidade());
            query.setString(4, entity.getCategoria());
            query.executeUpdate();
            ResultSet rs = query.getGeneratedKeys();
            if (rs.next()) {
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
        if (pk != null) {
            String sql = "SELECT * FROM produto WHERE id = ?";
            try {
                PreparedStatement query = con.prepareStatement(sql);
                query.setInt(1, pk);
                ResultSet rs = query.executeQuery();
                if (rs.next()) {
                    produto = new Produto();
                    produto.setId(rs.getInt("id"));
                    produto.setDescricao(rs.getString("descricao"));
                    produto.setTipo(rs.getString("tipo"));
                    produto.setCategoria(rs.getString("categoria"));
                    produto.setQuantidade(rs.getInt("quantidade"));
                }
                query.close();
            } catch (SQLException e) {
                System.out.println("Erro " + e.getMessage());
            }
        }
        return produto;
    }

    @Override
    public void update(Produto entity) {
        String sql = "update produto SET descricao = ?, tipo = ?, categoria= ?, quantidade= ? WHERE id = ?;";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getDescricao());
            query.setString(2, entity.getTipo());
            query.setString(3, entity.getCategoria());
            query.setInt(4, entity.getQuantidade());
            query.setInt(5, entity.getId());
            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
        List<Produto> produtos = new LinkedList<Produto>();
        String sql = "SELECT * FROM produto";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setTipo(rs.getString("tipo"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setCategoria(rs.getString("categoria"));
                produtos.add(produto);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return produtos;
    }
}
