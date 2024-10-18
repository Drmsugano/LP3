/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.dao;

import com.mycompany.trabalho2bimestre.bean.Equipe;
import com.mycompany.trabalho2bimestre.bean.Vendedor;
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
public class VendedorDao implements Dao<Integer, Vendedor> {

    protected Connection con;

    public VendedorDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Vendedor entity) {
        String sql = "INSERT INTO vendedor (nome,nivel,equipe_id) VALUES (?,?,?);";
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getNome());
            query.setString(2, entity.getNivel());
            query.setInt(3, entity.getEquipe().getId());
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
    public Vendedor retrieve(Integer pk) {
        Vendedor vendedor = null;
        if (pk != null) {
            String sql = "SELECT v.id, v.nome, equipe_id FROM vendedor v WHERE id = ?";
            try {
                PreparedStatement query = con.prepareStatement(sql);
                query.setInt(1, pk);
                EquipeDao equipeDao = new EquipeDao(con);
                ResultSet rs = query.executeQuery();
                if (rs.next()) {
                    vendedor = new Vendedor();
                    vendedor.setId(rs.getInt("id"));
                    vendedor.setNome(rs.getString("nome"));
                    int id_equipe = rs.getInt("equipe_id");
                    Equipe equipe = equipeDao.retrieve(id_equipe);
                    vendedor.setEquipe(equipe);
                }
                query.close();
            } catch (SQLException e) {
                System.out.println("Erro " + e.getMessage());
            }
        }
        return vendedor;
    }

    @Override
    public void update(Vendedor entity) {
        String sql = "update vendedor SET nome = ?, nivel = ? , id_categoria = ? WHERE id = ?;";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getNome());
            query.setString(2, entity.getNivel());
            query.setInt(3, entity.getEquipe().getId());
            query.setInt(4, entity.getId());
            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM vendedor WHERE id = ?";
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
    public List<Vendedor> findALL() {
        List<Vendedor> vendedor = new LinkedList<Vendedor>();
        String sql = "SELECT * FROM vendedor";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            EquipeDao equipeDao = new EquipeDao(con);
            if (rs.next()) {
                Vendedor vendedores = new Vendedor();
                vendedores.setId(rs.getInt("id"));
                vendedores.setNome(rs.getString("nome"));
                int id_equipe = rs.getInt("equipe_id");
                Equipe equipe = equipeDao.retrieve(id_equipe);
                vendedores.setEquipe(equipe);
                vendedor.add(vendedores);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return vendedor;
    }
}
