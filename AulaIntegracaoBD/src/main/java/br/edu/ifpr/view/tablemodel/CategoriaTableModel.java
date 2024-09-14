/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.view.tablemodel;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.util.Observer;
import br.edu.ifpr.util.Subject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Aluno
 */
public class CategoriaTableModel extends AbstractTableModel implements Subject{
    
    private List<Observer> obsevadores = new LinkedList<Observer>();
    
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
        notify2(c);
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
        Categoria categoria = dados.get(linha);
        switch(coluna){
            case 0:
                return categoria.getId();
            case 1:
                return categoria.getDescricao();
            default:
                return null;
        }
    }

    @Override
    public void add(Observer observer) {
        obsevadores.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        obsevadores.remove(observer);
    }

    @Override
    public void notify2(Object objt) {
        for (Iterator<Observer> iterator = obsevadores.iterator(); iterator.hasNext();) {
            Observer observer = iterator.next();
            observer.update(objt);
            System.out.println("Notificandonoooooo");
        }
    }
    
}
