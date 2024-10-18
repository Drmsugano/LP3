/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.dao;

import com.mycompany.trabalho2bimestre.bean.Produto;
import com.mycompany.trabalho2bimestre.bean.Venda;
import com.mycompany.trabalho2bimestre.bean.Vendedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

public class VendaDao implements Dao<Integer, Venda> {

    protected Connection con;

    public VendaDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Venda entity) {
        String sql = "INSERT INTO venda (valor, produto_id, vendedor_id) VALUES(?,?,?)";
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setDouble(1, entity.getValor());
            query.setInt(2, entity.getProduto().getId());
            query.setInt(3, entity.getVendedor().getId());
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
    public Venda retrieve(Integer pk) {
        Venda venda = null;
        if (pk != null) {
            String sql = "SELECT id, valor, produto_id, vendedor_id FROM venda WHERE id = ?";
            try {
                PreparedStatement query = con.prepareStatement(sql);
                query.setInt(1, pk);
                ResultSet rs = query.executeQuery();
                ProdutoDao produtoDao = new ProdutoDao(con);
                VendedorDao vendedorDao = new VendedorDao(con);
                if (rs.next()) {
                    venda = new Venda();
                    venda.setId(rs.getInt("id"));
                    venda.setValor(rs.getDouble("valor"));
                    int id_produto = rs.getInt("produto_id");
                    Produto produto = produtoDao.retrieve(id_produto);
                    venda.setProduto(produto);
                    int id_vendedor = rs.getInt("vendedor_id");
                    Vendedor vendedor = vendedorDao.retrieve(id_vendedor);
                    venda.setVendedor(vendedor);
                }
                query.close();
            } catch (SQLException e) {
                System.out.println("Erro " + e.getMessage());
            }
        }
        return venda;
    }

    @Override
    public void update(Venda entity) {
        String sql = "UPDATE venda SET produto_id = ? , valor = ?, vendedor_id = ? where id = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, entity.getProduto().getId());
            query.setDouble(2, entity.getValor());
            query.setInt(3, entity.getVendedor().getId());
            query.setInt(4, entity.getId());
            query.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro " + e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM venda WHERE id = ?";
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
    public List<Venda> findALL() {
        List<Venda> venda = new LinkedList<Venda>();
        String sql = "SELECT id,valor,produto_id,vendedor_id,data FROM venda";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ProdutoDao produtoDao = new ProdutoDao(con);
            VendedorDao vendedorDao = new VendedorDao(con);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                Venda vendas = new Venda();
                vendas.setId(rs.getInt("id"));
                vendas.setValor(rs.getDouble("valor"));
                int id_produto = rs.getInt("produto_id");
                Produto produto = produtoDao.retrieve(id_produto);
                vendas.setProduto(produto);
                int id_vendedor = rs.getInt("vendedor_id");
                Vendedor vendedor = vendedorDao.retrieve(id_vendedor);
                vendas.setVendedor(vendedor);
                vendas.setData((Date) rs.getDate("data"));
                venda.add(vendas);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return venda;
    }

}
