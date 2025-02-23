/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.dao;

import com.mycompany.trabalho3bimestre.bean.Produto;
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
public class ProdutoDao extends GenericDao<Produto, Long> {

    public ProdutoDao() {
        super(Produto.class);
    }

    public List<String> listCategoria() {
        List<String> categorias = null;
        try {
            // Seleciona categorias distintas dos produtos
            String jpql = "SELECT DISTINCT p.categoria FROM Produto p";
            categorias = entityManager.createQuery(jpql, String.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categorias;
    }

    public List<Produto> retrieveCategoria(String categoria) {
        List<Produto> produtos = null;
        try {
            String jpql = "SELECT p FROM Produto p WHERE p.categoria = :categoria";
            produtos = entityManager.createQuery(jpql, Produto.class)
                    .setParameter("categoria", categoria)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return produtos;
    }

}
