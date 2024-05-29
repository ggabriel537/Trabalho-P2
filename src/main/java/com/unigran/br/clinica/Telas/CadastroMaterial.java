package com.unigran.br.clinica.Telas;

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

    public static void main(String[] args) {
        JFrame f = new JFrame("Cadastro Material");
        f.setContentPane(new CadastroMaterial().PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
