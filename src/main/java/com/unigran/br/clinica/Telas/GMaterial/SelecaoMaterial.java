package com.unigran.br.clinica.Telas.GMaterial;

import javax.swing.*;

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

    public SelecaoMaterial(boolean chamarEditor) {
        this.chamarEditor = chamarEditor;
        f = new JFrame("Seleção de Material");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        acoes();
    }

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
    }
}
