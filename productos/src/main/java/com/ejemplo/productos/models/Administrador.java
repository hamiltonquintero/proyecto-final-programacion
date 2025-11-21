package com.ejemplo.productos.models;

public class Administrador extends Usuario {
    private String areaResponsable;

    // Constructor vacío (necesario para Spring y JSON)
    public Administrador() {
        super();
    }

    // Constructor con parámetros
    public Administrador(String nombre, String email, String contrasena, String areaResponsable) {
        super(nombre, email, contrasena);
        this.areaResponsable = areaResponsable;
    }

    @Override
    public void actualizarDatos() {
        System.out.println("ADMIN: Actualizando credenciales del administrador: " + nombre);
    }

    // Getters y Setters
    public String getAreaResponsable() { return areaResponsable; }
    public void setAreaResponsable(String areaResponsable) { this.areaResponsable = areaResponsable; }
}