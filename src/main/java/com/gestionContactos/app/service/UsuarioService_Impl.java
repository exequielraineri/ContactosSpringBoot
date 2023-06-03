/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gestionContactos.app.service;

import com.gestionContactos.app.model.Usuario;
import com.gestionContactos.app.repository.int_UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService_Impl implements int_UsuarioService {

    @Autowired
    private int_UsuarioRepository usuarioRepo;

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @Override
    public void eliminar(Integer id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Optional<Usuario> obtenerUsuario(Integer id) {
        return usuarioRepo.findById(id);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public Usuario obtenerUsuario(String user, String pass) {
        List<Usuario> usuarios = usuarioRepo.findAll();
        Usuario u = new Usuario();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getUser().equals(user) && usuarios.get(i).getPass().equals(pass)) {
                u = usuarios.get(i);
            }
        }
        if (u.getNombre() == null || u.getNombre().equals("")) {
            return null;
        }

        return u;
    }

}
