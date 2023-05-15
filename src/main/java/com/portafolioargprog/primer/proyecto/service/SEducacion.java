/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.service;

import com.portafolioargprog.primer.proyecto.entity.Educacion;
import com.portafolioargprog.primer.proyecto.repository.REducacion;
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
public class SEducacion {
    
    @Autowired
    REducacion reducacion;
    
     public List<Educacion> list(){
        return reducacion.findAll();
    }
    
    public Optional<Educacion> getOne(int id){
        return reducacion.findById(id);
    }
    
    public Optional<Educacion> getByTitulo(String titulo){
        return reducacion.findByTitulo(titulo);
    }
    
    public void save(Educacion expe){
        reducacion.save(expe);
    }
    
    public void delete(int id){
        reducacion.deleteById(id);
    }
    
    public boolean existsById(int id){
        return reducacion.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return reducacion.existsByTitulo(titulo);
    }
    
}
