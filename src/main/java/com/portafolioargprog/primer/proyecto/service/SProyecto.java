/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.service;

import com.portafolioargprog.primer.proyecto.entity.Proyecto;
import com.portafolioargprog.primer.proyecto.repository.RProyecto;
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
public class SProyecto {
    @Autowired
    RProyecto rproyecto;
    
    public List<Proyecto> list(){
        return rproyecto.findAll();
    }
    
    public Optional<Proyecto> getOne(int id){
        return rproyecto.findById(id);
    }
    
    public Optional<Proyecto> getByTitulo(String titulo){
        return rproyecto.findByTitulo(titulo);
    }
    
    public void save(Proyecto exp){
        rproyecto.save(exp);
    }
    
    public void delete(int id){
        rproyecto.deleteById(id);
    }
    
    public boolean existsById(int id){
         return rproyecto.existsById(id);
     }
     
     public boolean existsByTitulo(String titulo){
         return rproyecto.existsByTitulo(titulo);
     }
}
