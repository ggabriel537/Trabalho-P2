package com.unigran.br.clinica.Entidades;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
