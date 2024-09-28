/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.trabalho2bimestre.dao;

import java.util.List;

/**
 *
 * @author Aluno
 */
public interface Dao<PK, T> {
    public void create(T entity);
    public T retrieve(PK pk);
    public void update(T entity);
    public void delete(PK pk);
    public List<T> findALL();
}
