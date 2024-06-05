package com.unigran.br.clinica.Telas.GFuncionario;

import com.unigran.br.clinica.Controller.FuncionarioC;
import com.unigran.br.clinica.Entidades.Funcionario;
import com.unigran.br.clinica.Entidades.Login;

import javax.swing.*;

public class CadastroFuncionario {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JLabel CadastroL;
    private JTextField Nome;
    private JTextField Usuario;
    private JTextField Senha;
    private JComboBox Permissoes;
    private JButton Confirmar;
    private JButton Sair;
    private JLabel NomeL;
    private JLabel UsuarioL;
    private JLabel SenhaL;
    private JLabel PermissaoL;
    private JLabel CROL;
    private JTextField CRO;
    private JFrame f;

    public CadastroFuncionario() {
        f = new JFrame("Cadastro de Funcionário");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();
        CRO.setEditable(false);
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
        Permissoes.addActionListener(e -> {
            if (Permissoes.getSelectedIndex()==2)
            {
                CRO.setEditable(true);
            }else{
                CRO.setEditable(false);
            }
        });
    }

    private void cadastrar()
    {
        boolean teste = false;
        String erros = "";
        String cro;
        String nomeC = Nome.getText();
        String usuarioC = Usuario.getText();
        String senhaC = Senha.getText();
        int permissaoC = Permissoes.getSelectedIndex();

        if (nomeC.isEmpty())
        {
            teste = true;
            erros += "Digite um nome!\n";
        }
        if (usuarioC.isEmpty())
        {
            teste = true;
            erros += "Digite um usuário!\n";
        }
        if (senhaC.isEmpty())
        {
            teste = true;
            erros += "Digite uma senha!\n";
        }
        if (!CRO.getText().isEmpty())
        {
            try{
                cro = CRO.getText();
            }catch (Exception e)
            {
                erros += "Digite um número válido!\n";
            }
        }
        if(teste)
        {
            JOptionPane.showMessageDialog(null, "Campos não preenchidos\n"+erros);
        }else{
            Funcionario f = new Funcionario();
            Login l = new Login();
            f.setNome(nomeC);
            f.setPermissao(permissaoC);
            l.setPerm(permissaoC);
            l.setSenha(senhaC);
            l.setUsuario(usuarioC);
            f.setLogin(l);
            f.getCro();
            FuncionarioC.salvar(f);
        }
    }
}
