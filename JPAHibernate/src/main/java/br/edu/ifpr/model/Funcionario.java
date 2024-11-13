/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.model;

import jakarta.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author drmsugano
 */
@Entity
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Basic
    @Column(nullable = false)
    private String nome;
    @Basic
    @Column(nullable = false)
    private Double salario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "funcionario_id")
    private List<Endereco> enderecos;

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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
     public void addEndereco(Endereco e) {
         if (enderecos == null) {
            enderecos = new LinkedList<Endereco>();
        }
        enderecos.add(e);
    }
}
