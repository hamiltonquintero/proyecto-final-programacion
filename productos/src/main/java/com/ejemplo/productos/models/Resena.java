package com.ejemplo.productos.models;

import java.util.Date;

public class Resena {
    private String clienteNombre;
    private int calificacion; // Escala de 1 a 5
    private String comentario;
    private Date fechaResena;

    // Constructor vacío (necesario para Spring y JSON)
    public Resena() {}

    // Constructor con parámetros
    public Resena(String clienteNombre, int calificacion, String comentario) {
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
        this.clienteNombre = clienteNombre;
        this.calificacion = calificacion;
        this.comentario = comentario;
        this.fechaResena = new Date();
    }

    // Getters y Setters
    public String getClienteNombre() { return clienteNombre; }
    public void setClienteNombre(String clienteNombre) { this.clienteNombre = clienteNombre; }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { 
        if (calificacion < 1 || calificacion > 5) {
            throw new IllegalArgumentException("La calificación debe estar entre 1 y 5.");
        }
        this.calificacion = calificacion; 
    }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Date getFechaResena() { return fechaResena; }
    public void setFechaResena(Date fechaResena) { this.fechaResena = fechaResena; }

    // Método para mostrar reseña en consola (útil para pruebas)
    public void mostrarResena() {
        System.out.println("  > Cliente: " + clienteNombre + " | Calificación: " + calificacion + "/5");
        System.out.println("    Comentario: \"" + comentario + "\" (Fecha: " + fechaResena + ")");
    }

    // Representación en texto (para logs o depuración)
    @Override
    public String toString() {
        return clienteNombre + " (" + calificacion + "/5): " + comentario + " [" + fechaResena + "]";
    }
}