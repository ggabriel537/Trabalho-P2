package com.unigran.br.clinica.Telas.GProntuario;

import com.unigran.br.clinica.Controller.PacienteC;
import com.unigran.br.clinica.Controller.ProntuarioC;
import com.unigran.br.clinica.Entidades.Prontuario;
import com.unigran.br.clinica.Telas.GConsulta.EdicaoConsulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

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
    private JFrame f;
    private List<Prontuario> listaprontuarios;
    public ProntuarioTela(Prontuario p) {
        this.p = p;
        f = new JFrame("Prontuario do Paciente");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        acoes();
    }

    public void atualizarProntuarios(){
        this.listaprontuarios = ProntuarioC.listar();
        String[] colunas = new String[]{"Nome", "Convenio"};
        Object[][] data = new Object[listaprontuarios.size()][colunas.length];
        for (int i = 0; i < listaprontuarios.size(); i++) {
            for (int j = 0; j < listaprontuarios.get(i).getHistorico().size();j++)
            {
                data[i][0] = listaprontuarios.get(i).getPaciente().getNome();
                data[i][1] = listaprontuarios.get(i).getHistorico().get(j).getObservacoes();
                String status;
                switch (listaprontuarios.get(i).getHistorico().get(j).getStatus())
                {
                    case 1:{
                        status = "Agendado";
                        break;
                    }
                    case 2: {
                        status = "Concluida";
                        break;
                    }
                    default:{
                        status = "Desconhecido";
                        break;
                    }
                }
                data[i][2] = status;
            }
        }
        Dados.setModel(new DefaultTableModel(data,colunas));
        f.pack();
    }

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
        Selecionar.addActionListener(e -> {
            if (Dados.getSelectedRow()!=-1)
            {
                f.dispose();
                new EdicaoConsulta(null); //alterar
            }
        });
    }
}
