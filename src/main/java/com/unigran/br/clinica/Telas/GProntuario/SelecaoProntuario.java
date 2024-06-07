package com.unigran.br.clinica.Telas.GProntuario;

import com.unigran.br.clinica.Controller.MaterialC;
import com.unigran.br.clinica.Controller.PacienteC;
import com.unigran.br.clinica.Controller.ProntuarioC;
import com.unigran.br.clinica.Entidades.Paciente;
import com.unigran.br.clinica.Entidades.Prontuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SelecaoProntuario {
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
    private JFrame f;
    private List<Paciente> listapacientes;

    public SelecaoProntuario() {
        f = new JFrame("Pesquisa de Prontuario");
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
        f.pack();
    }

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
    }
}
