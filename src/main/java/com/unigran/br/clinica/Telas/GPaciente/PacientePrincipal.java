package com.unigran.br.clinica.Telas.GPaciente;

import com.unigran.br.clinica.Telas.GConsulta.CadastroConsulta;
import com.unigran.br.clinica.Telas.GConsulta.SelecaoConsulta;

import javax.swing.*;

public class PacientePrincipal {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel PacienteL;
    private JButton Sair;
    private JButton Cadastrar;
    private JButton Editar;
    private JFrame f;

    public PacientePrincipal() {
        f = new JFrame("Menu Paciente");
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
            new CadastroPaciente();
        });
        Editar.addActionListener(e -> {
            f.dispose();
            new SelecaoPaciente(true);
        });
    }
}
