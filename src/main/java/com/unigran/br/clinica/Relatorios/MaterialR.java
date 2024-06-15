package com.unigran.br.clinica.Relatorios;

import com.unigran.br.clinica.Outros.Horario;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class MaterialR {
    private File f;
    private String dados;

    public MaterialR() {
        f = new File("Relatorio Material - "+Horario.getHora()+".txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gerarDados();
    }

    public void gerarDados()
    {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "senhaboa1";

        StringBuilder relatorio = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT nome, quantidade, minimo FROM material";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            boolean precisaComprar = false;

            relatorio.append("Relatório de Materiais:\n");
            relatorio.append(String.format("%-20s %-10s %-10s\n", "Nome", "Quantidade", "Mínimo"));
            relatorio.append("--------------------------------------------------\n");

            while (rs.next()) {
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                int minimo = rs.getInt("minimo");

                relatorio.append(String.format("%-20s %-10d %-10d\n", nome, quantidade, minimo));

                if (quantidade < minimo) {
                    precisaComprar = true;
                }
            }

            if (precisaComprar) {
                relatorio.append("\nÉ necessário comprar materiais com quantidade abaixo do mínimo.\n");
            } else {
                relatorio.append("\nTodos os materiais estão com quantidade acima do mínimo.\n");
            }
            dados = relatorio.toString();
            gravarDados();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gravarDados()
    {
        try (PrintWriter writer = new PrintWriter(new FileWriter(f))) {
            writer.print(dados);
            JOptionPane.showMessageDialog(null, "Relatório gravado com sucesso no arquivo: " + f.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
