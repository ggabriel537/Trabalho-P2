package com.unigran.br.clinica.Telas.GConsulta;

import com.toedter.calendar.JDateChooser;
import com.unigran.br.clinica.Controller.ConsultaC;
import com.unigran.br.clinica.Controller.DentistaC;
import com.unigran.br.clinica.Controller.PacienteC;
import com.unigran.br.clinica.Entidades.Consulta;
import com.unigran.br.clinica.Entidades.Funcionario;
import com.unigran.br.clinica.Entidades.Paciente;
import com.unigran.br.clinica.Telas.GFuncionario.SelecaoFuncionario;
import com.unigran.br.clinica.Telas.GPaciente.SelecaoPaciente;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

public class CadastroConsulta {
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

    public CadastroConsulta() {
        f = new JFrame("Cadastro de Consulta");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        data = new JDateChooser();
        data.setPreferredSize(new Dimension(130, 18));
        DataP.add(data);
        DataP.setVisible(true);
        f.pack();
        f.setVisible(true);
        acoes();
    }

    private void acoes() {
        Sair.addActionListener(e -> {
            f.dispose();
        });
        Confirmar.addActionListener(e -> {
            cadastrar();
        });
        SelecionarP.addActionListener(e -> {
            SelecaoPaciente sp = new SelecaoPaciente(false);
            Paciente p = sp.getPaciente();

            Paciente.setText(p.getNome());
        });

        SelecionarD.addActionListener(e -> {

        });
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
            JOptionPane.showMessageDialog(null, "Campos não preenchidos\n"+erros);
        }else{
            Consulta c= new Consulta();
            c.setStatus(1);
            c.setAnexos(anexos);
            c.setDataconsulta(dataC);
            c.setDentista(getDentista(Dentista.getText()));
            c.setPaciente(getPaciente(Paciente.getText()));
            c.setObservacoes(observacoes);
            c.setValor(valor);
            ConsultaC.salvar(c);
        }
    }

    private Funcionario getDentista(String nome)
    {
        List<Funcionario> lista = DentistaC.listar();
        for (Funcionario d : lista)
        {
            if (d.getNome().equals(nome))
            {
                return d;
            }
        }
        return null;
    }

    private Paciente getPaciente(String nome)
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
