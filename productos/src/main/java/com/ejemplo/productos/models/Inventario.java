package com.ejemplo.productos.models;

import java.util.ArrayList;
import java.util.List;

// Esta clase gestiona el inventario de productos disponibles en el sistema
// Permite agregar productos, disminuir stock y mostrar el inventario actual
public class Inventario {
    private List<Producto> productos; // Asociación con Producto

    // Constructor vacío (necesario para Spring y JSON)
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Agregar producto al inventario
    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    // Disminuir stock de un producto
    public void disminuirStock(Producto producto, int cantidad) {
        producto.disminuirStock(cantidad);
    }

    // Mostrar todos los productos del inventario con su stock actual
    public void listarInventario() {
        System.out.println("\n--- Inventario Actual ---");
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " | Precio: $" + p.calcularPrecioTotal() + " | Stock: " + p.getStock());
        }
        System.out.println("-------------------------");
    }

    // Buscar producto por nombre (case-insensitive)
    public Producto buscarProducto(String nombre) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    // Eliminar producto por nombre
    public boolean eliminarProducto(String nombre) {
        Producto producto = buscarProducto(nombre);
        if (producto != null) {
            return productos.remove(producto);
        }
        return false;
    }

    // Getters y Setters
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}