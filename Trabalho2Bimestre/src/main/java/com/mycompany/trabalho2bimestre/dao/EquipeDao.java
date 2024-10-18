/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.dao;

import com.mycompany.trabalho2bimestre.bean.Equipe;
import com.mycompany.trabalho2bimestre.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
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
public class EquipeDao implements Dao<Integer, Equipe> {

    protected Connection con;

    public EquipeDao(Connection con) {
        this.con = con;
    }

    @Override
    public void create(Equipe entity) {
        String sql = "INSERT INTO equipe (nome,inicio,fim) VALUES (?,?,?);";
        try {
            PreparedStatement query = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            query.setString(1, entity.getNome());
            query.setDate(2, new java.sql.Date(entity.getDataInicio().getTime()));
            query.setDate(3, new java.sql.Date(entity.getDataFim().getTime()));
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
    public Equipe retrieve(Integer pk) {
        Equipe equipe = null;
        if (pk != null) {
            String sql = "SELECT id, nome,inicio,fim FROM equipe WHERE id = ?";
            try {
                PreparedStatement query = con.prepareStatement(sql);
                query.setInt(1, pk);
                ResultSet rs = query.executeQuery();
                if (rs.next()) {
                    equipe = new Equipe();
                    equipe.setId(rs.getInt("id"));
                    equipe.setNome(rs.getString("nome"));
                    equipe.setDataInicio(rs.getDate("inicio"));
                    equipe.setDataFim(rs.getDate("fim"));
                }
                query.close();
            } catch (SQLException e) {
                System.out.println("Erro " + e.getMessage());
            }
        }
        return equipe;
    }

    @Override
    public void update(Equipe entity) {
        String sql = "update equipe SET nome = ?, inicio = ?, fim = ? WHERE id = ?;";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setString(1, entity.getNome());
            query.setDate(2, new java.sql.Date(entity.getDataInicio().getTime()));
            query.setDate(3, new java.sql.Date(entity.getDataFim().getTime()));
            query.setInt(4, entity.getId());
            query.executeUpdate();
            query.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Integer pk) {
        String sql = "DELETE FROM equipe WHERE id = ?";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);

            int rowsUpdated = query.executeUpdate();

            query.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean verificarEquipe(Integer pk) {
        String sql = "SELECT COUNT(*) from equipe e inner join vendedor v on e.id = v.id WHERE v.id = ?";
        boolean ver = true;
        try {
            PreparedStatement query = con.prepareStatement(sql);
            query.setInt(1, pk);
            ResultSet rs = query.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1); // Pega o valor da contagem
                if (count < 1) {
                    ver = true;
                } else if(count >= 1) {
                    ver = false;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return ver;
    }

    @Override
    public List<Equipe> findALL() {
        List<Equipe> equipes = new LinkedList<Equipe>();
        String sql = "SELECT * FROM equipe";
        try {
            PreparedStatement query = con.prepareStatement(sql);
            ResultSet rs = query.executeQuery();
            while (rs.next()) {
                Equipe equipe = new Equipe();
                equipe.setId(rs.getInt("id"));
                equipe.setNome(rs.getString("nome"));
                equipe.setDataInicio(rs.getDate("inicio"));
                equipe.setDataFim(rs.getDate("fim"));
                equipes.add(equipe);
            }
            query.close();
        } catch (SQLException e) {
            System.out.println("Erro : " + e.getMessage());
        }
        return equipes;
    }

}
