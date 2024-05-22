package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Prontuario;

import java.util.List;

public class ProntuarioC {
    public static void salvar(Prontuario p) {
        Dao.salvar(p);
    }

    public static void remover(Prontuario p) {
        Dao.remove(p);
    }

    public static List<Prontuario> listar() {
        return Dao.listar("select * from prontuario p", Prontuario.class);
    }

    public static void atualizar(Prontuario novo, Prontuario old) {
        Dao.atualiza(novo, old);
    }
}
