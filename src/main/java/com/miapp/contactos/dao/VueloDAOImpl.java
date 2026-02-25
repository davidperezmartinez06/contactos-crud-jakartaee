package com.miapp.contactos.dao;

import com.miapp.contactos.model.VueloView;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@RequestScoped
public class VueloDAOImpl implements VueloDAO {

    @PersistenceContext(unitName = "vuelosPU")
    private EntityManager em;

    @Override
    public List<VueloView> findAll() {
        return em.createQuery("SELECT v FROM VueloView v", VueloView.class).getResultList();
    }
}