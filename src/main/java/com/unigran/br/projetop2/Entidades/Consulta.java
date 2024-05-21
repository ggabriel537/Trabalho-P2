package com.unigran.br.projetop2.Entidades;

import java.io.File;

import java.io.File;

public class Consulta {
    private Paciente paciente;
    private Dentista dentista;
    private String observacoes;
    private File anexos;
    private double valor;

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

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public File getAnexos() {
        return anexos;
    }

    public void setAnexos(File anexos) {
        this.anexos = anexos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
