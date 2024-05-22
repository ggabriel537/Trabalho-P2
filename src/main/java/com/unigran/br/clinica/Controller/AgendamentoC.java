package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Agendamento;

import java.util.List;

public class AgendamentoC {
    public static void salvar(Agendamento a) {
        Dao.salvar(a);
    }

    public static void remover(Agendamento a) {
        Dao.remove(a);
    }

    public static List<Agendamento> listar() {
        return Dao.listar("select * from agendamento a", Agendamento.class);
    }

    public static void atualizar(Agendamento novo, Agendamento old) {
        Dao.atualiza(novo, old);
    }
}
