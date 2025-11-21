package com.ejemplo.productos.models;

import java.util.Date;

// Esta clase representa un descuento aplicable a productos dentro de un rango de fechas
public class Descuento {
    private String descripcion;
    private double porcentaje;
    private Date fechaInicio;
    private Date fechaFin;

    // Constructor vacío (necesario para Spring y JSON)
    public Descuento() {}

    // Constructor con parámetros
    public Descuento(String descripcion, double porcentaje, Date fechaInicio, Date fechaFin) {
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    // Verifica si el descuento está activo según la fecha actual
    public boolean estaActivo() {
        Date ahora = new Date();
        return ahora.after(fechaInicio) && ahora.before(fechaFin);
    }

    // Aplica el descuento solo si está activo, si no devuelve el precio original
    public double aplicarDescuento(double precioOriginal) {
        if (estaActivo()) {
            return precioOriginal * (1.0 - porcentaje);
        }
        return precioOriginal;
    }

    // Getters y Setters
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPorcentaje() { return porcentaje; }
    public void setPorcentaje(double porcentaje) { this.porcentaje = porcentaje; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }
}