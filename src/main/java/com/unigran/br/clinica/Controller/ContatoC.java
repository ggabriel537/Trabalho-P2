package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Contato;

import java.util.List;

public class ContatoC {
    public static void salvar(Contato c) {
        Dao.salvar(c);
    }

    public static void remover(Contato c) {
        Dao.remove(c);
    }

    public static List<Contato> listar() {
        return Dao.listar("select * from contato c", Contato.class);
    }

    public static void atualizar(Contato novo, Contato old) {
        Dao.atualiza(novo, old);
    }
}
