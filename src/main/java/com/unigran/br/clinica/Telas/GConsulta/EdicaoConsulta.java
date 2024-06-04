package com.unigran.br.clinica.Telas.GConsulta;

import com.toedter.calendar.JDateChooser;
import com.unigran.br.clinica.Controller.ConsultaC;
import com.unigran.br.clinica.Controller.DentistaC;
import com.unigran.br.clinica.Controller.PacienteC;
import com.unigran.br.clinica.Entidades.Consulta;
import com.unigran.br.clinica.Entidades.Dentista;
import com.unigran.br.clinica.Entidades.Paciente;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

public class EdicaoConsulta {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel ConsultaL;
    private JButton Confirmar;
    private JButton Sair;
    private JButton SelecionarP;
    private JTextField Paciente;
    private JLabel PacienteL;
    private JButton SelecionarD;
    private JLabel DentistaL;
    private JTextField Dentista;
    private JLabel ObservacaoL;
    private JLabel ValorL;
    private JLabel AnexoL;
    private JTextArea Observacao;
    private JScrollPane scroll;
    private JScrollPane scroll2;
    private JTextArea Anexos;
    private JLabel DataL;
    private JPanel DataP;
    private JFormattedTextField Valor;
    private JFrame f;
    private JDateChooser data;
    private Consulta consulta;

    public EdicaoConsulta(Consulta consulta) {
        f = new JFrame("Edição de Consulta");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        data = new JDateChooser();
        data.setPreferredSize(new Dimension(130, 18));
        DataP.add(data);
        DataP.setVisible(true);
        f.pack();
        f.setVisible(true);
        configuracoes();
        acoes();
    }

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
        Confirmar.addActionListener(e -> {
            cadastrar();
        });
    }

    private void configuracoes()
    {
        data.setDate(consulta.getDataconsulta());
        Paciente.setText(consulta.getPaciente().getNome());
        Dentista.setText(consulta.getDentista().getNome());
        Observacao.setText(consulta.getObservacoes());
        Anexos.setText(consulta.getAnexos());
        Valor.setText(String.valueOf(consulta.getValor()));
    }

    private void cadastrar()
    {
        String observacoes = Observacao.getText();
        String anexos = Anexos.getText();
        double valor = Double.parseDouble(Valor.getText());
        Date dataC = data.getDate();
        boolean teste = false;
        String erros = "";
        if (Paciente.getText().isEmpty()) {
            teste = true;
            erros += "Selecione um paciente!\n";
        }
        if (Dentista.getText().isEmpty())
        {
            teste = true;
            erros += "Selecione um médico!\n";
        }
        if (teste)
        {
            JOptionPane.showMessageDialog(null, "Campos não preenchidos\n");
        }else{
            Consulta c = new Consulta();
            c.setStatus(consulta.getStatus());
            c.setAnexos(anexos);
            c.setDataconsulta(dataC);
            c.setDentista(getDentista(Dentista.getText()));
            c.setPaciente(getPaciente(Paciente.getText()));
            c.setObservacoes(observacoes);
            c.setValor(valor);
            ConsultaC.atualizar(c, consulta);
        }
    }

    private com.unigran.br.clinica.Entidades.Dentista getDentista(String nome)
    {
        java.util.List<Dentista> lista = DentistaC.listar();
        for (Dentista d : lista)
        {
            if (d.getNome().equals(nome))
            {
                return d;
            }
        }
        return null;
    }

    private com.unigran.br.clinica.Entidades.Paciente getPaciente(String nome)
    {
        List<Paciente> lista = PacienteC.listar();
        for (Paciente p : lista)
        {
            if (p.getNome().equals(nome))
            {
                return p;
            }
        }
        return null;
    }
}
