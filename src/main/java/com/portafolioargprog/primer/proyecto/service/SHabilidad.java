/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.service;

import com.portafolioargprog.primer.proyecto.entity.Habilidad;
import com.portafolioargprog.primer.proyecto.repository.RHabilidad;
import jakarta.transaction.Transactional;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author Fran
 */
@Transactional
@Service
public class SHabilidad {
    @Autowired
    RHabilidad rhabilidad;
    
    
    public List<Habilidad> list(){
        return rhabilidad.findAll();
    }
    
    public Optional<Habilidad> getOne(int id){
        return rhabilidad.findById(id);
    }
    
    public Optional<Habilidad> getByNombre(String nombre){
        return rhabilidad.findByNombre(nombre);
    }
    
    public void save(Habilidad skill){
        rhabilidad.save(skill);
    }
    
    public void delete(int id){
        rhabilidad.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rhabilidad.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return rhabilidad.existsByNombre(nombre);
    }

}
