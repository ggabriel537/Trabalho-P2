package com.unigran.br.clinica.Telas.GMaterial;

import javax.swing.*;

public class MaterialPrincipal {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel MaterialL;
    private JButton Sair;
    private JButton Cadastrar;
    private JButton Editar;
    private JFrame f;

    public MaterialPrincipal() {
        f = new JFrame("Menu Material");
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
