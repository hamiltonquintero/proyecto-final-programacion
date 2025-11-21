package com.ejemplo.productos.models;

import java.util.ArrayList;
import java.util.List;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;
    private String categoria;

    private Descuento descuentoAplicado;
    private List<Resena> resenas = new ArrayList<>();

    // Constructor vacío (requerido por Spring)
    public Producto() {}

    // Constructor principal
    public Producto(String nombre, double precio, int stock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.categoria = categoria;
    }

    // Lógica de negocio
    public double calcularPrecioTotal() {
        double precioFinal = precio;
        if (descuentoAplicado != null && descuentoAplicado.estaActivo()) {
            precioFinal = descuentoAplicado.aplicarDescuento(precio);
        }
        return precioFinal;
    }

    public boolean verificarDisponibilidad(int cantidad) {
        return this.stock >= cantidad;
    }

    public void disminuirStock(int cantidad) {
        this.stock -= cantidad;
    }

    public void setDescuento(Descuento descuento) {
        this.descuentoAplicado = descuento;
    }

    public void agregarResena(Resena resena) {
        if (resena != null) {
            resenas.add(resena);
        }
    }

    public void mostrarResenas() {
        System.out.println("\nReseñas para " + nombre + ":");
        if (resenas.isEmpty()) {
            System.out.println("No hay reseñas disponibles.");
        } else {
            for (Resena r : resenas) {
                System.out.println(r);
            }
        }
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Descuento getDescuentoAplicado() { return descuentoAplicado; }
    public List<Resena> getResenas() { return resenas; }
}