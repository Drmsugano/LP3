/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.view.models;

import com.mycompany.trabalho3bimestre.bean.Produto;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author drmsugano
 */
public class ProdutoTableModel extends AbstractTableModel {

    private List<Produto> dados = new LinkedList<Produto>();
    private String[] colunas = {"ID", "Descrição","Tipo","Quantidade","Categoria"};

    public Produto get(int linha) {
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

    public void add(Produto p) {
        this.dados.add(p);
        this.fireTableDataChanged();
    }

    public void addList(List<Produto> produtos) {
        this.dados = produtos;
        this.fireTableDataChanged();
    }

    public void remove(Produto p) {
        this.dados.remove(p);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Produto produto = dados.get(linha);

        switch (coluna) {
            case 0:
                return produto.getId();
            case 1:
                return produto.getDescricao();
            case 2:
                return produto.getTipo();
            case 3:
                return produto.getQuantidade();
            case 4:
                return produto.getCategoria();
            default:
                return null;
        }
    }

}
