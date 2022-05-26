package com.company.dao;

import com.company.entity.Hero;
import com.company.entity.Mage;
import com.company.entity.Warrior;
import com.company.util.EmfUtil;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Subgraph;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MageDao {
    private EntityManagerFactory emf = EmfUtil.entityManagerFactory();

    public Optional<Mage> findById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Mage res = em.find(Mage.class, id);
        return Optional.ofNullable(res);
    }

    /*public List<Mage> findByTasksNotEmpty() {
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
    }*/

    public Optional<Mage> findByIdWithHero(Integer id) {
        EntityManager em = emf.createEntityManager();
        EntityGraph<Mage> g = em.createEntityGraph(Mage.class);
        Subgraph<Hero> hd = g.addSubgraph("hero");
        g.addAttributeNodes("hero");
        hd.addAttributeNodes("tasks");
        Map<String, Object> p = new HashMap<>();
        p.put("javax.persistence.fetchgraph", g);
        Mage res = em.find(Mage.class, id, p);
        return Optional.ofNullable(res);
    }

    public Mage save(Mage m) {
        EntityManager em = emf.createEntityManager();
        Mage newInstance;
        em.getTransaction().begin();
        if (m.getId() == null) {
            em.persist(m);
            newInstance = m;
        } else {
            newInstance = em.merge(m);
        }
        em.getTransaction().commit();
        return newInstance;
    }

    public List<Mage> findByNameAndHealthAndDamage() {
        EntityManager em = emf.createEntityManager();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Mage> q = cb.createQuery(Mage.class);
        Root<Mage> root = q.from(Mage.class);
        Join<Mage, Hero> j = root.join("hero");
        Predicate p = cb.and(
                cb.like(j.get("name"), ""),
                cb.greaterThan(j.get("health"), 100));
        q.where(p);
        return em.createQuery(q).getResultList();
    }
}
