package com.ejemplo.productos.models;

// Esta clase representa un ítem dentro del carrito de compras,
// compuesto por un producto y su cantidad
public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    // Constructor vacío (necesario para Spring y JSON)
    public ItemCarrito() {}

    // Constructor con parámetros
    public ItemCarrito(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Calcula el subtotal usando el precio total del producto (polimorfismo)
    public double calcularSubtotal() {
        return producto.calcularPrecioTotal() * cantidad;
    }

    // Getters y Setters
    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}