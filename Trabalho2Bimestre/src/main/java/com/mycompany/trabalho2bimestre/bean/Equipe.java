package com.mycompany.trabalho2bimestre.bean;

import java.util.Date;

public class Equipe {

    private int id;
    private String nome;
    private Date dataInicio;
    private Date dataFim;

    public Equipe() {
    }

    public Equipe(int id, String nome, Date dataInicio, Date dataFim) {
        this.id = id;
        this.nome = nome;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
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

    @Override
    public String toString() {
        return nome;
    }
    
}
