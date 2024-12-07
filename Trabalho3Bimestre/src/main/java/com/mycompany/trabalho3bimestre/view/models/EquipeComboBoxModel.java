/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabalho3bimestre.view.models;

import com.mycompany.trabalho3bimestre.bean.Equipe;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aluno
 */
public class EquipeComboBoxModel extends DefaultComboBoxModel<Equipe>{

    public EquipeComboBoxModel(Vector<Equipe> itens) {
        super(itens);
    }

    public EquipeComboBoxModel() {
    }

    public void setSelectedItem(Equipe equipe) {
        int numElemCB = getSize();
        for (int i = 0; i < numElemCB; i++) {
            Equipe equipeCB = getElementAt(i);
            if (equipeCB.getId() == equipe.getId()) {
                super.setSelectedItem(equipeCB);
            }
        }
    }
}
