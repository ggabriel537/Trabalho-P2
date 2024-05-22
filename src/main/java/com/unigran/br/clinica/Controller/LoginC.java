package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Login;

import java.util.List;

public class LoginC {
    public static void salvar(Login l) {
        Dao.salvar(l);
    }

    public static void remover(Login l) {
        Dao.remove(l);
    }

    public static List<Login> listar() {
        return Dao.listar("select * from login l", Login.class);
    }

    public static void atualizar(Login novo, Login old) {
        Dao.atualiza(novo, old);
    }
}
