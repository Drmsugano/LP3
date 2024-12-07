/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.view.models;

import com.mycompany.trabalho3bimestre.bean.Produto;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aluno
 */
public class ProdutoComboBoxModel extends DefaultComboBoxModel<Produto>{
    
    public ProdutoComboBoxModel(Vector<Produto> itens) {
        super(itens);
    }

    public ProdutoComboBoxModel(){
    }
    
    public void setSelectedItem(Produto produto) {
        int numElemCB = getSize();
        for (int i = 0; i < numElemCB; i++) {
            Produto produtoCB = getElementAt(i);
            if (produtoCB.getId() == produto.getId()) {
                super.setSelectedItem(produtoCB);
            }
        }
    }

    @Override
    public Produto getSelectedItem() {
        Produto produto = (Produto) super.getSelectedItem();
        return produto;
    }
}
