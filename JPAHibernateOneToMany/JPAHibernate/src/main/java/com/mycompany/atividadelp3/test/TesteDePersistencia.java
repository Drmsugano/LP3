/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.test;


import com.mycompany.atividadelp3.bean.Empregado;
import com.mycompany.atividadelp3.bean.Projeto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author Aluno
 */
public class TesteDePersistencia {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifpr_db");
        EntityManager em = emf.createEntityManager();
        
         
        Projeto p1 = new Projeto();
        p1.setNome("DMC 6");
        p1.setData_inicio("??/??/????");
        p1.setData_fim("??/??/????");
        
        Empregado e1 = new Empregado();
        e1.setNome("Douglas");
        e1.setCargo("Dev");
        e1.setData_admissao("16/08/2003");
        
        p1.addEmpregados(e1);
        
        em.persist(p1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
