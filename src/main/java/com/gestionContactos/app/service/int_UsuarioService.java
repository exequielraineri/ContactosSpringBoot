package com.gestionContactos.app.service;

import com.gestionContactos.app.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface int_UsuarioService {

    public Usuario guardar(Usuario usuario);
    
    public void eliminar(Integer id);
    
    public Optional<Usuario> obtenerUsuario(Integer id);
    
    public List<Usuario> listarUsuarios();
    
    public Usuario obtenerUsuario(String user, String pass);
    
    
}
