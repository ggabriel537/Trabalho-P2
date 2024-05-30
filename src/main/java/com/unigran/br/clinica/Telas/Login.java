package com.unigran.br.clinica.Telas;

import javax.swing.*;

public class Login {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JTextField User;
    private JPasswordField Senha;
    private JLabel UserL;
    private JLabel SenhaL;
    private JButton Confirmar;
    private JButton Sair;

    public Login() {
        JFrame f = new JFrame("Login");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
