package com.unigran.br.clinica.Telas;

import javax.swing.*;

public class CadastroFuncionario {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JLabel CadastroL;
    private JTextField Nome;
    private JTextField Usuario;
    private JTextField Senha;
    private JComboBox Permissoes;
    private JButton Confirmar;
    private JButton Sair;
    private JLabel NomeL;
    private JLabel UsuarioL;
    private JLabel SenhaL;
    private JLabel PermissaoL;

    public static void main(String[] args) {
        JFrame f = new JFrame("Cadastro Funcionário");
        f.setContentPane(new CadastroFuncionario().PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
