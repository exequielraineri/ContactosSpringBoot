
package com.gestionContactos.app.repository;

import com.gestionContactos.app.model.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface int_ContactoRepository extends JpaRepository<Contacto, Integer>{
   
}
