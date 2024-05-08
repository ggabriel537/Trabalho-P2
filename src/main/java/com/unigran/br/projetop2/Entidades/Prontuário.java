package com.unigran.br.projetop2.Entidades;

import java.util.List;

public class Prontuário {
    private Paciente paciente;
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
