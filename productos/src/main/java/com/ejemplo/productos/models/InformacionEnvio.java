package com.ejemplo.productos.models;

import java.util.Date;

public class InformacionEnvio {
    private String tipoEnvio;
    private double costoEnvio;
    private String direccionEntrega;
    private Date fechaEstimadaEntrega;

    // Constructor vacío (necesario para Spring y JSON)
    public InformacionEnvio() {}

    // Constructor con parámetros
    public InformacionEnvio(String tipoEnvio, String direccionEntrega) {
        this.tipoEnvio = tipoEnvio;
        this.direccionEntrega = direccionEntrega;
        this.costoEnvio = calcularCostoEnvio();
        // Fecha estimada: 3 días después de la creación
        this.fechaEstimadaEntrega = new Date(System.currentTimeMillis() + 86400000L * 3);
    }

    // Método para calcular costo según tipo de envío
    public double calcularCostoEnvio() {
        return (tipoEnvio != null && tipoEnvio.equalsIgnoreCase("Express")) ? 10.00 : 5.00;
    }

    // Getters y Setters
    public String getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(String tipoEnvio) { this.tipoEnvio = tipoEnvio; }

    public double getCostoEnvio() { return costoEnvio; }
    public void setCostoEnvio(double costoEnvio) { this.costoEnvio = costoEnvio; }

    public String getDireccionEntrega() { return direccionEntrega; }
    public void setDireccionEntrega(String direccionEntrega) { this.direccionEntrega = direccionEntrega; }

    public Date getFechaEstimadaEntrega() { return fechaEstimadaEntrega; }
    public void setFechaEstimadaEntrega(Date fechaEstimadaEntrega) { this.fechaEstimadaEntrega = fechaEstimadaEntrega; }
}