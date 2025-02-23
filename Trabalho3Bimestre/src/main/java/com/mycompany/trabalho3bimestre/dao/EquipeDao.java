/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.dao;

import com.mycompany.trabalho3bimestre.bean.Equipe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
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
public class EquipeDao extends GenericDao<Equipe, Long> {

    public EquipeDao() {
        super(Equipe.class);
    }

    public boolean verificarEquipe(Integer equipeId) {
        boolean estaVinculada = false;
        try {
            // Consulta JPQL para verificar se há funcionários vinculados à equipe
            String jpql = "SELECT COUNT(v) FROM Vendedor v WHERE v.equipe.id = :equipeId";
            Long count = entityManager.createQuery(jpql, Long.class)
                    .setParameter("equipeId", equipeId)
                    .getSingleResult();

            estaVinculada = count > 0; // Retorna true se houver pelo menos um funcionário
        } catch (Exception e) {
            e.printStackTrace();
        }
        return estaVinculada;
    }

    public List<Equipe> retrieveFiltro(String filtragem) {
        List<Equipe> equipe = new LinkedList<>(); // Garante que nunca será null
        switch (filtragem) {
            case "Inativa":
                try {
                    String jpql = "SELECT e FROM Equipe e WHERE e.dataFim IS NOT NULL";
                    equipe = entityManager.createQuery(jpql, Equipe.class).getResultList();
                    System.out.println(equipe);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "Ativa":
                try {
                    String jpql = "SELECT e FROM Equipe e WHERE e.dataFim IS NULL";
                    equipe = entityManager.createQuery(jpql, Equipe.class).getResultList();
                    System.out.println(equipe);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println("Filtro inválido: " + filtragem);
                break;
        }
        return equipe;
    }

}
