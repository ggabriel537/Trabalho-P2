package com.unigran.br.clinica.Entidades;

import javax.persistence.*;
import java.util.List;

public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = )
    private List<Consulta> historico;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public List<Consulta> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Consulta> historico) {
        this.historico = historico;
    }
}
