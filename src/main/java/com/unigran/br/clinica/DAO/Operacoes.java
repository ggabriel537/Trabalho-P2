package com.unigran.br.clinica.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Operacoes {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.unigran.br_clinica_jar_1.0-SNAPSHOTPU");
    EntityManager em = emf.createEntityManager();
    EntityTransaction etx = em.getTransaction();

    public void salvar(Object o) {
        etx.begin();
        em.persist(o);
        etx.commit();
    }

    public void atualiza(Object o, Object old) {
        if (!em.contains(old)) {
            old = em.merge(old);
        }
        etx.begin();
        em.remove(old);
        em.merge(o);
        etx.commit();
    }

    public void remove(Object o) {
        if (!em.contains(o)) {
            o = em.merge(o);
        }
        etx.begin();
        em.remove(o);
        etx.commit();
    }

    public List listar() {
        return null;
    }

    public Object get(int esc)
    {
        List objetos = listar();
        return objetos.get(esc);
    }
}
