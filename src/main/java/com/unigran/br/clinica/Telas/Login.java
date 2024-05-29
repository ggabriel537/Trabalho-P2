package com.unigran.br.clinica.Telas;

import javax.swing.*;

public class Login {
    private JPanel panel1;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JTextField User;
    private JPasswordField Senha;
    private JLabel UserL;
    private JLabel SenhaL;
    private JButton Confirmar;
    private JButton Sair;

    public static void main(String[] args) {
        JFrame f = new JFrame("Login");
        f.setContentPane(new Login().panel1);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
