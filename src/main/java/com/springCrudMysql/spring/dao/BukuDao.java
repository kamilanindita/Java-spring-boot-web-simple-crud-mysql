package com.springCrudMysql.spring.dao;

import com.springCrudMysql.spring.model.Buku;
import com.springCrudMysql.spring.services.BukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class BukuDao implements BukuService {
    private EntityManagerFactory emf;

    @Autowired
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public List<Buku> ListBuku() {
        EntityManager em=emf.createEntityManager();
        return em.createQuery("from Buku",Buku.class).getResultList();
    }

    @Override
    public Buku savaOrUpdate(Buku buku) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        Buku saved =em.merge(buku);
        em.getTransaction().commit();
        return saved;
    }

    @Override
    public Buku getIdBuku(Integer id) {
        EntityManager em=emf.createEntityManager();
        return em.find(Buku.class, id);
    }

    @Override
    public void hapus(Integer id) {
        EntityManager em=emf.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Buku.class, id));
        em.getTransaction().commit();
    }
}
