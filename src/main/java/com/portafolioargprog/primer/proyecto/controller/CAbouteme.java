/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.controller;

import com.portafolioargprog.primer.proyecto.dto.DtoAboutme;
import com.portafolioargprog.primer.proyecto.entity.Aboutme;
import com.portafolioargprog.primer.proyecto.security.controller.Mensaje;
import com.portafolioargprog.primer.proyecto.service.SAboutme;
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
@RequestMapping("aboutme")
@CrossOrigin(origins = "http://localhost:4200")
public class CAbouteme {
    
    @Autowired
    SAboutme saboutme;
    
    
    @GetMapping("/lista")
    public ResponseEntity<List<Aboutme>> list(){
       List<Aboutme> list = saboutme.list();
       return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!saboutme.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        saboutme.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoAboutme dtoabout){
        if(StringUtils.isBlank(dtoabout.getTitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(saboutme.existsByNombre(dtoabout.getNombre()))
            return new ResponseEntity(new Mensaje("Esa educacion ya existe"), HttpStatus.BAD_REQUEST);
        
        Aboutme aboutme = new Aboutme (dtoabout.getFoto(), dtoabout.getNombre(), dtoabout.getTitulo(), dtoabout.getUbicacion(), dtoabout.getDescripcion());
        saboutme.save(aboutme);
        
        return new ResponseEntity(new Mensaje("Educacion agregada"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoAboutme dtoabout){
        //Validamos si existe el ID
        if(!saboutme.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de experiencias
        if(saboutme.existsByNombre(dtoabout.getNombre()) && saboutme.getByNombre(dtoabout.getNombre()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa Educacion ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtoabout.getTitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Aboutme aboutme = saboutme.getOne(id).get();
        aboutme.setFoto(dtoabout.getFoto());
        aboutme.setNombre(dtoabout.getNombre());
        aboutme.setTitulo(dtoabout.getTitulo());
        aboutme.setUbicacion(dtoabout.getUbicacion());
        aboutme.setDescripcion(dtoabout.getDescripcion());
        
        saboutme.save(aboutme);
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
             
    }
}
