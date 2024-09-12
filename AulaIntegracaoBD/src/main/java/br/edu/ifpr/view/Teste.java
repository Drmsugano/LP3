/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.view;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.bean.Produto;
import br.edu.ifpr.dao.CategoriaDAO;
import br.edu.ifpr.dao.ProdutoDAO;
import br.edu.ifpr.util.ConnectionFactory;
import java.sql.Connection;

/**
 *
 * @author Aluno
 */
public class Teste {
    
    public static void main(String[] args) {
        
        Connection con = ConnectionFactory.createConnectionToMySQL();
        
        CategoriaDAO daoCat = new CategoriaDAO(con);
        Categoria catMoveis = new Categoria(0, "Móveis");
        Categoria catEletro = new Categoria(0, "Eletrodomesticos");
        
                
        ProdutoDAO daoProduto = new ProdutoDAO(con);
        
        Produto p1 = new Produto(0, "Cadeira", catMoveis);
        Produto p2 = new Produto(0, "Mesa", catMoveis);
        Produto p3 = new Produto(0, "Estante", catMoveis);
        
        daoProduto.create(p1);
        daoProduto.create(p2);
        daoProduto.create(p3);
        
        Produto p4 = new Produto(0, "Geladeira", catEletro);
        Produto p5 = new Produto(0, "Fogao", catEletro);
        Produto p6 = new Produto(0, "Microondas", catEletro);
        
        daoProduto.create(p4);
        daoProduto.create(p5);
        daoProduto.create(p6);

        
    }
}
