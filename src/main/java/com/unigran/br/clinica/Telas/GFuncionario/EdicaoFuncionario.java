package com.unigran.br.clinica.Telas.GFuncionario;

import com.unigran.br.clinica.Controller.FuncionarioC;
import com.unigran.br.clinica.Entidades.Funcionario;
import com.unigran.br.clinica.Entidades.Login;

import javax.swing.*;

public class EdicaoFuncionario {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel EdicaoL;
    private JButton Confirmar;
    private JButton Sair;
    private JTextField Nome;
    private JTextField Usuario;
    private JPasswordField Senha;
    private JComboBox Permissoes;
    private JLabel NomeL;
    private JLabel UserL;
    private JLabel SenhaL;
    private JLabel PermissaoL;
    private JLabel CROL;
    private JTextField CRO;
    private JFrame f;
    private Funcionario fun;

    public EdicaoFuncionario(Funcionario fun) {
        this.fun = fun;
        f = new JFrame("Edição de Funcionário");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
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
        Permissoes.addActionListener(e -> {
            if (Permissoes.getSelectedIndex()==1)
            {
                CRO.setEditable(true);
            }else{
                CRO.setText("");
                CRO.setEditable(false);
            }
        });
    }

    private void configuracoes()
    {
        String senha = fun.getLogin().getSenha();
        String usuario = fun.getLogin().getUsuario();
        String nome = fun.getNome();
        int cro = fun.getCro();
        int permissao = fun.getPermissao();
        Senha.setText(senha);
        Usuario.setText(usuario);
        Nome.setText(nome);
        CRO.setText(String.valueOf(cro));
        Permissoes.setSelectedIndex(permissao);
    }

    private void cadastrar()
    {
        boolean teste = false;
        String erros = "";
        int cro = 0;
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
                cro = Integer.parseInt(CRO.getText());
            }catch (Exception e)
            {
                teste= true;
                erros += "Digite um número válido!\n";
            }
        }
        if(teste)
        {
            JOptionPane.showMessageDialog(null, "Campos com erros!\n"+erros);
        }else{
            Funcionario f = new Funcionario();
            Login l = new Login();
            f.setNome(nomeC);
            f.setPermissao(permissaoC);
            f.setCro(cro);
            l.setPerm(permissaoC);
            l.setSenha(senhaC);
            l.setUsuario(usuarioC);
            f.setLogin(l);
            try{
                FuncionarioC.atualizar(fun, f);
                this.f.dispose();
                JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!\n"+e.getMessage());
            }
        }
    }
}
