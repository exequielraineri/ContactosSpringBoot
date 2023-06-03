/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionContactos.app.service;

import com.gestionContactos.app.model.Contacto;
import com.gestionContactos.app.repository.int_ContactoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactoService_Impl implements int_ContactoService{

    @Autowired
    private int_ContactoRepository contactoDAO;
    
    @Override
    public Contacto guardar(Contacto contacto) {
        return contactoDAO.save(contacto);
    }

    @Override
    public void eliminar(Integer id) {
        contactoDAO.deleteById(id);
    }

    @Override
    public Optional<Contacto> obtenerContacto(Integer id) {
        return contactoDAO.findById(id);
    }

    @Override
    public List<Contacto> listarContacto() {
        return contactoDAO.findAll();
        
    }
    
}
