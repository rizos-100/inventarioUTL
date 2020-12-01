/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.utl.idgs702.prestamosutl.modelo;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author Carrizal
 */
public class Prestamo {
    private int idPrestamo;
    private Date fechaHoraPrestamo; 
    private Date fechaHoraDevolucion;
    private int estatus;
    private String tipo;
    private String observaciones;
    private Empleado empleado;
    private Solicitante solicitante;
    private List<PrestamoHerramienta> herramientas;

    public Prestamo() {
    }

    public List<PrestamoHerramienta> getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(List<PrestamoHerramienta> herramientas) {
        this.herramientas = herramientas;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaHoraPrestamo() {
        return fechaHoraPrestamo;
    }

    public void setFechaHoraPrestamo(Date fechaHoraPrestamo) {
        this.fechaHoraPrestamo = fechaHoraPrestamo;
    }

    public Date getFechaHoraDevolucion() {
        return fechaHoraDevolucion;
    }

    public void setFechaHoraDevolucion(Date fechaHoraDevolucion) {
        this.fechaHoraDevolucion = fechaHoraDevolucion;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    
    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Solicitante getSolicitante() {
        return solicitante;
    }

    public void setSolicitante(Solicitante solicitante) {
        this.solicitante = solicitante;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    
    
}
