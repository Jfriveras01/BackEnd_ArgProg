/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.security.repository;

import com.portafolioargprog.primer.proyecto.security.enums.RolNombre;
import com.portafolioargprog.primer.proyecto.security.entity.Rol;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fran
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
        Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
