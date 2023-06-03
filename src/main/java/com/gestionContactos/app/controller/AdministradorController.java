package com.gestionContactos.app.controller;

import com.gestionContactos.app.model.Usuario;
import com.gestionContactos.app.service.int_UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdministradorController {

    @Autowired
    private int_UsuarioService usuarioService;

    @GetMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/autenticacion")
    public String auth(Usuario usuario, HttpSession session, Model model) {
        usuario = usuarioService.obtenerUsuario(usuario.getUser(), usuario.getPass());

        if (usuario == null) {
            return "login";
        }
        session.setAttribute("user", usuario);
        session.setAttribute("idUser", usuario.getId());
        model.addAttribute("user", usuario);
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        // Invalidar la sesión actual
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        // Redirigir a la página de inicio de sesión o a cualquier otra página deseada
        return "redirect:/";
    }

}
