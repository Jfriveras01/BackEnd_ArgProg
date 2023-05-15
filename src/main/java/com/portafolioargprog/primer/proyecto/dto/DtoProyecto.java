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
public class DtoProyecto {
    @NotBlank
    private String url;
    @NotBlank
    private String portada;
    @NotBlank
    private String titulo;
    private String descripcion;

    public DtoProyecto() {
    }

    public DtoProyecto(String url, String portada, String titulo, String descripcion) {
        this.url = url;
        this.portada = portada;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

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
    
    
}
