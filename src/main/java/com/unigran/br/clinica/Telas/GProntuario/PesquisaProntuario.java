package com.unigran.br.clinica.Telas.GProntuario;

import javax.swing.*;

public class PesquisaProntuario {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JTextField Paciente;
    private JLabel PacienteL;
    private JLabel ProntuarioL;
    private JButton Confirmar;
    private JButton Sair;
    private JButton Filtrar;
    private JScrollPane Scroll;
    private JTable Pacientes;

    public PesquisaProntuario() {
        JFrame f = new JFrame("Pesquisa de Prontuario");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
