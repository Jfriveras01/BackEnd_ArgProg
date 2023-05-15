/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.service;

import com.portafolioargprog.primer.proyecto.Interface.IUsuarioService;
import com.portafolioargprog.primer.proyecto.entity.Usuario;
import com.portafolioargprog.primer.proyecto.repository.RUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Fran
 */
@Service
public class ImpUsuarioService implements IUsuarioService{
    @Autowired RUsuario rusuario;
    

    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> usuario = rusuario.findAll();
        return usuario;
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        rusuario.save(usuario);
    }

    @Override
    public void DeleteUsuario(int id) {
        rusuario.deleteById(id);
    }

    @Override
    public Usuario findUsuario(int id) {
        Usuario usuario = rusuario.findById(id).orElse(null);
        return usuario;
    }
    
}
