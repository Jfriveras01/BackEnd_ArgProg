/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.repository;

import com.portafolioargprog.primer.proyecto.entity.Habilidadh;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Fran
 */
public interface RHabilidadh extends JpaRepository<Habilidadh, Integer>{
    Optional<Habilidadh> findByNombre(String nombre);
    public boolean existsByNombre(String nombre);
}
