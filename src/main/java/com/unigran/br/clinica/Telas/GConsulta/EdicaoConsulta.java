package com.unigran.br.clinica.Telas.GConsulta;

import javax.swing.*;

public class EdicaoConsulta {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel ConsultaL;
    private JButton Confirmar;
    private JButton Sair;
    private JButton SelecionarP;
    private JTextField textField1;
    private JLabel PacienteL;
    private JButton SelecionarD;
    private JLabel DentistaL;
    private JTextField Dentista;
    private JLabel ObservacaoL;
    private JLabel ValorL;
    private JTextField Valor;
    private JLabel AnexoL;
    private JTextArea Observacao;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    private JTextArea Anexos;
    private JLabel DataL;
    private JPanel DataP;
    private JFrame f;

    public EdicaoConsulta() {
        f = new JFrame("Edição de Consulta");
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
    }
}
