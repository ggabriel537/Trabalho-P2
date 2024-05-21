package com.unigran.br.clinica.Entidades;

import javax.persistence.*;
import java.util.Date;

public class Agendamento {
    @OneToOne
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "dentistaID")
    private Dentista dentista;

    @Temporal(TemporalType.DATE)
    private Date data;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
