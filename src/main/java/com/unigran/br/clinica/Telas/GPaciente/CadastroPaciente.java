package com.unigran.br.clinica.Telas.GPaciente;

import com.toedter.calendar.JDateChooser;
import com.unigran.br.clinica.Controller.PacienteC;
import com.unigran.br.clinica.Entidades.Contato;
import com.unigran.br.clinica.Entidades.Paciente;

import javax.swing.*;
import java.awt.*;
import java.util.Date;
import java.util.regex.Pattern;

public class CadastroPaciente {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel CadastroL;
    private JButton Confirmar;
    private JButton Sair;
    private JTextField CPF;
    private JTextField Nome;
    private JPanel CalendarioP;
    private JTextField Endereco;
    private JTextField Email;
    private JTextField Con1;
    private JTextField Con2;
    private JTextField Responsavel;
    private JLabel CPFL;
    private JLabel NomeL;
    private JLabel NascimentoL;
    private JLabel EnderecoL;
    private JLabel ConvenioL;
    private JLabel EmailL;
    private JLabel Con1L;
    private JLabel Con2L;
    private JLabel ResponsavelL;
    private JTextField Convenio;
    private JPanel DataP;
    private JFrame f;
    private JDateChooser data;

    public CadastroPaciente() {
        f = new JFrame("Cadastro Paciente");
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

    private void acoes()
    {
        Sair.addActionListener(e -> {
            f.dispose();
        });
        Confirmar.addActionListener(e -> {
            cadastrar();
        });
    }

    private void cadastrar()
    {
        String erros = "";
        boolean teste = false;
        String nome = Nome.getText();
        String cpf = CPF.getText();
        Date datanasc = data.getDate();
        String endereco = Endereco.getText();
        String convenio = Convenio.getText();
        String responsavel = Responsavel.getText();
        Contato contato = new Contato();
        contato.setContato1(Con1.getText());
        contato.setContato2(Con2.getText());
        contato.setEmail(Email.getText());

        if (cpf.length() != 11 || Pattern.matches("[a-zA-Z]+", CPF.getText()))
        {
            teste = true;
            erros += "CPF Inválido!\n";
        }
        if (nome.equals(""))
        {
            teste = true;
            erros += "Nome inválido!\n";
        }
        if (teste)
        {
            JOptionPane.showMessageDialog(null, "Verifique os campos preenchidos!\n"+erros);
        }else{
            Paciente p = new Paciente();
            p.setNome(nome);
            p.setContato(contato);
            p.setConvenio(convenio);
            p.setCpf(cpf);
            p.setEndereco(endereco);
            p.setNascimento(datanasc);
            p.setResponsavel(responsavel);
            try{
                PacienteC.salvar(p);
                f.dispose();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro!\n"+e.getMessage());
            }

        }
    }
}
