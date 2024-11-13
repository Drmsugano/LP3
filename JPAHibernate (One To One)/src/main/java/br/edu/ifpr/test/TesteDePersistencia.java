/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.test;

import br.edu.ifpr.model.Endereco;
import br.edu.ifpr.model.Pessoa;
import jakarta.persistence.*;

public class TesteDePersistencia {
    public static void main(String[] args) {
        Endereco end = new Endereco();
        end.setLogradouro("Avenida");
        
        Pessoa p = new Pessoa();
        p.setNome("Pessoa");
        p.setEndereco(end);
        end.setPessoa(p);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifpr_db");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        em.persist(p);
        em.persist(end);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
