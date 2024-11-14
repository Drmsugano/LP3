/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atividadelp3.bean;

import jakarta.persistence.*;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aluno
 */
@Entity
public class Empregado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Basic
    private String nome;
    @Basic
    private String cargo;
    @Basic
    private String data_admissao;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
    name = "trabalha_em",
    joinColumns = @JoinColumn(name = "empregado_id"),
    inverseJoinColumns = @JoinColumn(name = "projeto_id")
    )
    private List<Projeto> projetos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }
    
    public String getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(String data_admissao) {
        this.data_admissao = data_admissao;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }
    public void addProjetos(Projeto p) {
         if (projetos == null) {
            projetos = new LinkedList<Projeto>();
        }
        projetos.add(p);
    }
    
}
