package com.unigran.br.clinica.Entidades;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Paciente {
    @Column(length = 32, name = "nome")
    private String nome;
    @Id
    @Column(length = 11, name = "cpf")
    private String cpf;
    @Temporal(TemporalType.DATE)
    @Column(name = "nascimento")
    private Date nascimento;
    @Column(length = 64, name = "endereco")
    private String endereco;
    @Column(length = 64, name = "convenio")
    private String convenio;
    @OneToOne
    @Column(name = "contatoID")
    private Contato contato;
    @Column(length = 32, name = "responsavel")
    private String responsavel;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getConvenio() {
        return convenio;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
