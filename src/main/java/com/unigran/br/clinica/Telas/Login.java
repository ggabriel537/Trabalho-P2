package com.unigran.br.clinica.Telas;

import com.unigran.br.clinica.Controller.LoginC;

import javax.swing.*;
import java.util.List;

public class Login {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JTextField User;
    private JPasswordField Senha;
    private JLabel UserL;
    private JLabel SenhaL;
    private JButton Confirmar;
    private JButton Sair;
    private JFrame f;

    public Login() {
        f = new JFrame("Login");
        f.setContentPane(PainelPrincipal);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
            boolean teste = false;
            String usuario = User.getText();
            String senha = Senha.getText();
            List<com.unigran.br.clinica.Entidades.Login> logins = LoginC.listar();

            for (com.unigran.br.clinica.Entidades.Login l : logins)
            {
                if (l.getUsuario().equals(usuario) && l.getSenha().equals(senha))
                {
                    teste = true;
                    new Principal(l.getPerm());
                    break;
                }
            }
            if (!teste)
            {
                JOptionPane.showMessageDialog(null, "Login inválido!");
            }
        });
    }
}
