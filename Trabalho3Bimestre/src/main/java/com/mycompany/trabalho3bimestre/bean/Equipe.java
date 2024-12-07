package com.mycompany.trabalho3bimestre.bean;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "equipe")
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(nullable = false, length = 100)
    private String nome;
    @Basic
    private Date dataInicio;
    @Basic 
    private Date dataFim;
    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vendedor> vendedores = new ArrayList<>();
   
    // Construtores, getters e setters
    public Equipe() {
    }

    public Equipe(String nome) {
        this.nome = nome;
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

    public List<Vendedor> getVendedores() {
        return vendedores;
    }

    public void setVendedores(List<Vendedor> vendedores) {
        this.vendedores = vendedores;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    
    
    // Método auxiliar para adicionar vendedores
    public void addVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
        vendedor.setEquipe(this);
    }

    public void removeVendedor(Vendedor vendedor) {
        vendedores.remove(vendedor);
        vendedor.setEquipe(null);
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
}
