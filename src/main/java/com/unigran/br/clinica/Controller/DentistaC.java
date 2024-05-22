package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Dentista;

import java.util.List;

public class DentistaC {
    public static void salvar(Dentista d) {
        Dao.salvar(d);
    }

    public static void remover(Dentista d) {
        Dao.remove(d);
    }

    public static List<Dentista> listar() {
        return Dao.listar("select * from dentista d", Dentista.class);
    }

    public static void atualizar(Dentista novo, Dentista old) {
        Dao.atualiza(novo, old);
    }
}
