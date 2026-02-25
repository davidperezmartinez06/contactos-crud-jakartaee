package com.miapp.contactos.service;

import com.miapp.contactos.dao.VueloDAO;
import com.miapp.contactos.model.VueloView;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import java.util.List;

@RequestScoped
public class VueloService {

    @Inject
    private VueloDAO vueloDAO;

    public List<VueloView> listarVuelos() {
        return vueloDAO.findAll();
    }
}