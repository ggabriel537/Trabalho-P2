package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Recepcionista;

import java.util.List;

public class RecepcionistaC {
    public static void salvar(Recepcionista r) {
        Dao.salvar(r);
    }

    public static void remover(Recepcionista r) {
        Dao.remove(r);
    }

    public static List<Recepcionista> listar() {
        return Dao.listar("select * from recepcionista r", Recepcionista.class);
    }

    public static void atualizar(Recepcionista novo, Recepcionista old) {
        Dao.atualiza(novo, old);
    }
}
