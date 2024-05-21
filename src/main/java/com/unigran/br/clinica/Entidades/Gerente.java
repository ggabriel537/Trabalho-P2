package com.unigran.br.clinica.Entidades;

import javax.persistence.*;

@Entity
public class Gerente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 32, name = "nome")
    private String nome;
    @OneToOne
    @JoinColumn(name = "loginID")
    private Login login;

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
