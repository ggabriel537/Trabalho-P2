package com.unigran.br.clinica.Telas.GPaciente;

import javax.swing.*;

public class CadastroPaciente {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel CadastroL;
    private JButton Confirmar;
    private JButton Sair;
    private JTextField CPF;
    private JTextField Nome;
    private JPanel CalendarioP;
    private JTextField Endereco;
    private JTextField Email;
    private JTextField Con1;
    private JTextField Con2;
    private JTextField Responsavel;
    private JLabel CPFL;
    private JLabel NomeL;
    private JLabel NascimentoL;
    private JLabel EnderecoL;
    private JLabel ConvenioL;
    private JLabel EmailL;
    private JLabel Con1L;
    private JLabel Con2L;
    private JLabel ResponsavelL;
    private JTextField Convenio;
    private JFrame f;

    public CadastroPaciente() {
        f = new JFrame("Cadastro Paciente");
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