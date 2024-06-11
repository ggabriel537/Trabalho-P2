package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Paciente;

import java.util.List;

public class PacienteC {
    public static void salvar(Paciente p) {
        Dao.salvar(p);
    }

    public static void remover(Paciente p) {
        Dao.remove(p);
    }

    public static List<Paciente> listar() {
        return Dao.listar("select * from paciente p", Paciente.class);
    }
    public static List<Paciente> listar(String where) {
        return Dao.listar("select * from paciente p where nome like ('%"+where+"%')", Paciente.class);
    }

    public static void atualizar(Paciente novo) {
        Dao.atualizaE(novo);
    }
}
