package com.unigran.br.clinica.Telas.GMaterial;

import javax.swing.*;

public class EdicaoMaterial {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel GerenciamentoL;
    private JButton Confirmar;
    private JButton Sair;
    private JLabel EdicaoL;
    private JTextArea Quantidade;
    private JTextArea Minimo;
    private JLabel QuantidadeL;
    private JLabel MinimoL;
    private JTextField Material;
    private JFrame f;

    public EdicaoMaterial() {
        f = new JFrame("Edição de Material");
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
