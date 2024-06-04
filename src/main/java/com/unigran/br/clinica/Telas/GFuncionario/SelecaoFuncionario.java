package com.unigran.br.clinica.Telas.GFuncionario;

import com.unigran.br.clinica.Controller.ConsultaC;
import com.unigran.br.clinica.Controller.FuncionarioC;
import com.unigran.br.clinica.Entidades.Funcionario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SelecaoFuncionario {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel SelecaoL;
    private JButton Confirmar;
    private JButton Sair;
    private JScrollPane scroll;
    private JTable Funcionarios;
    private JFrame f;
    private boolean chamarEditor;
    private List<Funcionario> listafuncionario;

    public SelecaoFuncionario(boolean chamarEditor) {
        this.chamarEditor = chamarEditor;
        f = new JFrame("Seleção de Funcionário");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        f.setVisible(true);
        acoes();
    }

    public void atualizarFuncionarios(){
        this.listafuncionario = FuncionarioC.listar();
        String[] colunas = new String[]{"Nome", "Cargo"};
        Object[][] data = new Object[listafuncionario.size()][colunas.length];
        for (int i = 0; i < listafuncionario.size(); i++) {
            data[i][0] = listafuncionario.get(i).getNome();
            String cargo;
            switch (listafuncionario.get(i).getPermissao())
            {
                case 1:{
                    cargo = "Recepcionista";
                    break;
                }
                case 2:{
                    cargo = "Médico";
                    break;
                }
                case 3:{
                    cargo = "Gerente";
                    break;
                }
                case 4:{
                    cargo = "Admin";
                    break;
                }
                default:{
                    cargo = "Desconhecido";
                    break;
                }
            }
            data[i][2] = cargo;
        }
        Funcionarios.setModel(new DefaultTableModel(data,colunas));
        f.pack();
    }

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
    }
}
