/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.service;

import com.portafolioargprog.primer.proyecto.entity.Red;
import com.portafolioargprog.primer.proyecto.repository.RRed;
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
public class SRed {
    @Autowired
    RRed rred;
    
    public List<Red> list(){
        return rred.findAll();
    }
    
    public Optional<Red> getOne(int id){
        return rred.findById(id);
    }
    
    public Optional<Red> getByNombre(String nombre){
        return rred.findByNombre(nombre);
    }
    
    public void save(Red exp){
        rred.save(exp);
    }
    
    public void delete(int id){
        rred.deleteById(id);
    }
    
    public boolean existsById(int id){
         return rred.existsById(id);
     }
     
     public boolean existsByNombre(String nombre){
         return rred.existsByNombre(nombre);
    }
}
