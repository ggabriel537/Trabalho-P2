package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Funcionario;

import java.util.List;

public class DentistaC extends Funcionario {
    public static List<Funcionario> listar() {
        return Dao.listar("select * from funcionario f where permissao = 2", Funcionario.class);
    }
}
