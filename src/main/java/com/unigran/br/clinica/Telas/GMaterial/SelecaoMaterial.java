package com.unigran.br.clinica.Telas.GMaterial;

import com.unigran.br.clinica.Controller.FuncionarioC;
import com.unigran.br.clinica.Controller.MaterialC;
import com.unigran.br.clinica.Entidades.Material;
import com.unigran.br.clinica.Telas.GFuncionario.EdicaoFuncionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SelecaoMaterial {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel SelecaoL;
    private JButton Confirmar;
    private JButton Sair;
    private JScrollPane scroll;
    private JTable Materiais;
    private JFrame f;
    private boolean chamarEditor;
    private List<Material> listamaterial;

    public SelecaoMaterial(boolean chamarEditor) {
        this.chamarEditor = chamarEditor;
        f = new JFrame("Seleção de Material");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        atualizarMaterial();
        acoes();
    }

    public void atualizarMaterial(){
        this.listamaterial = MaterialC.listar();
        String[] colunas = new String[]{"Nome", "Quantidade"};
        Object[][] data = new Object[listamaterial.size()][colunas.length];
        for (int i = 0; i < listamaterial.size(); i++) {
            data[i][0] = listamaterial.get(i).getNome();
            data[i][1] = listamaterial.get(i).getQuantidade();
        }
        Materiais.setModel(new DefaultTableModel(data,colunas));
        f.pack();
    }

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
        if (chamarEditor)
        {
            Confirmar.addActionListener(e ->{
                if (Materiais.getSelectedRow()==-1)
                {
                    JOptionPane.showMessageDialog(null, "Selecione um item!");
                }else{
                    new EdicaoMaterial(listamaterial.get(Materiais.getSelectedRow()));
                }
            });
        }
    }
}
