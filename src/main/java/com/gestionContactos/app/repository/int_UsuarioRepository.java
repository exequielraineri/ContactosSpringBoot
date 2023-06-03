
package com.gestionContactos.app.repository;

import com.gestionContactos.app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface int_UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
