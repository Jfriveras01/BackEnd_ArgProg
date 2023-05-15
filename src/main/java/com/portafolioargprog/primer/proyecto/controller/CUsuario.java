/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.controller;

import com.portafolioargprog.primer.proyecto.Interface.IUsuarioService;
import com.portafolioargprog.primer.proyecto.entity.Usuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Fran
 */
@RestController
@RequestMapping("usuarios")//http://localhost:8080/usuarios
@CrossOrigin(origins = "http://localhost:4200")
public class CUsuario {
    @Autowired IUsuarioService iusuarioservice;
    
    @GetMapping("/traer")
    public List<Usuario> getUsuario(){
        return iusuarioservice.getUsuario();
    }
    
    @PostMapping("/crear")
    public String createUsuario(@RequestBody Usuario usuario){
        iusuarioservice.saveUsuario(usuario);
        return "El usuario fue creado correctamente";
    }
    
    @DeleteMapping("/borrar/{id}")
    public String deleteUsuario(@PathVariable Integer id){
        iusuarioservice.DeleteUsuario(id);
        return "El usuario fue borrado correctamente";
    }
    
    @PutMapping("/editar/{id}")
    public Usuario editUsuario(
                                @PathVariable int id,
                                @RequestParam("username") String nuevoUsername,
                                @RequestParam("password") String nuevoPassword,
                                @RequestParam("email") String nuevoEmail) {
            
            Usuario usuario = iusuarioservice.findUsuario(id);
            
            usuario.setUsername(nuevoUsername);
            usuario.setPassword(nuevoPassword);
            usuario.setEmail(nuevoEmail);
            
            iusuarioservice.saveUsuario(usuario);
            return usuario;
    }
            
   
}
