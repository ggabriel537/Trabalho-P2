package com.unigran.br.clinica.Telas.Relatorio;

import com.unigran.br.clinica.Relatorios.ConsultaR;
import com.unigran.br.clinica.Relatorios.MaterialR;

import javax.swing.*;

public class RelatorioPrincipal {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JButton Sair;
    private JLabel RelatorioL;
    private JButton RelatorioConsulta;
    private JButton RelatorioMaterial;
    private JFrame f;

    public RelatorioPrincipal() {
        f = new JFrame("Relatórios");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        acoes();
    }

    public void acoes()
    {
        RelatorioConsulta.addActionListener(e -> {
            new ConsultaR();
        });
        RelatorioMaterial.addActionListener(e -> {
            new MaterialR();
        });
    }
}
