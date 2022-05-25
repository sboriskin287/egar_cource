package com.company.dao;

import com.company.entity.Mage;
import com.company.util.EmfUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class MageDao {
    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

    public Optional<Mage> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Mage res = em.find(Mage.class, id);
        return Optional.ofNullable(res);
    }

    public List<Mage> findByTasksNotEmpty() {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Mage> q = em.createNamedQuery(
                "exists_tasks_query",
                Mage.class);
        return q.getResultList();
    }

    public List<Mage> findByHealthGreatherThen(Float health) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<Mage> q = em.createNamedQuery(
                "health_more",
                Mage.class);
        q.setParameter("health", health);
        return q.getResultList();
    }
}
