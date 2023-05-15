/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portafolioargprog.primer.proyecto.entity;

/**
 *
 * @author Fran
 */
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;


@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String img;
    
    @NotNull
    private String titulo_exp;
    
    @NotNull
    private String descripcion_exp;
    
    //Constructores

    public Experiencia() {
    }

    public Experiencia(String titulo_exp, String descripcion_exp) {
        this.titulo_exp = titulo_exp;
        this.descripcion_exp = descripcion_exp;
    }
    
    //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getTitulo_exp() {
        return titulo_exp;
    }

    public void getTitulo_exp(String titulo_exp) {
        this.titulo_exp = titulo_exp;
    }

    public String getDescripcion_exp() {
        return descripcion_exp;
    }

    public void setDescripcion_exp(String descripcion_exp) {
        this.descripcion_exp = descripcion_exp;
    }
    
}
