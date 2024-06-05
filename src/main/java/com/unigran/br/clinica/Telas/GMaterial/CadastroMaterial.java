package com.unigran.br.clinica.Telas.GMaterial;

import com.unigran.br.clinica.Controller.MaterialC;
import com.unigran.br.clinica.Entidades.Material;

import javax.swing.*;

public class CadastroMaterial {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Campos;
    private JPanel Botoes;
    private JLabel MaterialL;
    private JTextField Quantidade;
    private JTextField Minimo;
    private JTextField Nome;
    private JButton Confirmar;
    private JButton Sair;
    private JLabel NomeL;
    private JLabel QuantidadeL;
    private JLabel MinimoL;
    private JFrame f;

    public CadastroMaterial() {
        f = new JFrame("Cadastro Material");
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
        Confirmar.addActionListener(e -> {
            cadastrar();
        });
    }

    private void cadastrar()
    {
        boolean teste = false;
        String erros = "";
        int quantidade = 0;
        int minimo = 0;
        String nome = Nome.getText();
        try {
            minimo = Integer.parseInt(Minimo.getText());
            quantidade = Integer.parseInt(Quantidade.getText());
        }catch (Exception e)
        {
            teste = true;
            erros += "Quantidade inválida!\n";
        }
        if (nome.isEmpty())
        {
            erros += "Nome inválido!\n";
            teste = true;
        }
        if (teste)
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!\n"+erros);
        }else{
            Material m = new Material();
            m.setNome(nome);
            m.setQuantidade(quantidade);
            m.setMinimo(minimo);
            try{
                f.dispose();
                JOptionPane.showMessageDialog(null, "Item salvo!");
                MaterialC.salvar(m);
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!\n"+e.getMessage());
            }

        }
    }
}
