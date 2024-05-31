package com.unigran.br.clinica.Telas.GProntuario;

import com.unigran.br.clinica.Entidades.Prontuario;

import javax.swing.*;

public class ProntuarioTela {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JTable Dados;
    private JScrollPane Scroll;
    private JLabel ProntuarioL;
    private JButton Sair;
    private JButton Selecionar;
    private Prontuario p;
    public ProntuarioTela(Prontuario p) {
        this.p = p;
        JFrame f = new JFrame("Prontuario do Paciente");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
