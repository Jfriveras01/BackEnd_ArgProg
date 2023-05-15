/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.Interface;

import java.util.List;
import com.portafolioargprog.primer.proyecto.entity.Usuario;

/**
 *
 * @author Fran
 */
public interface IUsuarioService {
    
    //trae una lista usuarios
    public List<Usuario> getUsuario();
    
    //guardar objeto de tipo usuario
    public void saveUsuario(Usuario usuario);
    
    //eliminar objeto por id
    public void DeleteUsuario(int id);
    
    //buscar un objeto por id
    public Usuario findUsuario(int id);
}
