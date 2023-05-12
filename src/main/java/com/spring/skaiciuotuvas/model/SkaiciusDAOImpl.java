package com.spring.skaiciuotuvas.model;

import com.spring.skaiciuotuvas.config.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import java.util.List;

public class SkaiciusDAOImpl implements SkaiciusDAO {

    @Override
    public void create(Skaicius skaicius) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // Pagal perduotą objektą sukuriamas naujas įrašas DB lentelėje
        entityManager.persist(skaicius);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Skaicius> readAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        List<Skaicius> skaiciai = entityManager
                // ORM modelyje klasės objektai atitinka lentelės įrašys DB
                .createQuery("SELECT s FROM Skaicius s")
                .getResultList(); // Jokio ResultSet!

        entityManager.getTransaction().commit();
        entityManager.close();

        return skaiciai;
    }

    @Override
    public Skaicius read(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        // Ieškant įrašo DB reikia nurodyti Entity klasę
        Skaicius skaicius = entityManager.find(Skaicius.class, id);

        entityManager.getTransaction().commit();
        entityManager.close();

        return skaicius;
    }

    @Override
    public void update(Skaicius skaicius) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Skaicius skaicius2 = entityManager.find(Skaicius.class, skaicius.getId());
        skaicius2.setSk1(skaicius.getSk1());
        skaicius2.setSk2(skaicius.getSk2());
        skaicius2.setZenklas(skaicius.getZenklas());
        skaicius2.setRezultatas(skaicius.getRezultatas());

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void delete(int id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Skaicius skaicius = entityManager.find(Skaicius.class, id);
        entityManager.remove(skaicius);

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
