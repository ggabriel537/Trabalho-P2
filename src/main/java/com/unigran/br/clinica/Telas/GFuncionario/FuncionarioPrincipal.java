package com.unigran.br.clinica.Telas.GFuncionario;

import javax.swing.*;

public class FuncionarioPrincipal {

    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel FuncionarioL;
    private JButton Sair;
    private JButton Cadastrar;
    private JButton Editar;
    private JFrame f;

    public FuncionarioPrincipal() {
        f = new JFrame("Edição de Consulta");
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
