package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Admin;

import java.util.List;

public class AdminC {
    public static void salvar(Admin a)
    {
        Dao.salvar(a);
    }
    public static void remover(Admin a)
    {
        Dao.remove(a);
    }
    public static List<Admin> listar()
    {
        return Dao.listar("select * from admin a", Admin.class);
    }
    public static void atualizar(Admin novo, Admin old)
    {
        Dao.atualiza(novo, old);
    }
}
