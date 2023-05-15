/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.service;

import com.portafolioargprog.primer.proyecto.entity.Aboutme;
import com.portafolioargprog.primer.proyecto.repository.RAboutme;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
@Transactional
public class SAboutme {
    
    @Autowired
    RAboutme raboutme;
    
    public List<Aboutme> list(){
        return raboutme.findAll();
    }
    
    public Optional<Aboutme> getOne(int id){
        return raboutme.findById(id);
    }
    
    public Optional<Aboutme> getByNombre(String nombre){
        return raboutme.findByNombre(nombre);
    }
    
    public void save(Aboutme skill){
        raboutme.save(skill);
    }
    
    public void delete(int id){
        raboutme.deleteById(id);
    }
    
    public boolean existsById(int id){
        return raboutme.existsById(id);
    }
    
    public boolean existsByNombre(String nombre){
        return raboutme.existsByNombre(nombre);
    }
    
}
