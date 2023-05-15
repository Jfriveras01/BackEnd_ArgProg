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
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String tituloE;
    
    @NotNull
    private String periodoE;
    
    @NotNull
    private String nombreE;
    
    
    private String detalleE;
    
    
    //constructores
    public Educacion() {
    }

    public Educacion(String tituloE, String periodoE, String nombreE, String detalleE) {
        this.tituloE = tituloE;
        this.periodoE = periodoE;
        this.nombreE = nombreE;
        this.detalleE = detalleE;
 
    }
    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTituloE() {
        return tituloE;
    }

    public void setTituloE(String tituloE) {
        this.tituloE = tituloE;
    }
    
    public String getPeriodoe(){
        return periodoE;
    }
    
    public void setPeriodoE(String periodoE){
        this.periodoE = periodoE;
    }
   
    public String getNombreE(){
        return nombreE;
    }
    
    public void setNombreE(String nombreE){
        this.nombreE = nombreE;
    }
    
    public String getDetalleE() {
        return detalleE;
    }

    public void setDetalleE(String detalleE) {
        this.detalleE = detalleE;
    }
    
    
}