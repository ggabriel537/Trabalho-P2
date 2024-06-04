package com.unigran.br.clinica.Entidades;

import javax.persistence.*;

@Entity
public class Dentista extends Funcionario {
    @Id
    @Column(name = "cro")
    private int cro;

    public int getCro() {
        return cro;
    }

    public void setCro(int cro) {
        this.cro = cro;
    }
}
