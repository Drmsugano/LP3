/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.view.models;
import com.mycompany.trabalho3bimestre.bean.Vendedor;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author douglas
 */
public class VendedorComboBoxModel extends DefaultComboBoxModel<Vendedor>{
    public VendedorComboBoxModel(Vector<Vendedor> itens) {
        super(itens);
    }

    public VendedorComboBoxModel() {
    }

    public void setSelectedItem(Vendedor vendedor) {
        int numElemCB = getSize();
        for (int i = 0; i < numElemCB; i++) {
            Vendedor vendedorCB = getElementAt(i);
            if (vendedorCB.getId() == vendedor.getId()) {
                super.setSelectedItem(vendedorCB);
            }
        }
    }
}
