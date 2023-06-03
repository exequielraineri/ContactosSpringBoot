/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionContactos.app.controller;

import com.gestionContactos.app.model.Contacto;
import com.gestionContactos.app.model.Usuario;
import com.gestionContactos.app.service.int_ContactoService;
import com.gestionContactos.app.service.int_UsuarioService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Contacto")
public class ContactoController {

    @Autowired
    private int_ContactoService contactoService;

    @Autowired
    private int_UsuarioService usuarioService;

    @GetMapping("")
    public String inicio(Model model, HttpSession session) {

        List<Contacto> contactos = contactoService.listarContacto();
        List<Contacto> listaContactos = new ArrayList<>();
        Usuario usuario = (Usuario) session.getAttribute("user");
        for (int i = 0; i < contactos.size(); i++) {
            if (contactos.get(i).getUsuario().getId() == usuario.getId()) {
                listaContactos.add(contactos.get(i));
            }
        }

        model.addAttribute("listaContactos", listaContactos);
        return "contactos";
    }

    @PostMapping("/guardar")
    public String guardar(Contacto contacto, HttpSession session) {
        contacto.setUsuario((Usuario) session.getAttribute("user"));
        contactoService.guardar(contacto);
        return "redirect:/Contacto";

    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id,Model model) {
        Contacto contacto = new Contacto();
        Optional<Contacto> optionalContacto = contactoService.obtenerContacto(id);
        contacto = optionalContacto.get();
        model.addAttribute("contacto", contacto);
        return "editarContacto";
    }

    
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id){
        contactoService.eliminar(id);
        return "redirect:/Contacto";
    }
    
    
}
