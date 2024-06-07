package com.unigran.br.clinica.Telas.GPaciente;

import com.unigran.br.clinica.Controller.MaterialC;
import com.unigran.br.clinica.Controller.PacienteC;
import com.unigran.br.clinica.Entidades.Funcionario;
import com.unigran.br.clinica.Entidades.Paciente;
import com.unigran.br.clinica.Telas.GFuncionario.EdicaoFuncionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SelecaoPaciente {
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
    private boolean chamarEditor;
    private List<Paciente> listapacientes;
    private Paciente selecionadoP;

    public SelecaoPaciente(boolean chamarEditor) {
        selecionadoP = null;
        atualizarPacientes();
        this.chamarEditor = chamarEditor;
        f = new JFrame("Pesquisa de Paciente");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        acoes();
    }

    public void atualizarPacientes(){
        this.listapacientes = PacienteC.listar();
        String[] colunas = new String[]{"Nome", "Convenio"};
        Object[][] data = new Object[listapacientes.size()][colunas.length];
        for (int i = 0; i < listapacientes.size(); i++) {
            data[i][0] = listapacientes.get(i).getNome();
            data[i][1] = listapacientes.get(i).getConvenio();
        }
        Pacientes.setModel(new DefaultTableModel(data,colunas));
    }
    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
        if (chamarEditor)
        {
            Confirmar.addActionListener(e ->{
                if (Pacientes.getSelectedRow()==-1)
                {
                    JOptionPane.showMessageDialog(null, "Selecione um item!");
                }else{
                    new EdicaoPaciente(listapacientes.get(Pacientes.getSelectedRow()));
                }
            });
        }else{
            Confirmar.addActionListener(e -> {
                if (Pacientes.getSelectedRow()==-1)
                {
                    JOptionPane.showMessageDialog(null, "Selecione um item!");
                }else{
                    selecionadoP = listapacientes.get(Pacientes.getSelectedRow());
                    f.dispose();
                }
            });
        }
    }

    public Paciente getPaciente()
    {
        return selecionadoP;
    }
}
