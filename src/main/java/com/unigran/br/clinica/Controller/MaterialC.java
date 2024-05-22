package com.unigran.br.clinica.Controller;

import com.unigran.br.clinica.DAO.Dao;
import com.unigran.br.clinica.Entidades.Material;

import java.util.List;

public class MaterialC {
    public static void salvar(Material m) {
        Dao.salvar(m);
    }

    public static void remover(Material m) {
        Dao.remove(m);
    }

    public static List<Material> listar() {
        return Dao.listar("select * from material m", Material.class);
    }

    public static void atualizar(Material novo, Material old) {
        Dao.atualiza(novo, old);
    }
}
