package com.gestionContactos.app.controller;

import com.gestionContactos.app.model.Usuario;
import com.gestionContactos.app.service.int_UsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/Usuario")
public class UsuarioController {

    @Autowired
    private int_UsuarioService usuarioService;

    @GetMapping("")
    public String listar(Model model) {
        List<Usuario> usuarios = usuarioService.listarUsuarios();
        model.addAttribute("usuarios", usuarios);
        return "usuario";
    }

    @GetMapping("/inicio")
    public String inicio() {
       
        return "index";
    }

}
