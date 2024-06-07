package com.unigran.br.clinica.Telas.GConsulta;

import javax.swing.*;

public class ConsultaPrincipal {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel ConsultaL;
    private JButton Sair;
    private JButton Cadastrar;
    private JButton Editar;
    private JFrame f;

    public ConsultaPrincipal() {
        f = new JFrame("Menu de Consulta");
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
        Cadastrar.addActionListener(e -> {
            f.dispose();
            new CadastroConsulta();
        });
        Editar.addActionListener(e -> {
            f.dispose();
            new SelecaoConsulta(true);
        });
    }
}
