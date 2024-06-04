package com.unigran.br.clinica.Telas.GFuncionario;

import javax.swing.*;

public class SelecaoFuncionario {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel SelecaoL;
    private JButton Confirmar;
    private JButton Sair;
    private JScrollPane scroll;
    private JTable Funcionarios;
    private JFrame f;
    private boolean chamarEditor;

    public SelecaoFuncionario(boolean chamarEditor) {
        this.chamarEditor = chamarEditor;
        f = new JFrame("Seleção de Funcionário");
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
