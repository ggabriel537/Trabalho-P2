package com.unigran.br.clinica.Entidades;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class Dentista {
    @Id
    @Column(name = "cro")
    private int cro;
    @Column(length = 32, name = "nome")
    private String nome;
    @OneToOne
    @JoinColumn(name = "loginID")
    private Login login;

    public int getCro() {
        return cro;
    }

    public void setCro(int cro) {
        this.cro = cro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
