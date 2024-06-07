package com.unigran.br.clinica.Telas.GMaterial;

import com.unigran.br.clinica.Controller.MaterialC;
import com.unigran.br.clinica.Entidades.Material;

import javax.swing.*;

public class EdicaoMaterial {
    private JPanel PainelPrincipal;
    private JPanel Labels;
    private JPanel Botoes;
    private JPanel Campos;
    private JLabel GerenciamentoL;
    private JButton Confirmar;
    private JButton Sair;
    private JLabel EdicaoL;
    private JTextArea Quantidade;
    private JTextArea Minimo;
    private JLabel QuantidadeL;
    private JLabel MinimoL;
    private JTextField Material;
    private JFrame f;
    private Material mat = new Material();

    public EdicaoMaterial(Material mat) {
        this.mat = mat;
        f = new JFrame("Edição de Material");
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
    }

    private void configuracoes()
    {
        String nome = mat.getNome();
        int quantidade = mat.getQuantidade();
        int minimo = mat.getMinimo();
        Material.setText(nome);
        Quantidade.setText(String.valueOf(quantidade));
        Minimo.setText(String.valueOf(minimo));
    }

    private void cadastrar()
    {
        boolean teste = false;
        String erros = "";
        int quantidade = 0;
        int minimo = 0;
        try {
            minimo = Integer.parseInt(Minimo.getText());
            quantidade = Integer.parseInt(Quantidade.getText());
        }catch (Exception e)
        {
            teste = true;
            erros += "Quantidade inválida!\n";
        }
        if (teste)
        {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!\n"+erros);
        }else{
            com.unigran.br.clinica.Entidades.Material m = new Material();
            m.setNome(mat.getNome());
            m.setQuantidade(quantidade);
            m.setMinimo(minimo);
            try{
                f.dispose();
                JOptionPane.showMessageDialog(null, "Item salvo!");
                MaterialC.atualizar(m, mat);
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "Erro ao salvar!\n"+e.getMessage());
            }

        }
    }
}
