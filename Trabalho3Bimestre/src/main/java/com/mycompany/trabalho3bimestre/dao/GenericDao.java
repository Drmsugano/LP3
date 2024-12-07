/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.dao;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public abstract class GenericDao <T,I extends Serializable> {

    protected EntityManager entityManager;

    private Class<T> persistedClass;

    protected GenericDao() {
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("ifpr_db");
       this.entityManager = emf.createEntityManager();
   }

   protected GenericDao(Class<T> persistedClass) {
       this();
       this.persistedClass = persistedClass;
   }
    public T salvar(T entity) {
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        entityManager.flush();
        t.commit();
        return entity;
    }

    public T atualizar(T entity) {
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.merge(entity);
        entityManager.flush();
        t.commit();
        return entity;
    }

    public void remover(I id) {
        T entity = encontrar(id);
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T mergedEntity = entityManager.merge(entity);
        entityManager.remove(mergedEntity);
        entityManager.flush();
        tx.commit();
    }

    public List<T> getList() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        return entityManager.createQuery(query).getResultList();
    }

    public T encontrar(I id) {
        return entityManager.find(persistedClass, id);
    }
}
