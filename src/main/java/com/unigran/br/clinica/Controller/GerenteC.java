package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Gerente;

import java.util.List;

public class GerenteC {
    public static void salvar(Gerente g) {
        Dao.salvar(g);
    }

    public static void remover(Gerente g) {
        Dao.remove(g);
    }

    public static List<Gerente> listar() {
        return Dao.listar("select * from gerente g", Gerente.class);
    }

    public static void atualizar(Gerente novo, Gerente old) {
        Dao.atualiza(novo, old);
    }
}
