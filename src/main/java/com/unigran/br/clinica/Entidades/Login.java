package com.unigran.br.clinica.Entidades;

import javax.persistence.*;

@Entity
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 16, name = "user")
    private String user;

    @Column(length = 16, name = "senha")
    private String senha;

    @Column(name = "permissao")
    private int perm;

    public int getPerm() {
        return perm;
    }

    public void setPerm(int perm) {
        this.perm = perm;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
