/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.bean;

import jakarta.persistence.*;
public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifpr_db");
        EntityManager em = emf.createEntityManager();
        Ator ator = new Ator();
        ator.setNome("Douglas");
        ator.setCidade("Umuarama");
        ator.setIdade(21);
        ator.setSalario(10.00);
        ator.setSexo('M');
        em.getTransaction().begin();
        em.persist(ator);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
