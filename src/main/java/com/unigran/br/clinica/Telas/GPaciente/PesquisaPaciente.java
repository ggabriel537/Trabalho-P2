package com.unigran.br.clinica.Telas.GPaciente;

import javax.swing.*;

public class PesquisaPaciente {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JButton Confirmar;
    private JButton Sair;
    private JScrollPane scroll;
    private JTable Pacientes;
    private JLabel PacienteL;
    private JFrame f;

    public PesquisaPaciente() {
        f = new JFrame("Pesquisa de Paciente");
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
