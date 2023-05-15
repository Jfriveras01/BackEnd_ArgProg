/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.dto;

import jakarta.validation.constraints.NotBlank;

/**
 *
 * @author Fran
 */
public class DtoAboutme {
    
    @NotBlank
    private String foto;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String titulo;
    
    @NotBlank
    private String ubicacion;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank 
    private String banner;

    public DtoAboutme() {
    }

    public DtoAboutme(String foto, String nombre, String titulo, String ubicacion, String descripcion, String banner) {
        this.foto = foto;
        this.nombre = nombre;
        this.titulo = titulo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.banner = banner;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
    
    
    
    
}
