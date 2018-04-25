/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package local.repository;

import local.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author yurin
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
