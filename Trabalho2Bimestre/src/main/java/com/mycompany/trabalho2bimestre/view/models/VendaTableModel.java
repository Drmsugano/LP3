/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho2bimestre.view.models;

import com.mycompany.trabalho2bimestre.bean.Venda;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author douglas
 */
public class VendaTableModel extends AbstractTableModel {
private List<Venda> dados = new LinkedList<Venda>();
    private String[] colunas = {"ID", "Produto","Vendedor","Valor","Data da Venda"};

    public Venda get(int linha) {
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

    public void add(Venda v) {
        this.dados.add(v);
        this.fireTableDataChanged();
    }

    public void addList(List<Venda> venda) {
        this.dados = venda;
        this.fireTableDataChanged();
    }

    public void remove(Venda v) {
        this.dados.remove(v);
        this.fireTableDataChanged();
    }

    @Override
    public Object getValueAt(int linha, int coluna) {

        Venda venda = dados.get(linha);

        switch (coluna) {
            case 0:
                return venda.getId();
            case 1:
                return venda.getProduto().getDescricao();
            case 2:
                return venda.getVendedor().getNome();
            case 3:
                return "R$"+ venda.getValor();
            case 4:
                return venda.getData();
            default:
                return null;
        }
    }
}
