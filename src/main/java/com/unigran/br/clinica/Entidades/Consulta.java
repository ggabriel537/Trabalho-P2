package com.unigran.br.clinica.Entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "status")
    private int status;
    @OneToOne
    @JoinColumn(name = "pacienteID")
    private Paciente paciente;

    @OneToOne
    @JoinColumn(name = "dentistaID")
    private Funcionario dentista;

    @Column(length = 512, name = "observacoes")
    private String observacoes;

    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date dataconsulta;
    @Column(length = 512)
    private String anexos; //Alterado para String pois iremos armazenar apenas o local onde está o arquivo no banco

    @Column(name = "valor")
    private double valor;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Funcionario getDentista() {
        return dentista;
    }

    public void setDentista(Funcionario dentista) {
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

    public Date getDataconsulta() {
        return dataconsulta;
    }

    public void setDataconsulta(Date dataconsulta) {
        this.dataconsulta = dataconsulta;
    }
}
