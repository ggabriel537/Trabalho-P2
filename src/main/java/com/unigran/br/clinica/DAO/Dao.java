package com.unigran.br.clinica.DAO;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Dao {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.unigran.br_clinica_jar_1.0-SNAPSHOTPU");
    private static EntityManager em = emf.createEntityManager();
    private static EntityTransaction etx = em.getTransaction();

    public static void salvar(Object o) {
        etx.begin();
        em.persist(o);
        etx.commit();
    }

    public static void atualiza(Object o, Object old) {
        if (!em.contains(old)) {
            old = em.merge(old);
        }
        etx.begin();
        em.remove(old);
        em.persist(o);
        etx.commit();
    }
    public static void atualizaE(Object o) {
        etx.begin();
        em.merge(o);
        etx.commit();
    }

    public static void remove(Object o) {
        if (!em.contains(o)) {
            o = em.merge(o);
        }
        etx.begin();
        em.remove(o);
        etx.commit();
    }

    public static List listar(String query, Class c) {
        return em.createNativeQuery(query, c).getResultList();
    }
}
