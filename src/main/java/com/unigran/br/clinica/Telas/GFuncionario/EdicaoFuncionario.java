package com.unigran.br.clinica.Telas.GFuncionario;

import javax.swing.*;

public class EdicaoFuncionario {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel EdicaoL;
    private JButton Confirmar;
    private JButton Sair;
    private JTextField Nome;
    private JTextField Usuario;
    private JPasswordField Senha;
    private JComboBox Permissao;
    private JLabel NomeL;
    private JLabel UserL;
    private JLabel SenhaL;
    private JLabel PermissaoL;

    public EdicaoFuncionario() {
        JFrame f = new JFrame("Edição de Funcionário");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
