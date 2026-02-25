package com.miapp.contactos.dao;
import com.miapp.contactos.model.VueloView;
import java.util.List;

public interface VueloDAO {
    List<VueloView> findAll();
}