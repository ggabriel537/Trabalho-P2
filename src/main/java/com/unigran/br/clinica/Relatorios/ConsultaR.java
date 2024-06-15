package com.unigran.br.clinica.Relatorios;

import com.unigran.br.clinica.Outros.Horario;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Date;

public class ConsultaR {
    private File f;
    private String dados;
    public ConsultaR() {
        f = new File("Relatorio Consultas - " + Horario.getHora() + ".txt");
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        gerarDados();
    }

    public void gerarDados() {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "senhaboa1";

        StringBuilder relatorio = new StringBuilder();

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT c.id, c.anexos, c.data, c.observacoes, c.status, c.valor, " +
                    "f.nome AS nome_dentista, " +
                    "p.nome AS nome_paciente " +
                    "FROM consulta c " +
                    "LEFT JOIN funcionario f ON c.dentistaid = f.id " +
                    "LEFT JOIN paciente p ON c.pacienteid = p.id";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            relatorio.append("Relatório de Consultas:\n");
            relatorio.append(String.format("%-5s %-10s %-12s %-20s %-12s %-10s %-20s %-20s\n",
                    "ID", "Anexos", "Data", "Observações", "Status", "Valor", "Dentista", "Paciente"));
            relatorio.append("---------------------------------------------------------------------------------\n");

            while (rs.next()) {
                int id = rs.getInt("id");
                String anexos = rs.getString("anexos");
                Date data = rs.getDate("data");
                String observacoes = rs.getString("observacoes");
                int status = rs.getInt("status");
                double valor = rs.getDouble("valor");
                String nomeDentista = rs.getString("nome_dentista");
                String nomePaciente = rs.getString("nome_paciente");

                String statusFormatado = getStatusFormatado(status);

                relatorio.append(String.format("%-5d %-10s %-12s %-20s %-12s %-10.2f %-20s %-20s\n",
                        id, anexos, formatarData(data), observacoes, statusFormatado, valor, nomeDentista, nomePaciente));
            }

            dados = relatorio.toString();
            gravarDados();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private String getStatusFormatado(int status) {
        switch (status) {
            case 1:
                return "Agendado";
            case 2:
                return "Concluído";
            default:
                return "Desconhecido";
        }
    }

    private String formatarData(Date data) {
        if (data == null) {
            return "Data desconhecida";
        } else {
            return new java.text.SimpleDateFormat("dd/MM/yyyy").format(data);
        }
    }

    public void gravarDados() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(f))) {
            writer.print(dados);
            JOptionPane.showMessageDialog(null, "Relatório gravado com sucesso no arquivo: " + f.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
