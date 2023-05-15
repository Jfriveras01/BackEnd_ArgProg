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
public class DtoExperiencia {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    
    //Constructores

    public DtoExperiencia() {
    }

    public DtoExperiencia(String titulo, String descripcion, String img) {
        this.img = img;
        this.titulo = titulo;
        this.descripcion = descripcion;

    }
    //Getters & Setters

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    
}
