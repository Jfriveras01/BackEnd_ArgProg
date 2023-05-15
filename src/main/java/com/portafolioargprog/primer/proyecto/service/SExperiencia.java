/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.service;

import com.portafolioargprog.primer.proyecto.entity.Experiencia;
import com.portafolioargprog.primer.proyecto.repository.RExperiencia;
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
public class SExperiencia {
    
    @Autowired
    RExperiencia rexperiencia;
    
    public List<Experiencia> list(){
        return rexperiencia.findAll();
    }
    
    public Optional<Experiencia> getOne(int id){
        return rexperiencia.findById(id);
    }
    
    public Optional<Experiencia> getByTitulo(String titulo){
        return rexperiencia.findByTitulo(titulo);
    }
    
    public void save(Experiencia expe){
        rexperiencia.save(expe);
    }
    
    public void delete(int id){
        rexperiencia.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rexperiencia.existsById(id);
    }
    
    public boolean existsByTitulo(String titulo){
        return rexperiencia.existsByTitulo(titulo);
    }

}
