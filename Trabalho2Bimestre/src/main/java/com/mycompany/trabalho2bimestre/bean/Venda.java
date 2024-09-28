/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.bean;

import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Venda {
    private int id;
    private double valor;
    private Date data;
    private Produto produto;
    private Vendedor vendedor;

    public Venda(int id, double valor, Date data, Produto produto, Vendedor vendedor) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        this.produto = produto;
        this.vendedor = vendedor;
    }

    public Venda() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    
}
