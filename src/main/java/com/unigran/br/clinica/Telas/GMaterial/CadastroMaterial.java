package com.unigran.br.clinica.Telas.GMaterial;

import javax.swing.*;

public class CadastroMaterial {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JLabel MaterialL;
    private JTextField Quantidade;
    private JTextField Minimo;
    private JTextField Nome;
    private JButton Confirmar;
    private JButton Sair;
    private JLabel NomeL;
    private JLabel QuantidadeL;
    private JLabel MinimoL;
    private JFrame f;

    public CadastroMaterial() {
        f = new JFrame("Cadastro Material");
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
