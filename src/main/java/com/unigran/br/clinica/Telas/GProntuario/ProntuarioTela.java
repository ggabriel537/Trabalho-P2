package com.unigran.br.clinica.Telas.GProntuario;

import com.unigran.br.clinica.Controller.ConsultaC;
import com.unigran.br.clinica.Entidades.Consulta;
import com.unigran.br.clinica.Entidades.Paciente;
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
    private Paciente p;
    private JFrame f;
    private List<Consulta> listaconsulta;
    public ProntuarioTela(Paciente p) {
        this.p = p;
        f = new JFrame("Prontuario do Paciente");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        atualizarProntuarios();
        f.pack();
        f.setVisible(true);
        acoes();
    }

    public void atualizarProntuarios(){
        this.listaconsulta = ConsultaC.listar(p.getCpf());
        String[] colunas = new String[]{"Nome", "Observações", "Status"};
        Object[][] data = new Object[listaconsulta.size()][colunas.length];
        for (int i = 0; i < listaconsulta.size(); i++) {
                data[i][0] = listaconsulta.get(i).getPaciente().getNome();
                data[i][1] = listaconsulta.get(i).getObservacoes();
                String status;
                switch (listaconsulta.get(i).getStatus())
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
                new EdicaoConsulta(listaconsulta.get(Dados.getSelectedRow()));
            }
        });
    }
}
