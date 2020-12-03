/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utl.idgs702.prestamosutl.modelo;

/**
 *
 * @author Carrizal
 */
public class PrestamoHerramienta {
    private int idPrestamoHerramienta;
    private String fotoPrestamo;
    private String fotoDevolucion;
    private int estatus;
    private Prestamo prestamo;
    private Herramienta herramienta;

    public PrestamoHerramienta() {
    }

    public int getIdPrestamoHerramienta() {
        return idPrestamoHerramienta;
    }

    public void setIdPrestamoHerramienta(int idPrestamoHerramienta) {
        this.idPrestamoHerramienta = idPrestamoHerramienta;
    }

    public String getFotoPrestamo() {
        return fotoPrestamo;
    }

    public void setFotoPrestamo(String fotoPrestamo) {
        this.fotoPrestamo = fotoPrestamo;
    }

    public String getFotoDevolucion() {
        return fotoDevolucion;
    }

    public void setFotoDevolucion(String fotoDevolucion) {
        this.fotoDevolucion = fotoDevolucion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }
    
    
}
