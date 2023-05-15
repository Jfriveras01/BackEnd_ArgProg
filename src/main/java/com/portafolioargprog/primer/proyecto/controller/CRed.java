/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.controller;

import com.portafolioargprog.primer.proyecto.dto.DtoRed;
import com.portafolioargprog.primer.proyecto.entity.Red;
import com.portafolioargprog.primer.proyecto.security.controller.Mensaje;
import com.portafolioargprog.primer.proyecto.service.SRed;
import io.micrometer.common.util.StringUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fran
 */
@RestController
@RequestMapping("red")
@CrossOrigin(origins = "http://localhost:4200")
public class CRed {
    @Autowired
    SRed sRed;
    
    @GetMapping("/lista")
   public ResponseEntity<List<Red>> list(){
        List<Red> list = sRed.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    //Not used in front end
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoRed dtored){      
        if(StringUtils.isBlank(dtored.getNombre()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sRed.existsByNombre(dtored.getNombre()))
            return new ResponseEntity(new Mensaje("Este red existe"), HttpStatus.BAD_REQUEST);
        
        Red red = new Red(dtored.getNombre(), dtored.getUrl(),dtored.getIcon());
        sRed.save(red);
        
        return new ResponseEntity(new Mensaje("Red agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoRed dtored){
        //Validamos si existe el ID
        if(!sRed.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de reds
        if(sRed.existsByNombre(dtored.getNombre()) && sRed.getByNombre(dtored.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa red ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtored.getNombre()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Red red = sRed.getOne(id).get();
        red.setNombre(dtored.getNombre());
        red.setUrl(dtored.getUrl());
        red.setIcon(dtored.getIcon());
        
        sRed.save(red);
        return new ResponseEntity(new Mensaje("Red actualizada"), HttpStatus.OK);
             
    }
    
    //Not used in front end
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sRed.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sRed.delete(id);
        return new ResponseEntity(new Mensaje("red eliminado"), HttpStatus.OK);
    }
}