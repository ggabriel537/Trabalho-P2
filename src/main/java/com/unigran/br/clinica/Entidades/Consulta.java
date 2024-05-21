package com.unigran.br.clinica.Entidades;

import javax.persistence.*;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    @OneToMany
    @JoinColumn(name = "dentistaID")
    private Dentista dentista;

    @Column(length = 512, name = "observacoes")
    private String observacoes;
    @Column(length = 512)
    private String anexos; //Alterado para String pois iremos armazenar apenas o local onde está o arquivo no banco

    @Column(name = "valor")
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

    public String getAnexos() {
        return anexos;
    }

    public void setAnexos(String anexos) {
        this.anexos = anexos;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
