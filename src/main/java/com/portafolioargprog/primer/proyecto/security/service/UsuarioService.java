/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.security.service;

import com.portafolioargprog.primer.proyecto.security.Entity.Usuario;
import com.portafolioargprog.primer.proyecto.security.repository.IUsuarioRepository;

import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
@Transactional
public class UsuarioService {
    @Autowired
    IUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByUsername(String nombreUsuario){
        return iusuarioRepository.findByUsername(nombreUsuario);
    }
    
    public boolean existsByUsername(String nombreUsuario){
        return iusuarioRepository.existsByUsername(nombreUsuario);
    }
    
    public boolean existsByEmail(String email){
        return iusuarioRepository.existsByEmail(email);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
