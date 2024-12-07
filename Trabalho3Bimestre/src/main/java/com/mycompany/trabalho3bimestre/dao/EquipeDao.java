/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.dao;

import com.mycompany.trabalho3bimestre.bean.Equipe;
import jakarta.persistence.Query;
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

    public boolean verificarEquipe(int id) {
        String jpql = "SELECT COUNT(e) from equipe e where e.id = :id";
        Query query = entityManager.createQuery(jpql);
        query.setParameter(1, id);
    }
}
