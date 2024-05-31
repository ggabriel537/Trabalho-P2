package com.unigran.br.clinica.Telas.GFuncionario;

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
    private JFrame f;

    public CadastroFuncionario() {
        f = new JFrame("Cadastro de Funcionário");
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
