package com.unigran.br.clinica.Entidades;

import javax.persistence.*;

@Entity
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 64, name = "email")
    private String email;

    @Column(length = 32, name = "contato1")
    private String contato1;

    @Column(length = 32, name = "contato2")
    private String contato2;

    public void removerEmail()
    {
        email = null;
    }

    public void removerContato1()
    {
        contato1 = null;
    }

    public void removerContato2()
    {
        contato2 = null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContato1() {
        return contato1;
    }

    public void setContato1(String contato1) {
        this.contato1 = contato1;
    }

    public String getContato2() {
        return contato2;
    }

    public void setContato2(String contato2) {
        this.contato2 = contato2;
    }
}
