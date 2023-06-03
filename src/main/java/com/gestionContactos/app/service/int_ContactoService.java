/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.gestionContactos.app.service;

import com.gestionContactos.app.model.Contacto;
import java.util.List;
import java.util.Optional;

public interface int_ContactoService {

    public Contacto guardar(Contacto contacto);

    public void eliminar(Integer id);

    public Optional<Contacto> obtenerContacto(Integer id);

    public List<Contacto> listarContacto();
}
