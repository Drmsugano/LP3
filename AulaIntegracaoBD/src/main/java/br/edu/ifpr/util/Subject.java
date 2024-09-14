/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifpr.util;

/**
 *
 * @author Aluno
 */
public interface Subject {
    
    public void add(Observer observer);
    public void remove(Observer observer);
    public void notify2(Object obj);
}
