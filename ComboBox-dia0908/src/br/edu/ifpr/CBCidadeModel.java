package br.edu.ifpr;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Aluno
 */
public class CBCidadeModel extends DefaultComboBoxModel<Cidade> {
    public CBCidadeModel(Vector <Cidade> itens){
        super(itens);
    }

    @Override
    public Cidade getSelectedItem() {
        Cidade cidade = (Cidade) super.getSelectedItem();
        return cidade;
}
}
