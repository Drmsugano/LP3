/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.view.tablemodel;

import br.edu.ifpr.bean.Categoria;
import br.edu.ifpr.util.Observer;
import java.util.Collection;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aluno
 */
public class CBCategoriaMoldel extends DefaultComboBoxModel<Categoria> implements Observer{

    public CBCategoriaMoldel(Vector<Categoria> items) {
        super(items);
    }

    public CBCategoriaMoldel() {
    }

    
    public void setSelectedItem(Categoria categoria) {
        
        int numElemCB = getSize();
        for (int i = 0; i < numElemCB; i++) {
            Categoria categoriaCB = getElementAt(i);
            if (categoriaCB.getId() == categoria.getId()) {
                super.setSelectedItem(categoriaCB);
            }
        }        
    }

    
    
    @Override
    public Categoria getSelectedItem() {
        return (Categoria) super.getSelectedItem();
    }

    @Override
    public void update(Object object) {
        Categoria catagoria = (Categoria) object;
        addElement(catagoria);
    }
    
    
    
}
