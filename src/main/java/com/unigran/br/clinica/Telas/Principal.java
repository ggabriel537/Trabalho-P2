package com.unigran.br.clinica.Telas;

import com.unigran.br.clinica.Telas.GConsulta.ConsultaPrincipal;
import com.unigran.br.clinica.Telas.GFuncionario.FuncionarioPrincipal;
import com.unigran.br.clinica.Telas.GMaterial.MaterialPrincipal;
import com.unigran.br.clinica.Telas.GPaciente.PacientePrincipal;
import com.unigran.br.clinica.Telas.GProntuario.SelecaoProntuario;

import javax.swing.*;

public class Principal {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JLabel PrincipalL;
    private JButton GerenciarFuncionario;
    private JButton GerenciarMaterial;
    private JPanel Opcoes;
    private JButton Sair;
    private JButton Prontuarios;
    private JButton GerenciamentoConsulta;
    private JButton GerenciamentoPaciente;
    private int perm;

    public Principal(int perm)//Utilize agora construtor para criar as telas, nao vamos mais usar o metodo main
    {
        this.perm = perm; //Mantenha da forma como está, faça dessa forma para outros Menus
        JFrame f = new JFrame("Navegação");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Importante alterar isso daqui, deixe nos menus que serão criados
        //como DISPOSE_ON_CLOSE

        GerenciarFuncionario.setVisible(false); //Sempre que criar um item novo deve adicionar um botão a essa página e digitar isso daqui
        GerenciarMaterial.setVisible(false);
        GerenciamentoConsulta.setVisible(false);
        GerenciamentoPaciente.setVisible(false);
        Prontuarios.setVisible(false);
        Sair.setVisible(true);

        aplicarPerm();
        acoes(); //Não mecher

        f.setVisible(true);
        f.pack(); //Não mecher
    }

    /*
    Permissões:
        1 - Recepcionista
        2 - Médico
        3 - Gerente
        4 - Admin
    */

    public void aplicarPerm() //Irei colocar o sistema de permissões aqui, não mecher
    {
        switch (perm)
        {
            case 0:
            {
                GerenciamentoConsulta.setVisible(true);
                GerenciamentoPaciente.setVisible(true);
                break;
            }
            case 1:
            {
                Prontuarios.setVisible(true);
                break;
            }
            case 2:
            {
                GerenciarFuncionario.setVisible(true);
                GerenciarMaterial.setVisible(true);
                break;
            }
            case 3:
            {
                GerenciarMaterial.setVisible(true);
                GerenciarFuncionario.setVisible(true);
                GerenciamentoConsulta.setVisible(true);
                GerenciamentoPaciente.setVisible(true);
                Prontuarios.setVisible(true);
                break;
            }
            default:
            {
                JOptionPane.showMessageDialog(null, "Erro ao atribuir permissão!\nContate o administrador do sistema.");
                System.exit(0);
                break;
            }
        }
    }

    public void acoes() //Aqui é importante sempre que adicionar uam nova tela no sistema deve adicionar um botão la no formulario e linkar ele com a tela, como o exemplo dos 2
    { //Basta copíar exatamente como está isso daqui apenas mudando os nomes
        //Exemplo
        /*
            GerenciarConsulta.addActionListener(e -> {
                new GerenciamentoConsulta();
            });

            Apenas isso é necessário, apenas irá servir para chamar a tela de consulta no exemplo
         */

        //Telas já criadas
        GerenciarFuncionario.addActionListener(e -> {
            new FuncionarioPrincipal();
        });
        GerenciarMaterial.addActionListener(e -> {
            new MaterialPrincipal();
        });
        GerenciamentoPaciente.addActionListener(e -> {
            new PacientePrincipal();
        });
        GerenciamentoConsulta.addActionListener(e -> {
            new ConsultaPrincipal();
        });
        Prontuarios.addActionListener(e -> {
            new SelecaoProntuario();
        });
        Sair.addActionListener(e -> {
            System.exit(0);
        });
    }
}
