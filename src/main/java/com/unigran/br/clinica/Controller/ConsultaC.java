package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Consulta;

import java.util.List;

public class ConsultaC {
    public static void salvar(Consulta c) {
        Dao.salvar(c);
    }

    public static void remover(Consulta c) {
        Dao.remove(c);
    }

    public static List<Consulta> listar() {
        return Dao.listar("select * from consulta c", Consulta.class);
    }
    public static List<Consulta> listar(String cpf) { return Dao.listar("select * from consulta c where pacienteID like ('"+cpf+"')", Consulta.class); }

    public static void atualizar(Consulta novo, Consulta old) {
        Dao.atualiza(novo, old);
    }
}
