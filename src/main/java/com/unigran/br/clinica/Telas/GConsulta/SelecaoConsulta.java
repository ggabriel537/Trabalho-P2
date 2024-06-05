package com.unigran.br.clinica.Telas.GConsulta;

import com.unigran.br.clinica.Controller.ConsultaC;
import com.unigran.br.clinica.Entidades.Consulta;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SelecaoConsulta {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel SelecaoL;
    private JButton Confirmar;
    private JButton Sair;
    private JScrollPane scroll;
    private JTable Consultas;
    private JFrame f;
    private boolean chamarEditor;
    private List<Consulta> listaconsulta;

    public SelecaoConsulta(boolean chamarEditor) {
        this.chamarEditor = chamarEditor;
        f = new JFrame("Seleção de Consulta");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        acoes();
    }

    public void atualizarConsultas(){
        this.listaconsulta = ConsultaC.listar();
        String[] colunas = new String[]{"Paciente", "Observações", "Status"};
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
            data[i][1] = status;
        }
        Consultas.setModel(new DefaultTableModel(data,colunas));
        f.pack();
    }

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
        if (chamarEditor)
        {
            Confirmar.addActionListener(e ->{
                if (Consultas.getSelectedRow()==-1)
                {
                    JOptionPane.showMessageDialog(null, "Selecione um item!");
                }else{
                    new EdicaoConsulta(listaconsulta.get(Consultas.getSelectedRow()));
                }
            });
        }


    }
}
