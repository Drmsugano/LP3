/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.bean;

import jakarta.persistence.*;

/**
 *
 * @author drmsugano
 */
@Entity
public class Ator {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   @Column(nullable = false)
   private String nome;
   @Column(nullable = false)
   private int idade;
   @Column(nullable = false)
   private String cidade;
   @Column(nullable = false)
   private double salario;
   @Column(nullable = false)
   private char sexo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
   
}
