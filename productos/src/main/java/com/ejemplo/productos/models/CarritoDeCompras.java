package com.ejemplo.productos.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CarritoDeCompras {
    private String cliente;
    private List<ItemCarrito> items;
    private Date fechaCreacion;
    private double total;

    // Constructor vacío para Spring
    public CarritoDeCompras() {
        this.items = new ArrayList<>();
        this.fechaCreacion = new Date();
        this.total = 0.0;
    }

    // Constructor con cliente
    public CarritoDeCompras(String cliente) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.fechaCreacion = new Date();
        this.total = 0.0;
    }

    public void agregarItem(Producto producto, int cantidad) {
        if (producto.verificarDisponibilidad(cantidad)) {
            items.add(new ItemCarrito(producto, cantidad));
            calcularTotal();
        } else {
            System.out.println("AVISO: Stock insuficiente para " + producto.getNombre());
        }
    }

    public double calcularTotal() {
        this.total = 0.0;
        for (ItemCarrito item : items) {
            this.total += item.calcularSubtotal();
        }
        return this.total;
    }

    public void mostrarResumen() {
        System.out.println("\n--- Resumen del Carrito para " + cliente + " ---");
        System.out.printf("Total Final: $%.2f\n", this.total);
    }

    public void vaciarCarrito() {
        this.items.clear();
        this.total = 0.0;
    }

    // Getters y Setters
    public String getCliente() { return cliente; }
    public void setCliente(String cliente) { this.cliente = cliente; }

    public List<ItemCarrito> getItems() { return items; }
    public void setItems(List<ItemCarrito> items) { this.items = items; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}