/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.w3c.dom.views.AbstractView;

/**
 *
 * @author efbaro
 */
public class PessoaTableModel extends AbstractTableModel{
    
    private List<Pessoa> dadosPersistentes = new LinkedList<Pessoa>();
    
    private List<Pessoa> dados = new LinkedList<Pessoa>();
    private String[] colunas = {"Nome", "Idade", "CPF", "Endereço"};
    
    public PessoaTableModel() {
        
    }
    
    public void consultar(String campo, String stringDePesquisa) {
        
        this.dados.clear();
        
        if (stringDePesquisa.isBlank()) {
            dados.addAll(dadosPersistentes);
        } else {
            Iterator<Pessoa> iterator = dadosPersistentes.iterator();
            
            while (iterator.hasNext()) {
            
                Pessoa p = iterator.next();

                switch (campo) {
                    case "Nome":
                        
                        if (p.getNome().toLowerCase().contains(stringDePesquisa.toLowerCase())) {
                            this.dados.add(p);
                        }
                        break;
                    case "Idade":
                        if (p.getIdade() == Integer.valueOf(stringDePesquisa)) {
                            this.dados.add(p);
                        }
                        break;
                    case "CPF":
                        if (p.getCpf().toLowerCase().contains(stringDePesquisa.toLowerCase())) {
                            this.dados.add(p);
                        }
                        break;
                    case "Endereço":
                        if (p.getEndereco().toLowerCase().contains(stringDePesquisa.toLowerCase())) {
                            this.dados.add(p);
                        }
                        break;
                    default:    
                }
            }
        }
        
        
        this.fireTableDataChanged();
        
    }
    
    public void add(Pessoa p) {
        this.dados.add(p);
        this.dadosPersistentes.add(p);
    }

    @Override
    public String getColumnName(int coluna) {
        return colunas[coluna];
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
    public Object getValueAt(int linha, int coluna) {
        Pessoa pessoa = dados.get(linha);
        
        switch (coluna) {
            case 0:
                return pessoa.getNome();
            case 1:
                return pessoa.getIdade();
            case 2:
                return pessoa.getCpf();
            case 3:
                return pessoa.getEndereco();
            default:
                return null;
        }
        
    }
    
    
    
}
