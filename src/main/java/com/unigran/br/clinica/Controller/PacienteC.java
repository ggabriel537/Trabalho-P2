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

    public static void atualizar(Paciente novo, Paciente old) {
        Dao.atualiza(novo, old);
    }
}
