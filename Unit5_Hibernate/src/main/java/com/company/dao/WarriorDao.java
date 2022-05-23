package com.company.dao;

import com.company.entity.Warrior;
import com.company.util.EmfUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class WarriorDao {
    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

    public Warrior findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        return em.find(Warrior.class, id);
    }

    public Warrior save(Warrior w) {
        EntityManager em = emf.createEntityManager();
        Warrior newInstance;
        em.getTransaction().begin();
        if (w.getId() == null) {
            em.persist(w);
            newInstance = w;
        } else {
            newInstance = em.merge(w);
        }
        em.getTransaction().commit();
        return newInstance;
    }
}
