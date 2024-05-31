package com.unigran.br.clinica.Telas.GPaciente;

import javax.swing.*;

public class PesquisaPaciente {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JTextArea PesquisaL;
    private JButton Confirmar;
    private JButton Sair;
    private JScrollPane scroll;
    private JTable Pacientes;

    public PesquisaPaciente() {
        JFrame f = new JFrame("Pesquisa de Paciente");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
