/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.bean;

/**
 *
 * @author Aluno
 */
public class Produto {
    private int id;
    private String descricao;
    private String tipo;
    private int quantidade;
    private String categoria;

    public Produto(int id, String descricao, String tipo, int quantidade, String categoria) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public Produto() {
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return descricao;
    }
    
    
    
}
