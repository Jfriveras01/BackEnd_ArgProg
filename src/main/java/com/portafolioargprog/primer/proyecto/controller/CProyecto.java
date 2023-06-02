/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.controller;

import com.portafolioargprog.primer.proyecto.dto.DtoProyecto;
import com.portafolioargprog.primer.proyecto.entity.Proyecto;
import com.portafolioargprog.primer.proyecto.security.controller.Mensaje;
import com.portafolioargprog.primer.proyecto.service.SProyecto;
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
@RequestMapping("proyectos")
@CrossOrigin(origins = "https://front-end-argprograma.web.app")
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody DtoProyecto dtopro){      
        if(StringUtils.isBlank(dtopro.getTitulo()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(sProyecto.existsByTitulo(dtopro.getTitulo()))
            return new ResponseEntity(new Mensaje("Este proyecto existe"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = new Proyecto(dtopro.getUrl(),dtopro.getPortada(),dtopro.getTitulo(),dtopro.getDescripcion());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Proyecto agregado"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody DtoProyecto dtopro){
        //Validamos si existe el ID
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        //Compara nombre de proyectos
        if(sProyecto.existsByTitulo(dtopro.getTitulo()) && sProyecto.getByTitulo(dtopro.getTitulo()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa proyecto ya existe"), HttpStatus.BAD_REQUEST);
        //No puede estar vacio
        if(StringUtils.isBlank(dtopro.getTitulo()))
            return new ResponseEntity(new Mensaje("El titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setUrl(dtopro.getUrl());
        proyecto.setPortada(dtopro.getPortada());
        proyecto.setTitulo(dtopro.getTitulo());
        proyecto.setDescripcion((dtopro.getDescripcion()));
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
             
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
    }
    
}