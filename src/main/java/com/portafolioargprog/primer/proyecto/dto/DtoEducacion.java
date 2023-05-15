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
public class DtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String periodo;
    @NotBlank
    private String nombre;
    @NotBlank
    private String detalle;

    public DtoEducacion() {
    }

    public DtoEducacion(String titulo, String periodo, String nombre, String detalle) {
        this.titulo = titulo;
        this.periodo = periodo;
        this.nombre = nombre;
        this.detalle = detalle;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
}
