/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.test;

import com.mycompany.atividadelp3.bean.Endereco;
import com.mycompany.atividadelp3.bean.Gerente;
import com.mycompany.atividadelp3.bean.Venda;
import com.mycompany.atividadelp3.bean.Vendedor;
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
        
        Gerente g1 = new Gerente();
        g1.setNome("Gerente A");
        g1.setSalario(5445.55);
        g1.setDepartamento("Estoque");
        
        Gerente g2 = new Gerente();
        g2.setNome("Gerente B");
        g2.setSalario(6666.66);
        g2.setDepartamento("ProduÃ§Ã£o");
        
        Vendedor v1 = new Vendedor();
        v1.setNome("Vendedor A");
        v1.setSalario(1800.00);
        v1.setMeta_mensal(55000.00);
        
        Vendedor v2 = new Vendedor();
        v2.setNome("Vendedor B");
        v2.setSalario(2100.50);
        v2.setMeta_mensal(65000.00);
        
        Endereco end1 = new Endereco();
        end1.setRua("Rua A");
        end1.setCidade("Cidade A");
        end1.setEstado("Estado A");
        end1.setCep("99.999-999");
        end1.setFuncionario(v1);
        
        Endereco end2 = new Endereco();
        end2.setRua("Rua B");
        end2.setCidade("Cidade B");
        end2.setEstado("Estado B");
        end2.setCep("99.999-999");
        end2.setFuncionario(v2);
        
        Endereco end3 = new Endereco();
        end3.setRua("Rua C");
        end3.setCidade("Cidade C");
        end3.setEstado("Estado C");
        end3.setCep("99.999-999");
        end3.setFuncionario(g1);
        
        Endereco end4 = new Endereco();
        end4.setRua("Rua D");
        end4.setCidade("Cidade D");
        end4.setEstado("Estado D");
        end4.setCep("99.999-999");
        end4.setFuncionario(g2);
        
        Venda venda1 = new Venda();
        venda1.setValor(500.00);
        venda1.setVendedor(v1);
        venda1.setGerente(g1);
        
        Venda venda2 = new Venda();
        venda2.setValor(980.10);
        venda2.setVendedor(v2);

        Venda venda3 = new Venda();
        venda3.setValor(5799.99);
        venda3.setGerente(g2);
        
        em.getTransaction().begin();
        em.persist(end1);
        em.persist(end2);
        em.persist(end3);
        em.persist(end4);
        em.persist(v1);
        em.persist(v2);
        em.persist(g1);
        em.persist(g2);
        em.persist(venda1);
        em.persist(venda2);
        em.persist(venda3);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
