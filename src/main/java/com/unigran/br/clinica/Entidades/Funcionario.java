package com.unigran.br.clinica.Entidades;

import javax.persistence.*;

@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 32, name = "nome")
    private String nome;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "loginID")
    private Login login;

    @Column(name = "permissao")
    private int permissao;

    @Column(name = "cro")
    private int cro;

    public int getCro() {
        return cro;
    }

    public void setCro(int cro) {
        this.cro = cro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}
