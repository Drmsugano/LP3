/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.view.tablemodel;

import br.edu.ifpr.bean.Categoria;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class CategoriaTableModel extends AbstractTableModel{
    private List<Categoria> dados = new LinkedList<Categoria>();
    private String[] colunas = {"ID", "Descrição"};
    
     public Categoria get(int linha) {
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
 public void add(Categoria c) {
        this.dados.add(c);
        this.fireTableDataChanged();
    }
    
    public void addList(List<Categoria> categoria) {
        this.dados = categoria;
        this.fireTableDataChanged();
    }
    
    public void remove (Categoria c){
        this.dados.remove(c);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
