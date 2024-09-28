/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.bean;

/**
 *
 * @author Aluno
 */
public class Vendedor {

    private int id;
    private String nome;
    private String nivel;
    private Equipe equipe;

    public Vendedor() {
    }

    public Vendedor(int id, String nome, String nivel, Equipe equipe) {
        this.id = id;
        this.nome = nome;
        this.nivel = nivel;
        this.equipe = equipe;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public String toString() {
        return nome;
    }
}
