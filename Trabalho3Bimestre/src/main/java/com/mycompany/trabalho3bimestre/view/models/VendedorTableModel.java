/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.view.models;

import com.mycompany.trabalho3bimestre.bean.Vendedor;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class VendedorTableModel extends AbstractTableModel{
   private List<Vendedor> dados = new LinkedList<Vendedor>();
    private String[] colunas = {"ID", "Nome","Nivel","Equipe"};

    public Vendedor get(int linha) {
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

    public void add(Vendedor v) {
        this.dados.add(v);
        this.fireTableDataChanged();
    }

    public void addList(List<Vendedor> vendedor) {
        this.dados = vendedor;
        this.fireTableDataChanged();
    }

    public void remove(Vendedor v) {
        this.dados.remove(v);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Vendedor vendedor = dados.get(linha);

        switch (coluna) {
            case 0:
                return vendedor.getId();
            case 1:
                return vendedor.getNome();
            case 2:
                return vendedor.getNivel();
            case 3:
                return vendedor.getEquipe().getNome();
            default:
                return null;
        }
    }
    
}
