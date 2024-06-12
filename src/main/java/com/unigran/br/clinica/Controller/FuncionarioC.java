package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Funcionario;

import java.util.List;

public class FuncionarioC {
    public static void salvar(Funcionario f) {
        Dao.salvar(f);
    }

    public static void remover(Funcionario f) {
        Dao.remove(f);
    }

    public static List<Funcionario> listar() {
        return Dao.listar("select * from funcionario f", Funcionario.class);
    }
    public static List<Funcionario> listar(int perm) {
        return Dao.listar("select * from funcionario f where permissao = "+perm, Funcionario.class);
    }
    public static void atualizar(Funcionario novo, Funcionario old) {
        Dao.atualiza(novo, old);
    }
}
