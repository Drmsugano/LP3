/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.view.models;

import com.mycompany.trabalho3bimestre.bean.Equipe;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author drmsugano
 */
public class EquipeTableModel extends AbstractTableModel {
    private SimpleDateFormat formatData = new SimpleDateFormat("dd/MM/yyyy");
    private List<Equipe> dados = new LinkedList<Equipe>();
    private String[] colunas = {"ID", "Nome", "Inicio", "Fim"};

    public Equipe get(int linha) {
        return dados.get(linha);
    }

    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
    }

    public void add(Equipe e) {
        this.dados.add(e);
        this.fireTableDataChanged();
    }

    public void addList(List<Equipe> equipes) {
        this.dados = equipes;
        this.fireTableDataChanged();
    }

    public void remove(Equipe e) {
        this.dados.remove(e);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Equipe equipe = dados.get(linha);

        switch (coluna) {
            case 0:
                return equipe.getId();
            case 1:
                return equipe.getNome();
            case 2:
                return formatData.format(equipe.getDataInicio());
            case 3:
                return formatData.format(equipe.getDataFim());
            default:
                return null;
        }
    }
}
